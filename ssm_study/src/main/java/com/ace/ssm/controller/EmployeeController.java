package com.ace.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ace.ssm.domain.Employee;
import com.ace.ssm.domain.Message;
import com.ace.ssm.service.DepartmentService;
import com.ace.ssm.service.EmployeeService;

@Controller
@RequestMapping(value="/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String findUserAll(Map<String,Object> map) {
		map.put("emps", employeeService.findAllUsers());
		return "emp/emps";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addEmpUI(Map<String,Object> map) {
		//获取所有部门的信息，并保持到map中共页面中显示
		map.put("depts", deptService.getDepts());
		HashMap<Boolean,String> sex=new HashMap<Boolean,String>();
		sex.put(true, "男");
		sex.put(false, "女");
		map.put("gender", sex);
		map.put("employee", new Employee());
		return "emp/add";
	}
	
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String addEmp(@Valid @ModelAttribute("employee")Employee emp,BindingResult bindingResult,Map<String,Object> map) {
		//添加用于校验的逻辑代码
		if(bindingResult.getFieldErrorCount()>0) {//表示有错误
			HashMap<Boolean,String> sex=new HashMap<Boolean,String>();
			sex.put(true, "男");
			sex.put(false, "女");
			map.put("gender", sex);
			map.put("depts", deptService.getDepts());
			return "emp/add";
		}
		   employeeService.addEmployee(emp);
		return "redirect:/emp/emps";//重定向到别的请求，直接重定向到页面用return "redirect:/views/success.jsp";
		
	}
	
	/**
	 *注解 @RequestBody的作用是把客户端传递过来的JSON数据转换成一个对象
	 *注解@ResponseBody的作用是把一个对象转换成JSON数据返回给客户端
	 * @param emp
	 * @return
	 */
	
	//https://ke.qq.com/webcourse/index.html#cid=2930535&term_id=103043120&taid=10184071836383079&type=1024&vid=5285890805927999716
	@RequestMapping(value="/json",method=RequestMethod.POST)
	@ResponseBody
	public Message validationEmpIdByJson(@RequestBody Employee emp) {
		//进行员工编号的合法性校验
		System.out.println("要添加的用户编号:"+emp.getEmpId());
		Employee employee=employeeService.findEmpByEmpId(emp.getEmpId());
		Message message=new Message(true,"用户编号可用！");
		if(employee!=null) {
			message.setMsg("对不起，该用户 编号已经被使用！");
			message.setStatus(false);
		}
		return  message;
	}
	
	//显示要修改的员工信息页面
	@RequestMapping(value="/{empId}",method=RequestMethod.GET)
	public String  updateEmpById(@PathVariable("empId")String empId,Map<String,Object> map) {
		//创业一个单选框的性别列表
		Map<Boolean,String> empSex=new HashMap<Boolean,String>();
		empSex.put(true, "男");
		empSex.put(false, "女");
		map.put("empSex", empSex);
		//获取所有的部门信息用于下拉列表显示
		map.put("depts", deptService.getDepts());
		//把当前要修改的员工编号对应的员工信息查询出来，并保持到模型中来
		Employee emp=employeeService.findEmpByEmpId(empId);
		if(emp!=null) {
			map.put("employee",emp);
		}else {
			map.put("employee", new Employee());
		}
		return "emp/update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateEmp(@Valid @ModelAttribute("employee") Employee emp,BindingResult bindingResult,Map<String,Object> map) {
		//添加用于校验的逻辑代码
				if(bindingResult.getFieldErrorCount()>0) {//表示有错误
					HashMap<Boolean,String> sex=new HashMap<Boolean,String>();
					sex.put(true, "男");
					sex.put(false, "女");
					map.put("empSex", sex);
					map.put("depts", deptService.getDepts());
					return "emp/update";
				}
		employeeService.updateEmp(emp);
		return "redirect:/emp/emps";
	}
	
	//员工信息的删除
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id")String empId) {
		System.out.println("要删除的员工编号："+empId);
		employeeService.deleteEmpById(empId);
		return "redirect:/emp/emps";
	}
}

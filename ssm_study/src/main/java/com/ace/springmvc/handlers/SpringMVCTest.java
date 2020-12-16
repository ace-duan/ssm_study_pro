package com.ace.springmvc.handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ace.springmvc.entities.Student;
import com.ace.springmvc.entities.User;
//https://ke.qq.com/course/159860?taid=859775143407732

//@SessionAttributes(types=User.class)//如果要在request中存放User类型的对象，则同时将该类型对象放入session域中
//@SessionAttributes-https://ke.qq.com/webcourse/159860/100184410#taid=859809503146100&vid=5285890787893797684
//@SessionAttributes 用于在多个请求之间共用某个模型属性数据
//@SessionAttributes-https://study.163.com/course/courseLearn.htm?courseId=1005999006#/learn/video?lessonId=1053365151&courseId=1005999006
//@SessionAttributes(types={User.class,Address.class})//如果要在request中存放User类型的对象，则同时将该类型对象放入session域中
//@SessionAttributes("names3")//如果要在request中存放names3对象，则同时将该对象放入session域中
//@SessionAttributes({"user"})//该注解只能放在类上，而不能放在方法上
//@SessionAttributes(value={"user"}, types= {String.class})//user对象和String类型的数据在加入到请求域时都会被自动放到会话session中
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

	private static final String SUCCESS = "success";

	// 有@ModelAttribute标记的方法，会在每个目标方法(controller中所有的方法)执行之前被SpringMVC调用
	// 1.经常在更新时使用
	// 2.在不改变原有代码的基础上，插入一个新方法
	// 当部分数据不需要修改时，用@ModelAttribute提前做一些处理
	// 被@ModelAttribute注解注释的方法会在此controller每个方法执行前被执行
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		System.out.println("@ModelAttribute method");
		if (id != null) {
			User user = new User(1, "tom", "1234", "123@qq", 12);
			System.out.println("从数据库中获取一个对象：" + user);
			map.put("user", user);// 约定：键值必须与目标方法入参类型首字母小写一致，与入参名没关系，如果不一致，可以在目标方法入参前加@ModelAttribute("map中键名")
			// https://ke.qq.com/course/159860?taid=859818093080692
			// https://study.163.com/course/courseLearn.htm?courseId=1005999006#/learn/video?lessonId=1053365151&courseId=1005999006
		}
	}

	/*
	 * 运行流程： 1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到了Map中，键为：user 2.Spring
	 * MVC从Map中取出User对象，并把表单的请求参数赋给该User对象的对应属性 3.SpringMvc把上述对象传入目标方法的参数
	 * 
	 * 注意：在@ModelAttribute修饰的方法中，放入到map时的键需要和目标方法入参类型的第一个字母小写的字符串一致！
	 * 这样才能可以用ModelAttribute中map的对象，否则目标方法调用时会新建一个对象赋值后作为参数传到目标方法的形参
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("修改：" + user);
		return SUCCESS;
	}
	@RequestMapping("/testException")
	public String testException() {
		System.out.println(1/0);
		return SUCCESS;
	}

	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User("tom", "123", "tom@1234", 15);
		map.put("user", user);
		map.put("school", "atguigu");
		return SUCCESS;
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		User user = new User("ace", "123", "tom@1234", 15);
		map.put("user", user);// 框架自动放到request域中
		map.put("names1", Arrays.asList("tom", "jerry", "mike"));
		return SUCCESS;
	}

	@RequestMapping("/testModelMap")
	public String testModelMap(ModelMap mm) {
		System.out.println(mm.getClass().getName());
		mm.put("names2", Arrays.asList("ace", "jerry", "mike"));// 框架自动放到request域中
		return SUCCESS;
	}

	@RequestMapping("/testModel")
	public String testModel(Model model) {
		System.out.println(model.getClass().getName());
		model.addAttribute("names3", Arrays.asList("model", "jerry", "mike"));// 框架自动放到request域中
		return SUCCESS;
	}
	@RequestMapping("/testInterceptor")
	public String testInterceptor() {
		System.out.println("处理请求的方法。。。");
		return SUCCESS;
	}
	
	//文件上传 https://study.163.com/course/courseLearn.htm?courseId=1005999006#/learn/video?lessonId=1053362205&courseId=1005999006
	@RequestMapping("/testUpload")
	public String testUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("文件描述信息："+desc);
		//jsp中上传的文件：file
		
		InputStream input = file.getInputStream();
		String filename = file.getOriginalFilename();
		OutputStream out = new FileOutputStream("/Users/ace/Desktop/"+filename);
		byte[] bs = new byte[1024];
		int len = -1;
		while((len = input.read(bs)) !=-1) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		//将file上传到服务器中的某一个硬盘文件中
		System.out.println("上传成功！");
		
		return SUCCESS;
	}

	// @ResponseBody的作用其实是将java对象转为json格式的数据（即将方法的返回值以json数组的形式返回给前台）。并告诉springmvc，此时的返回不是一个view页面，而是一个ajax调用的返回值即json数组[{"id":1,"name":"zs","age":23},{"id":2,"name":"ls","age":24},{"id":3,"name":"ww","age":25}]
	// @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
	@ResponseBody//会将结果返回给程序调用处，此注解需要结合jackson相关的jar包使用，否则无法转为json格式的数据
	@RequestMapping("/testJson")
	public List<Student> testJson() {
		Student stu1 = new Student(1, "zs", 23);
		Student stu2 = new Student(2, "ls", 24);
		Student stu3 = new Student(3, "ww", 25);
		List<Student> students = new ArrayList<>();
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		return students;
	}

	@RequestMapping("/testDateTimeFormat") // BindingResult作用：保存前一个参数的错误信息，如果Student格式化出错，会将错误信息传入result
	public String testDateTimeFormat(@Valid Student student, BindingResult result, Map<String, Object> map) {
		// System.out.println(student.getId()+","+student.getName()+","+student.getBirthday());
		if (result.getErrorCount() > 0) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
				map.put("errors", result.getFieldErrors());// 将错误信息放到request域中
			}
		}
		return SUCCESS;
	}
	// String[] s = {"aa","bb","cc"};
	// List<String> strlist = Arrays.asList(s);
	// for(String str:strlist){
	// System.out.println(str);
	// }

	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("time", new Date());

		return modelAndView;
	}

	@RequestMapping(value = "/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)
			throws IOException {
		System.out.println("testServletAPI: " + request + ", " + response);
		out.write("hello springmvc");
		// return SUCCESS;
	}

	@RequestMapping(value = "/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo: " + user);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("testRequestHeader, Accept-Language: " + al);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("testRequestParam, username:" + un + ",age:" + age);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("testRest PUT:" + id);
		return "redirect:/springmvc/success";
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id) {
		System.out.println("testRest Delete:" + id);
		return "redirect:/springmvc/success";
	}

	@RequestMapping(value = "/success")
	public String success() {
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable Integer id) {
		System.out.println("testRest Get:" + id);
		return SUCCESS;
	}
	//
	//// @PathVariable只支持一个属性value，类型是为String，代表绑定的属性名称。默认不传递时，绑定为同名的形参。
	//// 在@RequestMapping请求路径中，将需要传递的参数用花括号{}括起来，然后，通过@PathVariable("参数名称")获取URL中对应的参数值。
	//// 如果@PathVariable标明参数名称，则参数名称必须和URL中参数名称一致。
	// @RequestMapping("/viewUser/{id}/{name}")
	// public Map<String, Object> viewUser(@PathVariable("id") Integer idInt,
	// @PathVariable Integer name) {
	// System.out.println("@PathVariable中 请求参数 id = " + idInt);
	// Map<String, Object> user = new HashMap<>();
	// user.put("id", idInt);
	// user.put("name", name);
	// return user;
	// }
	// /**
	// * @Title viewUser2
	// * @Description @PathVariable未标注参数名称，则被注解参数名必须和URL中的一致
	// * @date 2018-12-15 11:08
	// */
	// @RequestMapping("/owners/{ownerId}")
	// public Map<String, Object> viewUser2(@PathVariable Integer ownerId) {
	// System.out.println("@PathVariable中 请求参数 ownerId = " + ownerId);
	// Map<String, Object> user = new HashMap<>();
	// user.put("id", ownerId);
	// user.put("name", "Lucy");
	// return user;
	// }

	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable Integer id) {
		System.out.println("testPathVariable-haha:");
		return SUCCESS;
	}

	@RequestMapping(value = "/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}

	@RequestMapping(value = "/testParamAndHeaders", params = { "username", "age!=10" }, headers = {
			"Accept-Language=zh-CN,zh;q=0.9,en;q=0.8" })
	public String testParamAndHeaders() {
		System.out.println("testParamAndHeaders");
		return SUCCESS;
	}

	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}

	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}

	@RequestMapping("/testI18n")
	public String testI18n() {
		return SUCCESS;
	}

}

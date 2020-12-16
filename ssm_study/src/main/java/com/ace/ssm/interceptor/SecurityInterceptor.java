package com.ace.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ace.ssm.domain.LoginUser;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("����·����"+request.getRequestURI()+"�������ˣ�");
		// ��ȡSession�򲢽���Ȩ�ޱȶ�
		HttpSession session = request.getSession();
		 LoginUser user = (LoginUser) session.getAttribute("user");
		 if(user != null) {
			 return true;//����
		 }else {
			 //�����ض��򵽵�¼ҳ��
			 response.sendRedirect(request.getContextPath()+"/login.jsp");
			 return false;
		 }
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Ŀ�괦����"+handler+"��ִ����");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}

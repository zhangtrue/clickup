package com.inspur.ch10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 在request范围中存储信息的案例
 */
public class RequestDemo03 extends HttpServlet {
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//向request中存放用户信息,两个参数
		request.setAttribute("userName", "zhangsan");
		request.setAttribute("password", "123");
		
		//从request中获取信息，一个参数，根据key获取value值
		String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		System.out.println("用户名："+userName+"\t密码："+password);
		//从request中删除信息，根据key值进行删除，从而移除password
		request.removeAttribute("password");
		password = (String)request.getAttribute("password");
		//删除后，再从request中获取密码信息
		System.out.println("密码从request中删除之后，密码为"+password);
	}
}

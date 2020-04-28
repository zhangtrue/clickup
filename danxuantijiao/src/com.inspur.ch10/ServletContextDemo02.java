package com.inspur.ch10;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 简单的网页访问次数的案例，利用ServletContext来实现。
 *
 */
public class ServletContextDemo02 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       //获取servletContext对象
		ServletContext application = getServletContext();
		//1.操作访问次数。
		Integer count = (Integer)application.getAttribute("count");
		if(count==null){//第一次访问的情况
			count = 0;
		}
		count++;
		application.setAttribute("count", count);
		System.out.println("该页面的访问次数为"+count);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       doGet(request,response);
	}
}

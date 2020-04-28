package com.inspur.ch10;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContextDemo03 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1、获取servletContext对象
		ServletContext application = this.getServletContext();
		//根据传递过来的虚拟路径获取该路径在服务器本地文件系统中的真实路径信息。
		System.out.println(application.getRealPath("/"));
		System.out.println(application.getRealPath("/ch10.txt"));
		//参数必须以“/”开始，“/”表示当前ServletContext对象上下文环境的根目录。等价于webroot
		//如果没有找到相匹配的url，则返回null。
		//URL u = application.getResource("/");
		URL u = application.getResource("/index.jsp");
		//URL:统一资源定位符，协议 服务器ip地址 端口号 目录 文件名 查询字符串等信息。
		System.out.println(u.getPath());
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}

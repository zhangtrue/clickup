package com.inspur.ch10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletConfig案例演示 
 */
public class ServletConfigDemo01 extends HttpServlet {
	
	private ServletConfig config;//定义成员变量

	//destroy方法
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	//doget方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charSet=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(config.getInitParameter("username"));
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

    //有参数的初始化方法
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

}

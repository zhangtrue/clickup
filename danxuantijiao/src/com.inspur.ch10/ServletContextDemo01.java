package com.inspur.ch10;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletContext案例:
 */
public class ServletContextDemo01 extends HttpServlet {
	
    private ServletConfig config;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //获取web应用的初始化参数信息。
		System.out.println(config.getServletContext().getInitParameter("username"));
		System.out.println(config.getServletContext().getInitParameter("password"));
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}

package com.inspur.ch10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request获取客户端信息的案例
 */
public class RequestDemo01 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取客户机信息
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String queryStr = request.getQueryString();
		String method = request.getMethod();
		String contextPath = request.getContextPath();
		response.setContentType("text/html;charSet=utf-8");
		PrintWriter out = response.getWriter();
		out.print(url);
		out.print("<br>");
		out.print(uri);
		out.print("<br>");
		out.print(queryStr);
		out.print("<br>");
		out.print(method);
		out.print("<br>");
		out.print(contextPath);
		// 获取请求头信息
		Enumeration names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			out.print(names.nextElement());
			out.print("<hr>");
		}
		out.print(request.getHeader("accept-language"));
		out.print("<hr>");
	}
}

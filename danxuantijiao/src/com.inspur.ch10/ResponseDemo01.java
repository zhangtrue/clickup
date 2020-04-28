package com.inspur.ch10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo01 extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		out.print("因您未登录，1秒后自动刷新到登录界面......");
		response.setHeader("Refresh", "1;url=" + request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/ch10/login.jsp");
	}

}

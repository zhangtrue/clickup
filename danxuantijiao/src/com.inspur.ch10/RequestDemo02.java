package com.inspur.ch10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户端请求参数的案例演示
 * 
 */
public class RequestDemo02 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 中文乱码的问题解决:第一种解决方法是在request.getParameter 之前设定服务端的编码格式和客户端一致
		request.setCharacterEncoding("UTF-8");
		// 获取客户端的请求参数信息
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] instes = request.getParameterValues("inst");
		String insteStr = "";
		// 把字符串数组信息转化为字符串信息。
		if (instes != null) {
			for (String temp : instes) {
				insteStr += temp + " ";
			}
		}
		// 获取请求参数中所有参数名
		Enumeration namesEnu = request.getParameterNames();
		String namesStr = "";
		while (namesEnu.hasMoreElements()) {
			namesStr += namesEnu.nextElement().toString() + " ";
		}
		// 获取请求参数的名称和value，存在map 中
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<Entry<String, String[]>> paramMapSet = paramMap.entrySet();
		String paramInfor = "";
		for (Entry<String, String[]> paramEntry : paramMapSet) {
			String paramName = paramEntry.getKey();
			String values[] = paramEntry.getValue();
			String valuesStr = java.util.Arrays.toString(values);
			paramInfor += paramName + "=" + valuesStr + " ";
		}
		// 将用户信息显示到界面上
		response.setContentType("text/html;charSet=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>用户编号信息</h3>");
		out.print(userid);
		out.println("<hr>");
		out.print("<h3>用户名信息</h3>");
		out.print(username);
		out.println("<hr>");
		out.print("<h3>用户性别信息</h3>");
		out.print(sex);
		out.println("<hr>");
		out.print("<h3>用户部门信息</h3>");
		out.print(dept);
		out.println("<hr>");
		out.print("<h3>用户兴趣爱好信息</h3>");
		out.print(insteStr);
		out.println("<hr>");
		out.print("<h3>参数名信息</h3>");
		out.print(namesStr);
		out.println("<hr>");
		out.print("<h3>参数信息</h3>");
		out.print(paramInfor);
		out.println("<hr>");
	}
}
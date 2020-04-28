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
 * ��ȡ�ͻ�����������İ�����ʾ
 * 
 */
public class RequestDemo02 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post ���������������:��һ�ֽ����������request.getParameter ֮ǰ�趨����˵ı����ʽ�Ϳͻ���һ��
		request.setCharacterEncoding("UTF-8");
		// ��ȡ�ͻ��˵����������Ϣ
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String[] instes = request.getParameterValues("inst");
		String insteStr = "";
		// ���ַ���������Ϣת��Ϊ�ַ�����Ϣ��
		if (instes != null) {
			for (String temp : instes) {
				insteStr += temp + " ";
			}
		}
		// ��ȡ������������в�����
		Enumeration namesEnu = request.getParameterNames();
		String namesStr = "";
		while (namesEnu.hasMoreElements()) {
			namesStr += namesEnu.nextElement().toString() + " ";
		}
		// ��ȡ������������ƺ�value������map ��
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<Entry<String, String[]>> paramMapSet = paramMap.entrySet();
		String paramInfor = "";
		for (Entry<String, String[]> paramEntry : paramMapSet) {
			String paramName = paramEntry.getKey();
			String values[] = paramEntry.getValue();
			String valuesStr = java.util.Arrays.toString(values);
			paramInfor += paramName + "=" + valuesStr + " ";
		}
		// ���û���Ϣ��ʾ��������
		response.setContentType("text/html;charSet=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>�û������Ϣ</h3>");
		out.print(userid);
		out.println("<hr>");
		out.print("<h3>�û�����Ϣ</h3>");
		out.print(username);
		out.println("<hr>");
		out.print("<h3>�û��Ա���Ϣ</h3>");
		out.print(sex);
		out.println("<hr>");
		out.print("<h3>�û�������Ϣ</h3>");
		out.print(dept);
		out.println("<hr>");
		out.print("<h3>�û���Ȥ������Ϣ</h3>");
		out.print(insteStr);
		out.println("<hr>");
		out.print("<h3>��������Ϣ</h3>");
		out.print(namesStr);
		out.println("<hr>");
		out.print("<h3>������Ϣ</h3>");
		out.print(paramInfor);
		out.println("<hr>");
	}
}
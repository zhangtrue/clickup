package com.inspur.ch10;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �򵥵���ҳ���ʴ����İ���������ServletContext��ʵ�֡�
 *
 */
public class ServletContextDemo02 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       //��ȡservletContext����
		ServletContext application = getServletContext();
		//1.�������ʴ�����
		Integer count = (Integer)application.getAttribute("count");
		if(count==null){//��һ�η��ʵ����
			count = 0;
		}
		count++;
		application.setAttribute("count", count);
		System.out.println("��ҳ��ķ��ʴ���Ϊ"+count);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       doGet(request,response);
	}
}

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
		//1����ȡservletContext����
		ServletContext application = this.getServletContext();
		//���ݴ��ݹ���������·����ȡ��·���ڷ����������ļ�ϵͳ�е���ʵ·����Ϣ��
		System.out.println(application.getRealPath("/"));
		System.out.println(application.getRealPath("/ch10.txt"));
		//���������ԡ�/����ʼ����/����ʾ��ǰServletContext���������Ļ����ĸ�Ŀ¼���ȼ���webroot
		//���û���ҵ���ƥ���url���򷵻�null��
		//URL u = application.getResource("/");
		URL u = application.getResource("/index.jsp");
		//URL:ͳһ��Դ��λ����Э�� ������ip��ַ �˿ں� Ŀ¼ �ļ��� ��ѯ�ַ�������Ϣ��
		System.out.println(u.getPath());
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}

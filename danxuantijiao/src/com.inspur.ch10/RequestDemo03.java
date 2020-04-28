package com.inspur.ch10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��request��Χ�д洢��Ϣ�İ���
 */
public class RequestDemo03 extends HttpServlet {
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��request�д���û���Ϣ,��������
		request.setAttribute("userName", "zhangsan");
		request.setAttribute("password", "123");
		
		//��request�л�ȡ��Ϣ��һ������������key��ȡvalueֵ
		String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		System.out.println("�û�����"+userName+"\t���룺"+password);
		//��request��ɾ����Ϣ������keyֵ����ɾ�����Ӷ��Ƴ�password
		request.removeAttribute("password");
		password = (String)request.getAttribute("password");
		//ɾ�����ٴ�request�л�ȡ������Ϣ
		System.out.println("�����request��ɾ��֮������Ϊ"+password);
	}
}

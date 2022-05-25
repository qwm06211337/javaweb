package com.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.entity.Admin;
@WebServlet("/show")
public class AdminListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ��뼯
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//���ղ���
		String realName = req.getParameter("realName");
		String userState = req.getParameter("state");
		int state = 2;//Ĭ�ϲ�ѯȫ��
		if(userState!=null) {
			state = Integer.parseInt(userState);
		}
		//���÷���
		List<Admin> list = new AdminDao().queryAdmin(realName,state);
		//����õ�ֵ���ø����ö���
		req.setAttribute("list", list);
		//ָ�����ݵ�չʾҳ��
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}

package com.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
@WebServlet("/changeState")
public class ChangeStateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收数据
		int id = Integer.parseInt(req.getParameter("id"));
		int state = Integer.parseInt(req.getParameter("state"));
		//调用方法
		int result = new AdminDao().changeState(id, state);
		resp.sendRedirect("show");
	}

}

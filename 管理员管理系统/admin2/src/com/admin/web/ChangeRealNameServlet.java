package com.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
@WebServlet("/changeRealName")
public class ChangeRealNameServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码集
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//接收页面数据
		int id = Integer.parseInt(req.getParameter("id"));
		String realName = req.getParameter("realName");
		//调用方法
		new AdminDao().changeRealName(id, realName);
		//执行完方法之后的操作
		resp.sendRedirect("show");
	}
}

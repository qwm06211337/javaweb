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
		//设置编码集
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//接收参数
		String realName = req.getParameter("realName");
		String userState = req.getParameter("state");
		int state = 2;//默认查询全部
		if(userState!=null) {
			state = Integer.parseInt(userState);
		}
		//调用方法
		List<Admin> list = new AdminDao().queryAdmin(realName,state);
		//将获得的值设置给内置对象
		req.setAttribute("list", list);
		//指定数据的展示页面
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}

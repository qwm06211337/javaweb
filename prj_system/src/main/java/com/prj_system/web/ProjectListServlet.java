package com.prj_system.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prj_system.dao.ProjectDao;
import com.prj_system.entity.Project;
@WebServlet("/all")
public class ProjectListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//调用方法
		List<Project> list = new ProjectDao().queryProject();
		req.setAttribute("list", list);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}

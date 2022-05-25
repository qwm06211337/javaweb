package com.prj_system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prj_system.dao.ProjectDao;
@WebServlet("/delByids")
public class DelByIdsServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ids = req.getParameterValues("ids");
		ProjectDao dao = new ProjectDao();
		for(String id:ids) {
			int i = Integer.parseInt(id);
			dao.delProject(i);
		}
		resp.sendRedirect("all");
	}
}

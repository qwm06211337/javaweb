package com.prj_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prj_system.entity.Project;
import com.prj_system.utils.BaseDao;
import com.prj_system.utils.DBUtils;

public class ProjectDao {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement smt=null;
	//全表查询
	public List<Project> queryProject(){
		String sql = "select * from  tb_prj";
		rs = BaseDao.executeSelect(sql, null);
		//处理结果及
		try {
			List<Project> list = new ArrayList<Project>();
			if(rs!=null) {
				while(rs.next()) {
					Project p = new Project();
					p.setPrjId(rs.getInt("prj_id"));
					p.setPrjName(rs.getString("prj_name"));
					p.setPrjStartDate(rs.getDate("prj_startDate"));
					p.setPrjEndDate(rs.getDate("prj_endDate"));
					p.setPrjManager(rs.getString("prj_manager"));
					p.setPrjSchedule(rs.getInt("prj_schedule"));
					list.add(p);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConn(conn, rs, smt);
		}
		return null;
	}
	//添加
	public int addProject(Project p) {
		String sql = "insert into tb_prj values(null,?,?,?,?,?)";
		return BaseDao.executeUpdate(sql, p.getPrjName(),p.getPrjStartDate(),
				p.getPrjEndDate(),p.getPrjManager(),p.getPrjSchedule());
	}
	//删除
	public int delProject(int id) {
		String sql = "delete from tb_prj where prj_id=?";
		return BaseDao.executeUpdate(sql, id);
	}
}

package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.admin.entity.Admin;
import com.admin.utils.BaseDao;
import com.admin.utils.DBUtils;

public class AdminDao {
	Connection conn = null;
	PreparedStatement smt = null;
	ResultSet rs = null;
	//全表查询
	public List<Admin> queryAdmin(String name,int state){
		String sql = null;
		if(name==null || name==""&&state==2){
			//查询全部
            sql = "select * from tb_admin";
            rs = BaseDao.executeSelect(sql, null);
        }
        if(name==""&&state==0 || name==""&&state==1){
            sql = "select * from tb_admin where userState=?";
            rs = BaseDao.executeSelect(sql, state);
        }
        if(name!=null&&state==2){
            sql = "select * from tb_admin where realName like concat('%',?,'%')";
            rs = BaseDao.executeSelect(sql, name);
        }
        if(name!=null&&state==0 || name!=null&&state==1){
            sql = "select * from tb_admin where userState=? and realName like concat('%',?,'%')";
            rs = BaseDao.executeSelect(sql, state,name);
        }
		
		//处理结果集
		try {
			List<Admin> list = new ArrayList<Admin>();
			if(rs!=null) {
				while(rs.next()) {
					Admin a = new Admin();
					a.setId(rs.getInt("id"));
					a.setUsername(rs.getString("username"));
					a.setRealName(rs.getString("realName"));
					a.setUserRole(rs.getString("userRole"));
					a.setUserState(rs.getInt("userState"));
					list.add(a);
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
	//修改状态
	public int changeState(int id,int userState) {
		String sql = "update tb_admin set userState=? where id=?";
		return BaseDao.executeUpdate(sql, userState,id);
	}
	//修改真实姓名
	public int changeRealName(int id,String realName) {
		String sql = "update tb_admin set realName=? where id=?";
		return BaseDao.executeUpdate(sql, realName,id);
	}
}

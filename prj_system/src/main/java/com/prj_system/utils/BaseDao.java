package com.prj_system.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	static Connection conn = null;
	static PreparedStatement smt = null;
	static ResultSet rs = null;
	//��ɾ��
	public static int executeUpdate(String sql,Object...obj) {
		//�������ݿ�����
		conn = DBUtils.getConn();
		//�������������
		try {
			 smt = conn.prepareStatement(sql);
			 //��ռλ����ֵ
			 for(int i=0;i<obj.length;i++) {
				 smt.setObject(i+1, obj[i]);
			 }
			 //ִ��sql
			 return smt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeConn(conn, rs, smt);
		}
		return 0;
	}
	//��ѯ����
	public static ResultSet executeSelect(String sql,Object...obj) {
		conn = DBUtils.getConn();
		try {
			smt = conn.prepareStatement(sql);
			if(obj!=null&&obj.length>0) {
				for(int i=0;i<obj.length;i++) {
					smt.setObject(i+1, obj[i]);
				}
			}
			return smt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

 package com.admin.entity;

public class Admin {
	private int id;
	private String username;
	private String realName;
	private String userRole;
	private int userState;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String username, String realName, String userRole, int userState) {
		super();
		this.id = id;
		this.username = username;
		this.realName = realName;
		this.userRole = userRole;
		this.userState = userState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", realName=" + realName + ", userRole=" + userRole
				+ ", userState=" + userState + "]";
	}
	
}

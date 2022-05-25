package com.prj_system.entity;

import java.util.Date;

public class Project {
	private int prjId;
	private String prjName;
	private Date prjStartDate;
	private Date prjEndDate;
	private String prjManager;
	private int prjSchedule;
	public Project() {
		super();
	}
	public Project(int prjId, String prjName, Date prjStartDate, Date prjEndDate, String prjManager, int prjSchedule) {
		super();
		this.prjId = prjId;
		this.prjName = prjName;
		this.prjStartDate = prjStartDate;
		this.prjEndDate = prjEndDate;
		this.prjManager = prjManager;
		this.prjSchedule = prjSchedule;
	}
	public int getPrjId() {
		return prjId;
	}
	public void setPrjId(int prjId) {
		this.prjId = prjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Date getPrjStartDate() {
		return prjStartDate;
	}
	public void setPrjStartDate(Date prjStartDate) {
		this.prjStartDate = prjStartDate;
	}
	public Date getPrjEndDate() {
		return prjEndDate;
	}
	public void setPrjEndDate(Date prjEndDate) {
		this.prjEndDate = prjEndDate;
	}
	public String getPrjManager() {
		return prjManager;
	}
	public void setPrjManager(String prjManager) {
		this.prjManager = prjManager;
	}
	public int getPrjSchedule() {
		return prjSchedule;
	}
	public void setPrjSchedule(int prjSchedule) {
		this.prjSchedule = prjSchedule;
	}
	@Override
	public String toString() {
		return "Project [prjId=" + prjId + ", prjName=" + prjName + ", prjStartDate=" + prjStartDate + ", prjEndDate="
				+ prjEndDate + ", prjManager=" + prjManager + ", prjSchedule=" + prjSchedule + "]";
	}
	

}

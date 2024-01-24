package com.gymmgmt.bean;

import java.sql.Timestamp;

public class Batch {

	private int batchid;
	private String batchType;
	private String time;
	private int totalStudents;
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public String getBatchType() {
		return batchType;
	}
	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public Batch(int batchid, String batchType, String time, int totalStudents) {
		super();
		this.batchid = batchid;
		this.batchType = batchType;
		this.time = time;
		this.totalStudents = totalStudents;
	}
	public Batch(int batchid, String batchType, String time) {
		super();
		this.batchid = batchid;
		this.batchType = batchType;
		this.time = time;
	}
	public Batch() {
		super();
	}
	 
	
}

package com.gymmgmt.bean;

public class Participants {

	private int participantId;
	private String participantName;
	private int participantAge;
	private String phoneNumber;
	private Integer batchid;
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public int getParticipantAge() {
		return participantAge;
	}
	public void setParticipantAge(int participantAge) {
		this.participantAge = participantAge;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getBatchid() {
		return batchid;
	}
	public void setBatchid(Integer batchid) {
		this.batchid = batchid;
	}
	public Participants(int participantId, String participantName, int participantAge, String phoneNumber,
			Integer batchid) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.participantAge = participantAge;
		this.phoneNumber = phoneNumber;
		this.batchid = batchid;
	}
	public Participants() {
		super();
	}
	@Override
	public String toString() {
		return "Participants [participantId=" + participantId + ", participantName=" + participantName
				+ ", participantAge=" + participantAge + ", phoneNumber=" + phoneNumber + ", batchid=" + batchid + "]";
	} 
	
	
}

package com.gymmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gymmgmt.bean.Batch;
import com.gymmgmt.bean.Participants;
import com.gymmgmt.resource.DbResource;

public class ParticipantsDao {

	public int storeParticipantsDetails(Participants participant) {
		try {
		Connection con = DbResource.getDbConnection();
		if(!isBatchCountExceeded(participant.getBatchid())){
			if(!checkIdparticipantExists(participant)) {
				PreparedStatement pstmt = con.prepareStatement("insert into participant(participant_name,participant_age,phone_no,batchid) values(?,?,?,?)");
				pstmt.setString(1,participant.getParticipantName());
				pstmt.setInt(2, participant.getParticipantAge());
				pstmt.setString(3, participant.getPhoneNumber());
				pstmt.setInt(4, participant.getBatchid());
				pstmt.executeUpdate();
				pstmt.close();
				return 1;
			}else
			return 2;
		}else {
			return 3;
		}
		} catch (Exception e) {
			System.err.println("Error when inserting record to participant table "+e.toString());
			return 0;
		}
	}

	private boolean isBatchCountExceeded(Integer batchid) throws Exception {
		int totalCount = 0;
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"select count(participant_id) from participant  where batchid= ? group by batchid ");
			pstmt.setInt(1, batchid);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt(1);
				
			}
			pstmt.close();
			rs.close();
			if (totalCount >= 3)
				return true;
			else
				return false;
		} catch (Exception e) {
			throw e;
		}
	}

	private boolean checkIdparticipantExists(Participants participant) throws SQLException {
		int totalCount = 0;
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"select count(*) from participant where participant_name =? and participant_age =? and phone_no =? and batchid =? ");
			pstmt.setString(1, participant.getParticipantName());
			pstmt.setInt(2, participant.getParticipantAge());
			pstmt.setString(3, participant.getPhoneNumber());
			pstmt.setInt(4, participant.getBatchid());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}
			pstmt.close();
			rs.close();
			if (totalCount == 0)
				return false;
			else
				return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Participants> findAllparticipantInfo() {
		List<Participants> listOfParticipants = new ArrayList<>();
			try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participant");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Participants participant = new Participants();
				participant.setParticipantId(rs.getInt(1));
				participant.setParticipantName(rs.getString(2));
				participant.setParticipantAge(rs.getInt(3));
				participant.setPhoneNumber(rs.getString(4));
				participant.setBatchid(rs.getInt(5));
				listOfParticipants.add(participant);

			}
			pstmt.close();
			rs.close();
			} catch (Exception e) {
				System.err.println("participant retrieve error "+e.toString());
			}
			return listOfParticipants;
		}
	
	public int deleteById(int id) {
			try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from participant where participant_id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();	
			pstmt.close();
			return 1;
			
			} catch (Exception e) {
				System.err.println("participant retrieve error "+e.toString());
				return 0;
			}
		}

	public Participants findParticipantById(int id) {
		Participants participant = new Participants();
			try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from participant where participant_id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				participant.setParticipantId(rs.getInt(1));
				participant.setParticipantName(rs.getString(2));
				participant.setParticipantAge(rs.getInt(3));
				participant.setPhoneNumber(rs.getString(4));
				participant.setBatchid(rs.getInt(5));
			}
			pstmt.close();
			rs.close();
			} catch (Exception e) {
				System.err.println("participant retrieve error "+e.toString());
			}
			return participant;
		}
	
	public int updateParticipantDetails(Participants participant,int id) {
		try {
		Connection con = DbResource.getDbConnection();
		if(!isBatchCountExceeded(participant.getBatchid())){
			if(!checkIdparticipantExists(participant)) {
				PreparedStatement pstmt = con.prepareStatement("update participant set participant_name =? , participant_age =? , phone_no =? , batchid =? where participant_id = ?");
				pstmt.setString(1,participant.getParticipantName());
				pstmt.setInt(2, participant.getParticipantAge());
				pstmt.setString(3, participant.getPhoneNumber());
				pstmt.setInt(4, participant.getBatchid());
				pstmt.setInt(5, id);
				pstmt.executeUpdate();
				pstmt.close();
				return 4;
			}else
			return 5;
		}else {
			return 6;
		}
		} catch (Exception e) {
			System.err.println("Error when updating record to participant table "+e.toString());
			return 0;
		}
	}
}
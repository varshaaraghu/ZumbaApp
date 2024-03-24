package com.gymmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.gymmgmt.bean.Batch;
import com.gymmgmt.resource.DbResource;

public class BatchDao {

	public int storeBatchDetails(Batch batch) {
		int result = 0;
		try {
			Connection con = DbResource.getDbConnection();
			 result = checkIfBatchExists(batch.getTime(),batch.getBatchid());
			if (result == 0) {
				PreparedStatement pstmt = con
						.prepareStatement("insert into batch(batchid,batch_type,time) values(?,?,?)");
				pstmt.setInt(1, batch.getBatchid());
				pstmt.setString(2, batch.getBatchType());
				pstmt.setString(3, batch.getTime().toString());
				pstmt.executeUpdate();
				pstmt.close();
				return 1;
			} else if(result == 1){
				result= 2;
			}else if(result == 2){
				result= 3;
			}else if(result == 3){
				result= 4;
			}
		} catch (Exception e) {
			System.err.println("Error while inserting record to batch table  " + e.toString());
			return 0;
		}
		return result;
	}

	

	private int checkIfBatchExists(String time,int id) throws Exception {
		// TODO Auto-generated method stub

		int totalCountByTime = 0;
		int totalCountById = 0;
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select count(*)  from batch where time=? ");
			pstmt.setString(1, time);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				totalCountByTime = rs.getInt(1);
			}
			pstmt.close();
			rs.close();
			pstmt = con.prepareStatement("select count(*)  from batch where batchid=? ");
			pstmt.setString(1, time);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				totalCountById = rs.getInt(1);
			}
			pstmt.close();
			rs.close();
			System.out.println("Time : "+totalCountByTime + "  Id : "+ totalCountById);
			if (totalCountByTime == 0 && totalCountById ==0 )
				return 0;
			else if(totalCountById != 0 && totalCountByTime == 0)
				return 1;
			else if(totalCountById == 0 && totalCountByTime != 0)
				return 2;
			else
				return 3;
		} catch (Exception e) {
			throw e;
		}

	}

	public int getTotalCountByBatch(int batchNo) {
		int totalCount = 0;
		try {

			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select count(*) from participant where batchid=?");
			pstmt.setInt(1, batchNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}
			pstmt.close();
			pstmt = con.prepareStatement("update batch set totalStudents = ? where batchid = ?");
			pstmt.setInt(1, totalCount);
			pstmt.setInt(2, batchNo);
			pstmt.executeUpdate();
			pstmt.close();
			rs.close();
			return totalCount;
		} catch (Exception e) {
			System.err.println("Error while inserting record to batch table  " + e.toString());
			return 0;
		}
	}

	public List<Batch> findAllBatchInfo() {
		List<Batch> listOfBatch = new ArrayList<>();
			try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from batch");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Batch batch = new Batch();
				batch.setBatchid(rs.getInt(1));
				batch.setBatchType(rs.getString(2));
				batch.setTime(rs.getString(3));
				batch.setTotalStudents(getTotalCountByBatch(rs.getInt(1)));
				listOfBatch.add(batch);
			}
			pstmt.close();
			rs.close();
			} catch (Exception e) {
				System.err.println("Batch retrieve error "+e.toString());
			}
			return listOfBatch;
		}
	
	public String findBatchTime(int id) {
			String time = null;
			try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select time from batch where batchid=? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				time = rs.getString(1);
			}
			pstmt.close();
			rs.close();
			} catch (Exception e) {
				System.err.println("Batch retrieve error "+e.toString());
			}
			return time;
		}
	
	public int deleteById(int id) {
		try {
		Connection con = DbResource.getDbConnection();
		
		PreparedStatement pstmt = con.prepareStatement("delete from participant where batchid=?");
		pstmt.setInt(1, id);
		pstmt.executeUpdate();	
		pstmt.close();
		 pstmt = con.prepareStatement("delete from batch where batchid=?");
		pstmt.setInt(1, id);
		pstmt.executeUpdate();	
		pstmt.close();
		
		return 1;
		
		} catch (Exception e) {
			System.err.println("participant retrieve error "+e.toString());
			return 0;
		}
	}

	public int updateBatchDetails(Batch batch) {
		int result = 0;
		try {
			Connection con = DbResource.getDbConnection();
			 result = checkIfBatchExists(batch.getTime(),batch.getBatchid());
			if (result == 0) {
				PreparedStatement pstmt = con
						.prepareStatement("update  batch set batch_type=?,time=? where batchid = ? ");
				pstmt.setInt(3, batch.getBatchid());
				pstmt.setString(1, batch.getBatchType());
				pstmt.setString(2, batch.getTime().toString());
				pstmt.executeUpdate();
				pstmt.close();
				
				return 1;
			} else if(result == 1){
				result= 2;
			}else if(result == 2){
				result= 3;
			}else if(result == 3){
				result= 4;
			}
		} catch (Exception e) {
			System.err.println("Error while inserting record to batch table  " + e.toString());
			return 0;
		}
		return result;
	}
}

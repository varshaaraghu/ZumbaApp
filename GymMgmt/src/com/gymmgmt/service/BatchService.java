package com.gymmgmt.service;

import java.util.List;

import com.gymmgmt.bean.Batch;
import com.gymmgmt.dao.BatchDao;

public class BatchService {

	BatchDao batchDao = new BatchDao();
	public int storeBatch(Batch batch) {
		int result = batchDao.storeBatchDetails(batch);
		if(result==1) {
			return 1;
		}else if(result==2)  {
			return 2;
		}else if(result==3)  {
			return 3;
		}else if(result==4)  {
			return 3;
		}else
			return 0;
	}
	public List<Batch> findAllBatch(){
		return batchDao.findAllBatchInfo();
	}
	
	
	public int getTotalCountByBatch(int batchNo) throws Exception{
		int totalCount = batchDao.getTotalCountByBatch(batchNo);
			return totalCount;			
	}
	
	public String findBatchTime(int id){
		return batchDao.findBatchTime(id);
	}
	
	public String deleteById(int id) {
		if( batchDao.deleteById(id) ==1)
			return "Deleted";
		else
			return "Not deleted";
	}
	
	public int updateBatchDetails(Batch batch) {
		int result = batchDao.updateBatchDetails(batch);
		if(result==1) {
			return 1;
		}else if(result==2)  {
			return 2;
		}else if(result==3)  {
			return 3;
		}else if(result==4)  {
			return 3;
		}else
			return 0;
	}
}

package com.gymmgmt.service;

import java.util.List;

import com.gymmgmt.bean.Participants;
import com.gymmgmt.dao.ParticipantsDao;

public class ParticipantsService {

	ParticipantsDao pd = new ParticipantsDao();
	public int storeParticipant(Participants participant) {
		int result = pd.storeParticipantsDetails(participant );
		if(result ==1) {
			return 1;
		}else if (result == 2){
			return 2;
		}else if (result == 3){
			return 3;
		}else
			return 0;
	}
	public List<Participants> findAllParticipant() {
		return pd.findAllparticipantInfo();
	}
	
	public String deleteById(int id) {
		if( pd.deleteById(id) ==1)
			return "Deleted";
		else
			return "Not deleted";
	}
	
	public Participants findParticipantById(int id) {
		return pd.findParticipantById(id);
	}
	public int updateParticipantDetails(Participants participant, int id) {
		int result = pd.updateParticipantDetails(participant,id );
		if(result==4) {
			return 4;
		}else if (result == 5){
			return 2;
		}else if (result == 6){
			return 3;
		}else
			return 0;
	}
}

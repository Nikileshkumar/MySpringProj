package com.infy.MySpringBoot.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.MySpringBoot.entity.MessagesEntity;

public interface MultiMessageDAO extends JpaRepository<MessagesEntity, Integer>{
	@Query("from MessagesEntity m where m.queueId=?1")
	public ArrayList<MessagesEntity> getAllMsgs(int QueueId);
	
	
}

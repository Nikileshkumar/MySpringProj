package com.infy.MySpringBoot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.MySpringBoot.DAO.MultiMessageDAO;
import com.infy.MySpringBoot.DAO.MultiQueueDAO;
import com.infy.MySpringBoot.entity.MessagesEntity;
import com.infy.MySpringBoot.entity.MultiQueueEntity;

@Service
public class MultiQueueService {
	@Autowired
	private MultiMessageDAO messageDAO;
	@Autowired
	private MultiQueueDAO queueDAO;
	private MessagesEntity messagesEntity;
	private MultiQueueEntity queueEntity;

	public String addMessage(int queueId, String data) {
		messagesEntity=new MessagesEntity();
		messagesEntity.setQueueId(queueId);
		messagesEntity.setData(data);
		messageDAO.save(messagesEntity);
		MultiQueueEntity queueEntity = queueDAO.getOne(queueId);
		queueEntity.setCurrentCount(queueEntity.getCurrentCount() + 1);
		queueDAO.save(queueEntity);
		return "Message added";
	}

	public String deleteMessage(int msgId) {
		messagesEntity = messageDAO.getOne(msgId);
		int queueId = messagesEntity.getQueueId();
		messageDAO.deleteById(msgId);
		MultiQueueEntity queueEntity = queueDAO.getOne(queueId);
		queueEntity.setCurrentCount(queueEntity.getCurrentCount() - 1);
		queueDAO.save(queueEntity);
		return "Message deleted";
	}

	public String getMessageData(int msgId) {
		messagesEntity = messageDAO.getOne(msgId);
		return messagesEntity.getData();
	}

	public String addQueue(String name, int maxSize) {
		queueEntity=new MultiQueueEntity();
		queueEntity.setName(name);
		queueEntity.setMaxCount(maxSize);
		queueDAO.save(queueEntity);
		return "Queue added";
	}

	public String deleteQueue(int queueId) {
		messageDAO.deleteAll(messageDAO.getAllMsgs(queueId));
		queueDAO.deleteById(queueId);
		return "Queue deleted";
	}

	public ArrayList<MultiQueueEntity> getAllQueue() {
		return (ArrayList<MultiQueueEntity>) queueDAO.findAll();
		
	}

	public ArrayList<MessagesEntity> getAllMsgs(int queueId) {
		return  messageDAO.getAllMsgs(queueId);
	}

}

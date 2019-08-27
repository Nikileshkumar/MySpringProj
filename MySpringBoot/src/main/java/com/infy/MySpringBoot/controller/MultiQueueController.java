package com.infy.MySpringBoot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.MySpringBoot.entity.MessagesEntity;
import com.infy.MySpringBoot.entity.MultiQueueEntity;
import com.infy.MySpringBoot.model.MultiMessage;
import com.infy.MySpringBoot.model.MultiQueue;
import com.infy.MySpringBoot.service.MultiQueueService;

@RestController
public class MultiQueueController {
	@Autowired
	private MultiQueueService queueService;

	@RequestMapping(value="/addMessage", method = RequestMethod.POST)
	public String addMessage( @RequestBody MultiMessage message) {
		return queueService.addMessage(message.getQueueId(), message.getMsg());
		//asdjkhfkjasdhfjklhaskdjfhlasdjkhfks
	}
	@RequestMapping(value="/deleteMessage/{msgId}", method = RequestMethod.GET)
	public String deleteMessage(@PathVariable("msgId") int msgId) {
		return queueService.deleteMessage(msgId);
	}
	@RequestMapping(value="/getMessage/{msgId}", method = RequestMethod.GET)
	public String getMessage(@PathVariable("msgId") int msgId) {
		return queueService.getMessageData(msgId);
	}
	
	@RequestMapping(value="/addQueue", method = RequestMethod.POST)
	public String addQueue( @RequestBody MultiQueue queue) {
		return queueService.addQueue(queue.getName(), queue.getMaxCount());
	}
	@RequestMapping(value="/deleteQueue/{queueId}", method = RequestMethod.GET)
	public String deleteQueue(@PathVariable("queueId") int queueId) {
		return queueService.deleteQueue(queueId);
	}
	@RequestMapping(value="/getAllMessage/{queueId}", method = RequestMethod.GET)
	public ArrayList<MessagesEntity> getAllMessage(@PathVariable("queueId") int queueId) {
		return queueService.getAllMsgs(queueId);
	}
	@RequestMapping(value="/getAllQueue", method = RequestMethod.GET)
	public ArrayList<MultiQueueEntity> getAllQueue() {
		return queueService.getAllQueue();
	}
}

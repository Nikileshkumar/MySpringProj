package com.infy.MySpringBoot.model;

import java.util.ArrayList;
import java.util.Queue;

public class MultiQueue {
	private int id;
	private String name;
	private int maxCount;
	private int currentCount;
	private ArrayList<MultiMessage> msges;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public ArrayList<MultiMessage> getMsges() {
		return msges;
	}
	public void setMsges(ArrayList<MultiMessage> msges) {
		this.msges = msges;
	}

}

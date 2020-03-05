package com.abhi.crickgo.model;

import java.util.ArrayList;

public class England {

	private static England _instance;

	private ArrayList<String> list = new ArrayList<String>();

	private England() {

	}

	public static England getInstance() {
		if (_instance == null) {
			_instance = new England();
		}
		return _instance;

	}

	public void addPlayer(String name) {
		if (!list.contains(name)) {
			list.add(name);
		}
	}

	public ArrayList<String> getPlayers() {
		return list;
	}
}

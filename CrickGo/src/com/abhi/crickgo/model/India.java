package com.abhi.crickgo.model;

import java.util.ArrayList;

public class India {

	private static India _instance;

	private ArrayList<String> list = new ArrayList<String>();

	private India() {

	}

	public static India getInstance() {
		if (_instance == null) {
			_instance = new India();
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

package com.abhi.crickgo.model;

import java.util.ArrayList;

public class Australia {

	private static Australia _instance;

	private ArrayList<String> list = new ArrayList<String>();

	private Australia() {

	}

	public static Australia getInstance() {
		if (_instance == null) {
			_instance = new Australia();
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

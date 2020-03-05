package com.abhi.crickgo.model;

import java.util.ArrayList;

public class SouthAfrica {

	private static SouthAfrica _instance;

	private ArrayList<String> list = new ArrayList<String>();

	private SouthAfrica() {

	}

	public static SouthAfrica getInstance() {
		if (_instance == null) {
			_instance = new SouthAfrica();
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

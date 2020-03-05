package com.abhi.crickgo.model;

import java.util.ArrayList;

public class PlayerList {
	private static PlayerList _instance = null;
	private ArrayList<Player> players = new ArrayList<Player>();

	private PlayerList() {

	}

	public static PlayerList getInstance() {
		if (_instance == null) {
			_instance = new PlayerList();
		}
		return _instance;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getAllPlayers() {
		return players;
	}
}

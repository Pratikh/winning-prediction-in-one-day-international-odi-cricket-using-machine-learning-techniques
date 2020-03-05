package com.abhi.crickgo.model;

import java.util.ArrayList;

public class MatchList {
	private static MatchList _instance = null;
	private ArrayList<Match> matches = new ArrayList<Match>();

	private Match selectedMatch;

	private MatchList() {

	}

	public static MatchList getInstance() {
		if (_instance == null) {
			_instance = new MatchList();
		}
		return _instance;
	}

	public void addMatch(Match player) {
		matches.add(player);
	}

	public ArrayList<Match> getAllMatchs() {
		return matches;
	}

	public void clearList() {
		if (matches != null) {
			matches.clear();
		}
	}

	public void setSelectedMatch(int mid) {
		for (Match match : matches) {
			if (match.getMid() == mid) {
				selectedMatch = match;
				break;
			}
		}
	}

	public Match getSelectedMatch() {
		return this.selectedMatch;
	}

}

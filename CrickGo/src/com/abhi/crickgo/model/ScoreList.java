package com.abhi.crickgo.model;

import java.util.ArrayList;

public class ScoreList {
	private static ScoreList _instance = null;
	private ArrayList<Score> scores = new ArrayList<Score>();

	private ScoreList() {

	}

	public static ScoreList getInstance() {
		if (_instance == null) {
			_instance = new ScoreList();
		}
		return _instance;
	}

	public void addScore(Score score) {
		scores.add(score);
	}

	public ArrayList<Score> getAllScores() {
		return scores;
	}

	public void clearList() {
		if (scores != null) {
			scores.clear();
		}
	}

	public ArrayList<Score> getScoresForMatch(int mid) {
		ArrayList<Score> list = new ArrayList<Score>();
		for (Score score : scores) {
			if (score.getMid() == mid) {
				list.add(score);
			}
		}

		return list;
	}

}

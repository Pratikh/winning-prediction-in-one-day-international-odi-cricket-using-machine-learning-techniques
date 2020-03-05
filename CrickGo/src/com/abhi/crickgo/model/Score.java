package com.abhi.crickgo.model;

public class Score {
	private int sid;
	private int runs;
	private int no_of_wickets;
	private String overs;
	private String player1;
	private String player2;
	private String wickets;
	private String team;
	private long timestamp;
	private int mid;
	private int playing_status;

	public Score(int sid, int runs, int no_of_wickets, String overs,
			String player1, String player2, String wickets, String team,
			long timestamp, int mid, int playing_status) {
		this.sid = sid;
		this.runs = runs;
		this.no_of_wickets = no_of_wickets;
		this.overs = overs;
		this.player1 = player1;
		this.player2 = player2;
		this.wickets = wickets;
		this.team = team;
		this.timestamp = timestamp;
		this.mid = mid;
		this.playing_status = playing_status;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getNo_of_wickets() {
		return no_of_wickets;
	}

	public void setNo_of_wickets(int no_of_wickets) {
		this.no_of_wickets = no_of_wickets;
	}

	public String getOvers() {
		return overs;
	}

	public void setOvers(String overs) {
		this.overs = overs;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getPlaying_status() {
		return playing_status;
	}

	public void setPlaying_status(int playing_status) {
		this.playing_status = playing_status;
	}

}

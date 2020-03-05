package com.abhi.crickgo.model;

public class Match {
	private int mid;
	private String team1;
	private String team2;
	private int toss;
	private String ground;

	public Match(int mid, String team1, String team2, int toss, String ground) {
		this.mid = mid;
		this.team1 = team1;
		this.team2 = team2;
		this.toss = toss;
		this.ground = ground;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getToss() {
		return toss;
	}

	public void setToss(int toss) {
		this.toss = toss;
	}

	public String getGround() {
		return ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

}

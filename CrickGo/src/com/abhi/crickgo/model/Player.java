package com.abhi.crickgo.model;

public class Player {

	private String team;
	private String ground;
	private String result;
	private boolean chasing;

	public Player() {

	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getGround() {
		return ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isChasing() {
		return chasing;
	}

	public void setChasing(boolean chasing) {
		this.chasing = chasing;
	}

}

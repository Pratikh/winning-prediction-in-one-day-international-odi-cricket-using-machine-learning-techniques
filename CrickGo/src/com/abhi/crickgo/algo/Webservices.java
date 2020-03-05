package com.abhi.crickgo.algo;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.abhi.crickgo.model.Australia;
import com.abhi.crickgo.model.England;
import com.abhi.crickgo.model.India;
import com.abhi.crickgo.model.Match;
import com.abhi.crickgo.model.MatchList;
import com.abhi.crickgo.model.Score;
import com.abhi.crickgo.model.ScoreList;
import com.abhi.crickgo.model.SouthAfrica;

public class Webservices {

	public static void getMatches() {
		try {
			MatchList.getInstance().clearList();
			URL url = new URL(
					"http://localhost/CrickAdmin/admin/getmatches.php");
			final HttpURLConnection conn = (HttpURLConnection) url
					.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/xml");
			conn.setDoOutput(true);
			conn.connect();
			final int code = conn.getResponseCode();
			final String contentType = conn.getContentType();
			final StringBuffer responseText = new StringBuffer();
			InputStreamReader in = new InputStreamReader(conn.getInputStream(),
					"UTF-8");

			char[] msg = new char[2048];
			int len;
			while ((len = in.read(msg)) > 0) {
				responseText.append(msg, 0, len);
			}
			JsonReader reader = Json.createReader(new StringReader(responseText
					.toString()));
			JsonObject jsonObject = reader.readObject();
			JsonArray array = jsonObject.getJsonArray("data");
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = array.getJsonObject(i);
				String midStr = object.getString("mid");
				int mid = Integer.parseInt(midStr);
				String team1 = object.getString("team1");
				String team2 = object.getString("team2");
				String tossStr = object.getString("toss");
				int toss = Integer.parseInt(tossStr);
				String ground = object.getString("ground");
				Match match = new Match(mid, team1, team2, toss, ground);
				MatchList.getInstance().addMatch(match);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getScoreList(int mid) {
		try {
			ScoreList.getInstance().clearList();
			URL url = new URL(
					"http://localhost/CrickAdmin/admin/getScores.php?mid="
							+ mid);
			final HttpURLConnection conn = (HttpURLConnection) url
					.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/xml");
			conn.setDoOutput(true);
			conn.connect();
			final int code = conn.getResponseCode();
			final String contentType = conn.getContentType();
			final StringBuffer responseText = new StringBuffer();
			InputStreamReader in = new InputStreamReader(conn.getInputStream(),
					"UTF-8");

			char[] msg = new char[2048];
			int len;
			while ((len = in.read(msg)) > 0) {
				responseText.append(msg, 0, len);
			}
			JsonReader reader = Json.createReader(new StringReader(responseText
					.toString()));
			JsonObject jsonObject = reader.readObject();
			JsonArray array = jsonObject.getJsonArray("data");
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = array.getJsonObject(i);
				String sidStr = object.getString("sid");
				int sid = Integer.parseInt(sidStr);
				String runsStr = object.getString("runs");
				int runs = Integer.parseInt(runsStr);
				String no_of_wicketsStr = object.getString("no_of_wickets");
				int no_of_wickets = Integer.parseInt(no_of_wicketsStr);
				String overs = object.getString("overs");
				String player1 = object.getString("player1");
				String player2 = object.getString("player2");
				String wickets = object.getString("wickets");
				String team = object.getString("team");
				String strTime = object.getString("timestamp");
				long timestamp = Long.parseLong(strTime);
				String playing_statusStr = object.getString("playing_status");
				int playing_status = Integer.parseInt(playing_statusStr);
				Score score = new Score(sid, runs, no_of_wickets, overs,
						player1, player2, wickets, team, timestamp, mid,
						playing_status);
				ScoreList.getInstance().addScore(score);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getTeamPlayers() {
		try {
			URL url = new URL(
					"http://localhost/CrickAdmin/admin/getTeamPlayers.php");
			final HttpURLConnection conn = (HttpURLConnection) url
					.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/xml");
			conn.setDoOutput(true);
			conn.connect();
			final int code = conn.getResponseCode();
			final String contentType = conn.getContentType();
			final StringBuffer responseText = new StringBuffer();
			InputStreamReader in = new InputStreamReader(conn.getInputStream(),
					"UTF-8");

			char[] msg = new char[2048];
			int len;
			while ((len = in.read(msg)) > 0) {
				responseText.append(msg, 0, len);
			}
			JsonReader reader = Json.createReader(new StringReader(responseText
					.toString()));
			JsonObject jsonObject = reader.readObject();
			JsonArray array = jsonObject.getJsonArray("data1");
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = array.getJsonObject(i);
				String pname = object.getString("pname");
				India.getInstance().addPlayer(pname);

			}

			array = jsonObject.getJsonArray("data2");
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = array.getJsonObject(i);
				String pname = object.getString("pname");
				Australia.getInstance().addPlayer(pname);

			}

			array = jsonObject.getJsonArray("data3");
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = array.getJsonObject(i);
				String pname = object.getString("pname");
				England.getInstance().addPlayer(pname);

			}

			array = jsonObject.getJsonArray("data4");
			for (int i = 0; i < array.size(); i++) {
				JsonObject object = array.getJsonObject(i);
				String pname = object.getString("pname");
				SouthAfrica.getInstance().addPlayer(pname);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

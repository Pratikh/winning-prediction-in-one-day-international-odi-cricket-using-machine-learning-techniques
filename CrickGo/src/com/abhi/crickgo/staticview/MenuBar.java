package com.abhi.crickgo.staticview;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.management.JMException;

public class MenuBar extends JMenuBar {

	public final JMenu ground, team1, team2, score, toss, graph;
	public final JMenuItem selectGround, selectTeam1, selectTeam2, viewScore,
			selectToss, viewGraph;

	public ImageIcon[] icons;

	public String[] imgNames = { "images/ground.png", "images/team1.png",
			"images/team2.png", "images/toss.png", "images/scoreboard.png",
			"images/graph.png", "images/exit.png" };

	public MenuBar() {

		this.add(ground = new JMenu("Ground"));
		this.add(team1 = new JMenu("Team1"));
		this.add(team2 = new JMenu("Team2"));
		this.add(toss = new JMenu("Toss"));
		this.add(score = new JMenu("Score"));
		this.add(graph = new JMenu("Graph"));

		ground.setMnemonic('g');
		team1.setMnemonic('t');
		team2.setMnemonic('o');
		score.setMnemonic('s');
		icons = new ImageIcon[7];

		for (int i = 0; i < imgNames.length; i++) {

			icons[i] = new ImageIcon(ClassLoader.getSystemResource(imgNames[i]));
		}

		ground.add(selectGround = new JMenuItem("Select Ground", icons[0]));
		team1.add(selectTeam1 = new JMenuItem("Select Team1", icons[1]));
		team2.add(selectTeam2 = new JMenuItem("Select Team2", icons[2]));
		toss.add(selectToss = new JMenuItem("Select Toss", icons[3]));
		score.add(viewScore = new JMenuItem("View Stats", icons[4]));
		graph.add(viewGraph = new JMenuItem("View Graph", icons[5]));

	}
}

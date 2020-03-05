package com.abhi.crickgo.staticview;

import javax.swing.*;

public class Toolbar extends JToolBar {

	public JButton[] btn;
	public String[] imgNames = { "images/ground.png", "images/team1.png",
			"images/team2.png", "images/toss.png", "images/scoreboard.png",
			"images/ic_joint.png", "images/graph.png", "images/exit.png" };
	public String[] tipText = { "Select Ground", "Select Team1",
			"Select Team2", "Select Toss", "View Score", "Team Combination",
			"View Graph", "Exit" };

	public Toolbar() {
		btn = new JButton[8];
		for (int i = 0; i < imgNames.length; i++) {
			addSeparator();
			add(btn[i] = new JButton(new ImageIcon(
					ClassLoader.getSystemResource(imgNames[i]))));
			btn[i].setToolTipText(tipText[i]);
		}
	}
}
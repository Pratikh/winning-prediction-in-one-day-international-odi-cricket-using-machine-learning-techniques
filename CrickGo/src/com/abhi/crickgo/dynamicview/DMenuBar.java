package com.abhi.crickgo.dynamicview;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DMenuBar extends JMenuBar {

	public final JMenu match, score, graph;
	public final JMenuItem selectMatch, viewScore, viewGraph;

	public ImageIcon[] icons;

	public String[] imgNames = { "images/ic_match.png",
			"images/dscoreboard.png", "images/dgraph.png", "images/dexit.png" };

	public DMenuBar() {
		this.add(match = new JMenu("Match"));
		this.add(score = new JMenu("Score"));
		this.add(graph = new JMenu("Graph"));

		score.setMnemonic('s');
		icons = new ImageIcon[4];

		for (int i = 0; i < imgNames.length; i++) {

			icons[i] = new ImageIcon(ClassLoader.getSystemResource(imgNames[i]));
		}

		match.add(selectMatch = new JMenuItem("Select Match", icons[0]));
		score.add(viewScore = new JMenuItem("View Stats", icons[1]));
		graph.add(viewGraph = new JMenuItem("View Graph", icons[2]));

	}
}

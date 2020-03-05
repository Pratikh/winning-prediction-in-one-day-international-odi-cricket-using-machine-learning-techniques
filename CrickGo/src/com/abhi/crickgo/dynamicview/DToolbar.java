package com.abhi.crickgo.dynamicview;

import javax.swing.*;

public class DToolbar extends JToolBar {

	public JButton[] btn;
	public String[] imgNames = { "images/ic_match.png",
			"images/dscoreboard.png", "images/dgraph.png", "images/dexit.png" };
	public String[] tipText = { "Select Match", "View Score", "View Graph",
			"Exit" };

	public DToolbar() {
		btn = new JButton[4];
		for (int i = 0; i < imgNames.length; i++) {
			addSeparator();
			add(btn[i] = new JButton(new ImageIcon(
					ClassLoader.getSystemResource(imgNames[i]))));
			btn[i].setToolTipText(tipText[i]);
		}
	}
}
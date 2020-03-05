package com.abhi.crickgo.staticview;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TeamComination extends JInternalFrame {
	private JPanel bg = new JPanel();
	JLabel bgVal = new JLabel(new ImageIcon(
			ClassLoader.getSystemResource("images/ic_comb.jpg")));

	public TeamComination() {

		super("Team Combination", false, true, false, true);
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/ic_joint.png")));
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		bg.add(bgVal);
		cp.add(bg);
		setVisible(true);
		pack();
	}

}
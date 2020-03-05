package com.abhi.crickgo.dynamicview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.abhi.crickgo.algo.Webservices;
import com.abhi.crickgo.model.Match;
import com.abhi.crickgo.model.MatchList;

public class DSelectMatch extends JInternalFrame implements ActionListener {

	private JPanel match_panel = new JPanel();
	private JButton btnDone = new JButton("Done");
	private ButtonGroup bG = new ButtonGroup();

	public DSelectMatch() {

		super("Select Match", false, true, false, true);
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/ic_match.png")));
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		Webservices.getMatches();
		match_panel.setLayout(new FlowLayout());
		ArrayList<Match> list = MatchList.getInstance().getAllMatchs();
		for (Match match : list) {
			String matchStr = match.getTeam1() + "	VS	" + match.getTeam2();
			String action = String.valueOf(match.getMid());
			JRadioButton radioMatch = new JRadioButton(matchStr);
			radioMatch.setActionCommand(action);
			bG.add(radioMatch);
			match_panel.add(radioMatch);
		}

		btnDone.setFont(new Font("Tahoma", Font.BOLD, 11));
		match_panel.setPreferredSize(new Dimension(800, 200));
		match_panel.add(btnDone);
		cp.add(match_panel);
		setVisible(true);
		pack();
		btnDone.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnDone) {
			String data = bG.getSelection().getActionCommand();
			int mid = Integer.parseInt(data);
			MatchList.getInstance().setSelectedMatch(mid);
			Webservices.getTeamPlayers();
		}

	}

}
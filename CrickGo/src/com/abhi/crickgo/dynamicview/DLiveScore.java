package com.abhi.crickgo.dynamicview;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.abhi.crickgo.algo.Webservices;
import com.abhi.crickgo.model.Match;
import com.abhi.crickgo.model.MatchList;
import com.abhi.crickgo.model.Score;
import com.abhi.crickgo.model.ScoreList;

public class DLiveScore extends JInternalFrame implements ActionListener {

	private JButton btnDone = new JButton("Refresh");

	private JPanel runsPanel = new JPanel();
	private JLabel runLabel = new JLabel();
	private JLabel player1Label = new JLabel();
	private JLabel player2Label = new JLabel();

	private JPanel wicketPanel = new JPanel();
	private JLabel wicketLabel = new JLabel(
			"<html><br/><font color='red'>Wicket List:-><br/></html>");
	private String column[] = { "Sr No", "Player", "Runs" };
	private String dataTeam1[][];
	private JTable wicketTable;

	private JPanel btPanel = new JPanel();

	private Match selectedMatch = null;

	public DLiveScore() {

		super("Live Score", false, true, false, true);
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/dscoreboard.png")));
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.setPreferredSize(new Dimension(700, 500));
		selectedMatch = MatchList.getInstance().getSelectedMatch();
		runsPanel.setLayout(new BoxLayout(runsPanel, BoxLayout.Y_AXIS));
		runsPanel.add(runLabel);
		runsPanel.add(player1Label);
		runsPanel.add(player2Label);
		cp.add(runsPanel);
		wicketPanel.add(wicketLabel);
		wicketPanel.setLayout(new BoxLayout(wicketPanel, BoxLayout.Y_AXIS));
		cp.add(wicketPanel);
		btPanel.setLayout(new BoxLayout(btPanel, BoxLayout.Y_AXIS));
		btPanel.add(btnDone);
		cp.add(btPanel);

		btnDone.setFont(new Font("Tahoma", Font.BOLD, 11));
		setVisible(true);
		pack();
		btnDone.addActionListener(this);
		updateScore();
	}

	public void updateScore() {
		Webservices.getScoreList(selectedMatch.getMid());
		ArrayList<Score> list = ScoreList.getInstance().getScoresForMatch(
				selectedMatch.getMid());
		Score tScore = null;
		if (list.size() == 1) {
			tScore = list.get(0);

		} else if (list.size() == 2) {
			tScore = list.get(1);
		}

		StringBuilder score = new StringBuilder();
		score.append("<html><br/><br/>" + tScore.getTeam() + ":");
		score.append(tScore.getRuns() + "/" + tScore.getNo_of_wickets()
				+ "<br/>");

		score.append("<br/>Overs:" + tScore.getOvers() + "</html>");
		runLabel.setText(score.toString());

		String player1 = tScore.getPlayer1();
		player1Label.setText("<html><br/><font color='green'>" + player1
				+ "</html>");
		String player2 = tScore.getPlayer2();
		player2Label.setText("<html><br/><font color='green'>" + player2
				+ "<br/><br/></html>");

		String wicket_list = tScore.getWickets();
		dataTeam1 = new String[11][3];
		if (wicket_list != null && wicket_list.length() > 0) {
			String tokens[] = wicket_list.split(";");
			for (int i = 0; i < tokens.length; i++) {
				String subTokens[] = tokens[i].split(":");
				dataTeam1[i][0] = String.valueOf(i + 1);
				dataTeam1[i][1] = subTokens[0];
				dataTeam1[i][2] = subTokens[1];
			}

			wicketTable = new JTable(dataTeam1, column);
			wicketTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,
					10));
			wicketPanel.removeAll();
			wicketPanel.add(new JScrollPane(wicketTable));
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnDone) {
			updateScore();
		}

	}

}
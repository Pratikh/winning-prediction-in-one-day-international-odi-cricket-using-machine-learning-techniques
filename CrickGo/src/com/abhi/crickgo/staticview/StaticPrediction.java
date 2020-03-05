package com.abhi.crickgo.staticview;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.abhi.crickgo.algo.DTreePredictor;

public class StaticPrediction extends JInternalFrame implements ItemListener,
		ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel groundPanel = new JPanel();

	private JPanel mainPanel = new JPanel();
	private JPanel team1Panel = new JPanel();
	private JPanel team2Panel = new JPanel();

	// //ground
	private JLabel lblGround = new JLabel("Stadium:");
	private JLabel lblGroundVal = new JLabel();

	// /Team1
	private JPanel bg1 = new JPanel();
	private JPanel bg2 = new JPanel();
	JLabel bg1Val = new JLabel(new ImageIcon(
			ClassLoader.getSystemResource("images/ic_india.png")));
	JLabel bg2Val = new JLabel(new ImageIcon(
			ClassLoader.getSystemResource("images/ic_aus.png")));
	JLabel bg3Val = new JLabel(new ImageIcon(
			ClassLoader.getSystemResource("images/ic_eng.png")));

	JLabel bg4Val = new JLabel(new ImageIcon(
			ClassLoader.getSystemResource("images/ic_sa.png")));

	private JPanel t1Name = new JPanel();
	private JLabel lblt1NameVal = new JLabel();

	private JTable t1Table;

	private JPanel t1Score = new JPanel();
	private JLabel lblt1Score = new JLabel("Predicted Score Team1");
	private JLabel lblt1ScoreVal = new JLabel();

	// /Team2
	private JPanel t2Name = new JPanel();
	private JLabel lblt2NameVal = new JLabel();

	private JTable t2Table;

	private JPanel t2Score = new JPanel();
	private JLabel lblt2Score = new JLabel("Predicted Score Team1");
	private JLabel lblt2ScoreVal = new JLabel();
	private String column[] = { "Sr No", "Player", "Score" };
	private String dataTeam1[][];
	private String dataTeam2[][];

	private JPanel empty = new JPanel();

	public StaticPrediction() {
		super("Predictions", false, true, false, true);

		dataTeam1 = new String[11][3];
		dataTeam2 = new String[11][3];

		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/scoreboard.png")));
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.setPreferredSize(new Dimension(800, 400));

		lblGroundVal.setText(StaticData.ground);
		groundPanel.add(lblGround);
		groundPanel.add(lblGroundVal);
		cp.add("North", groundPanel);

		lblt1NameVal.setText(StaticData.team1Name);
		t1Name.add(lblt1NameVal);

		double predictedScoreT1 = 0.0;
		ArrayList<String> player1 = StaticData.team1;
		int i = 0;
		for (String player : player1) {
			String res = DTreePredictor.getPredictionForPlayer(player,
					StaticData.team2Name, StaticData.ground,
					StaticData.team1Chasing);

			String tokens[] = res.split(":");
			int pscore = (int) (Double.parseDouble(tokens[0]));
			predictedScoreT1 += pscore;
			dataTeam1[i][0] = String.valueOf(i + 1);
			dataTeam1[i][1] = player;
			dataTeam1[i][2] = String.valueOf(pscore);
			i++;

		}
		t1Table = new JTable(dataTeam1, column);
		t1Table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		StaticData.team1Score = (int) predictedScoreT1;

		team1Panel.setLayout(new BoxLayout(team1Panel, BoxLayout.Y_AXIS));
		team1Panel.add(t1Name);
		if (StaticData.team1Name.equalsIgnoreCase("india")) {
			bg1.add(bg1Val);
		} else if (StaticData.team1Name.equalsIgnoreCase("australia")) {
			bg1.add(bg2Val);

		} else if (StaticData.team1Name.equalsIgnoreCase("england")) {
			bg1.add(bg3Val);

		} else if (StaticData.team1Name.equalsIgnoreCase("south africa")) {
			bg1.add(bg4Val);
		}

		if (StaticData.team2Name.equalsIgnoreCase("india")) {
			bg2.add(bg1Val);
		} else if (StaticData.team2Name.equalsIgnoreCase("australia")) {
			bg2.add(bg2Val);

		} else if (StaticData.team2Name.equalsIgnoreCase("england")) {
			bg2.add(bg3Val);

		} else if (StaticData.team2Name.equalsIgnoreCase("south africa")) {
			bg2.add(bg4Val);
		}

		team1Panel.add(bg1);
		team1Panel.add(new JScrollPane(t1Table));

		lblt1Score.setText("Predicted Score " + StaticData.team1Name + " : ");
		lblt1ScoreVal.setText(predictedScoreT1 + "");

		t1Score.add(lblt1Score);
		t1Score.add(lblt1ScoreVal);
		team1Panel.add(t1Score);

		lblt2NameVal.setText(StaticData.team2Name);
		t2Name.add(lblt2NameVal);

		double predictedScoreT2 = 0.0;
		ArrayList<String> player2 = StaticData.team2;

		String team2Chasing = "";
		if (StaticData.team1Chasing.equalsIgnoreCase("false")) {
			team2Chasing = "true";
		} else {
			team2Chasing = "false";
		}

		i = 0;
		for (String player : player2) {
			String res = DTreePredictor.getPredictionForPlayer(player,
					StaticData.team1Name, StaticData.ground, team2Chasing);

			String tokens[] = res.split(":");
			int pscore = (int) (Double.parseDouble(tokens[0]));
			predictedScoreT2 += pscore;
			dataTeam2[i][0] = String.valueOf(i + 1);
			dataTeam2[i][1] = player;
			dataTeam2[i][2] = String.valueOf(pscore);
			i++;
		}

		t2Table = new JTable(dataTeam2, column);
		t2Table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		StaticData.team2Score = (int) predictedScoreT2;
		team2Panel.setLayout(new BoxLayout(team2Panel, BoxLayout.Y_AXIS));
		team2Panel.add(t2Name);
		team2Panel.add(bg2);
		team2Panel.add(new JScrollPane(t2Table));

		lblt2Score.setText("Predicted Score " + StaticData.team2Name + " : ");
		lblt2ScoreVal.setText(predictedScoreT2 + "");

		t2Score.add(lblt2Score);
		t2Score.add(lblt2ScoreVal);
		team2Panel.add(t2Score);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(team1Panel);
		mainPanel.add(empty);
		mainPanel.add(team2Panel);

		cp.add("North", mainPanel);

		setVisible(true);
		pack();
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

	}

}
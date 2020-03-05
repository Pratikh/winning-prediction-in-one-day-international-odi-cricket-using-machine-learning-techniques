package com.abhi.crickgo.dynamicview;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.abhi.crickgo.algo.DTreePredictor;
import com.abhi.crickgo.algo.Webservices;
import com.abhi.crickgo.model.Australia;
import com.abhi.crickgo.model.England;
import com.abhi.crickgo.model.India;
import com.abhi.crickgo.model.Match;
import com.abhi.crickgo.model.MatchList;
import com.abhi.crickgo.model.Score;
import com.abhi.crickgo.model.ScoreList;
import com.abhi.crickgo.model.SouthAfrica;

public class DynamicPrediction extends JInternalFrame implements ItemListener,
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
	private JLabel lblt2Score = new JLabel("Predicted Score Team2");
	private JLabel lblt2ScoreVal = new JLabel();
	private String column[] = { "Sr No", "Player", "Score" };
	private String dataTeam1[][];
	private String dataTeam2[][];

	private JPanel empty = new JPanel();

	private JButton btnDone = new JButton("Refresh");

	private Match selectedMatch;
	ArrayList<String> player1 = null;
	ArrayList<String> player2 = null;

	boolean team1Chasing;

	public DynamicPrediction() {
		super("Predictions", false, true, false, true);
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/scoreboard.png")));
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.setPreferredSize(new Dimension(800, 400));

		selectedMatch = MatchList.getInstance().getSelectedMatch();
		team1Chasing = selectedMatch.getToss() == 2;

		String team1Name = selectedMatch.getTeam1();
		String team2Name = selectedMatch.getTeam2();

		if (team1Name.equalsIgnoreCase("india")) {
			player1 = India.getInstance().getPlayers();
		} else if (team1Name.equalsIgnoreCase("australia")) {
			player1 = Australia.getInstance().getPlayers();
		} else if (team1Name.equalsIgnoreCase("england")) {
			player1 = England.getInstance().getPlayers();
		}

		else if (team1Name.equalsIgnoreCase("south africa")) {
			player1 = SouthAfrica.getInstance().getPlayers();
		}

		if (team2Name.equalsIgnoreCase("india")) {
			player2 = India.getInstance().getPlayers();
		} else if (team2Name.equalsIgnoreCase("australia")) {
			player2 = Australia.getInstance().getPlayers();
		} else if (team2Name.equalsIgnoreCase("england")) {
			player2 = England.getInstance().getPlayers();
		}

		else if (team2Name.equalsIgnoreCase("south africa")) {
			player2 = SouthAfrica.getInstance().getPlayers();
		}

		if (team1Name.equalsIgnoreCase("india")) {
			bg1Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_india.png")));
		} else if (team1Name.equalsIgnoreCase("australia")) {
			bg1Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_aus.png")));
		}

		else if (team1Name.equalsIgnoreCase("england")) {
			bg1Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_eng.png")));
		}

		else if (team1Name.equalsIgnoreCase("south africa")) {
			bg1Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_sa.png")));
		}

		if (team2Name.equalsIgnoreCase("india")) {
			bg2Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_india.png")));
		} else if (team2Name.equalsIgnoreCase("australia")) {
			bg2Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_aus.png")));
		}

		else if (team2Name.equalsIgnoreCase("england")) {
			bg2Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_eng.png")));
		}

		else if (team2Name.equalsIgnoreCase("south africa")) {
			bg2Val = new JLabel(new ImageIcon(
					ClassLoader.getSystemResource("images/ic_sa.png")));
		}
		dataTeam1 = new String[11][3];
		dataTeam2 = new String[11][3];

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(team1Panel);
		mainPanel.add(empty);
		mainPanel.add(team2Panel);

		cp.add("North", mainPanel);
		cp.add("North", btnDone);
		btnDone.addActionListener(this);
		setVisible(true);
		pack();
		update();
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		update();
	}

	private void update() {
		int i = 0;
		t1Score.removeAll();
		team1Panel.removeAll();
		t2Score.removeAll();
		team2Panel.removeAll();
		mainPanel.removeAll();
		dataTeam1 = new String[11][3];
		dataTeam2 = new String[11][3];
		Webservices.getScoreList(selectedMatch.getMid());
		ArrayList<Score> scores = ScoreList.getInstance().getScoresForMatch(
				selectedMatch.getMid());
		if (scores.size() == 1) {
			Score scr = scores.get(0);
			double predictedScoreT1 = 0.0;

			HashMap<String, String> outMap = new HashMap<String, String>();
			String outs[] = scr.getWickets().split(";");
			if (outs.length > 1) {
				for (int k = 0; k < outs.length; k++) {
					String player[] = outs[k].split(":");
					outMap.put(player[0], player[1]);
				}
			}

			i = 0;
			for (String player : player1) {
				int pscore = 0;
				if (outMap.containsKey(player)) {
					pscore = Integer.parseInt(outMap.get(player));
				} else {
					String res = DTreePredictor.getPredictionForPlayer(player,
							selectedMatch.getTeam2(),
							selectedMatch.getGround(),
							String.valueOf(team1Chasing).toLowerCase());

					String tokens[] = res.split(":");
					pscore = (int) (Double.parseDouble(tokens[0]));
				}
				predictedScoreT1 += pscore;
				dataTeam1[i][0] = String.valueOf(i + 1);
				dataTeam1[i][1] = player;
				dataTeam1[i][2] = String.valueOf(pscore);
				i++;

			}

			i = 0;
			String team2Chasing = "";
			if (team1Chasing) {
				team2Chasing = "true";
			} else {
				team2Chasing = "false";
			}
			double predictedScoreT2 = 0.0;
			for (String player : player2) {
				String res = DTreePredictor.getPredictionForPlayer(player,
						selectedMatch.getTeam1(), selectedMatch.getGround(),
						team2Chasing);

				String tokens[] = res.split(":");
				int pscore = (int) (Double.parseDouble(tokens[0]));
				predictedScoreT2 += pscore;
				dataTeam2[i][0] = String.valueOf(i + 1);
				dataTeam2[i][1] = player;
				dataTeam2[i][2] = String.valueOf(pscore);
				i++;
			}
			t1Table = new JTable(dataTeam1, column);
			t1Table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			DynamicData.team1Score = (int) predictedScoreT1;

			team1Panel.setLayout(new BoxLayout(team1Panel, BoxLayout.Y_AXIS));
			team1Panel.add(t1Name);
			if (selectedMatch.getTeam1().equalsIgnoreCase("india")) {
				bg1.add(bg1Val);
				bg2.add(bg2Val);
			} else {
				bg1.add(bg2Val);
				bg2.add(bg1Val);
			}

			team1Panel.add(bg1);
			team1Panel.add(new JScrollPane(t1Table));

			lblt1Score.setText("Predicted Score " + selectedMatch.getTeam1()
					+ " : ");
			lblt1ScoreVal.setText(predictedScoreT1 + "");

			t1Score.add(lblt1Score);
			t1Score.add(lblt1ScoreVal);
			team1Panel.add(t1Score);

			t2Table = new JTable(dataTeam2, column);
			t2Table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			DynamicData.team2Score = (int) predictedScoreT2;
			team2Panel.setLayout(new BoxLayout(team2Panel, BoxLayout.Y_AXIS));
			team2Panel.add(t2Name);
			team2Panel.add(bg2);
			team2Panel.add(new JScrollPane(t2Table));

			lblt2Score.setText("Predicted Score " + selectedMatch.getTeam2()
					+ " : ");
			lblt2ScoreVal.setText(predictedScoreT2 + "");

			t2Score.add(lblt2Score);
			t2Score.add(lblt2ScoreVal);
			team2Panel.add(t2Score);

			mainPanel.add(team1Panel);
			mainPanel.add(empty);
			mainPanel.add(team2Panel);

		} else if (scores.size() == 2) {

			i = 0;
			double predictedScoreT1 = 0.0;
			Score scrT1 = scores.get(0);

			HashMap<String, String> t1Map = new HashMap<String, String>();
			String outs1[] = scrT1.getWickets().split(";");
			for (int k = 0; k < outs1.length; k++) {
				String player[] = outs1[k].split(":");
				t1Map.put(player[0], player[1]);

			}

			String player1 = scrT1.getPlayer1();
			String player2 = scrT1.getPlayer2();
			String player1s[] = player1.split(":");
			t1Map.put(player1s[0], player1s[1]);
			String player2s[] = player2.split(":");
			t1Map.put(player2s[0], player2s[1]);

			List<String> keys = new ArrayList<String>(t1Map.keySet());
			List<String> values = new ArrayList<String>(t1Map.values());

			for (int l = 0; l < keys.size(); l++) {
				int pscore = Integer.parseInt(values.get(l));
				dataTeam1[l][0] = String.valueOf(l + 1);
				dataTeam1[l][1] = keys.get(l);
				dataTeam1[l][2] = String.valueOf(pscore);
				predictedScoreT1 += pscore;
			}

			Score scr = scores.get(1);
			double predictedScoreT2 = 0.0;

			HashMap<String, String> outMap = new HashMap<String, String>();
			String outs[] = scr.getWickets().split(";");
			for (int k = 0; k < outs.length; k++) {
				String player[] = outs[k].split(":");
				if (player != null && player.length == 2) {
					outMap.put(player[0], player[1]);
				}
			}

			String team = scr.getTeam();

			ArrayList<String> playersIn = new ArrayList<String>();
			if (team.equalsIgnoreCase("india")) {
				playersIn = India.getInstance().getPlayers();
			} else if (team.equalsIgnoreCase("australia")) {
				playersIn = Australia.getInstance().getPlayers();
			}

			i = 0;
			for (String player : playersIn) {
				int pscore = 0;
				if (outMap.containsKey(player)) {
					pscore = Integer.parseInt(outMap.get(player));
				} else {
					String res = DTreePredictor.getPredictionForPlayer(player,
							scores.get(0).getTeam(), selectedMatch.getGround(),
							"true");

					String tokens[] = res.split(":");
					pscore = (int) (Double.parseDouble(tokens[0]));
				}
				predictedScoreT2 += pscore;
				dataTeam2[i][0] = String.valueOf(i + 1);
				dataTeam2[i][1] = player;
				dataTeam2[i][2] = String.valueOf(pscore);
				i++;

			}

			t1Table = new JTable(dataTeam1, column);
			t1Table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			DynamicData.team1Score = (int) predictedScoreT1;

			team1Panel.setLayout(new BoxLayout(team1Panel, BoxLayout.Y_AXIS));
			team1Panel.add(t1Name);
			String team1Name = selectedMatch.getTeam1();
			String team2Name = selectedMatch.getTeam2();

			if (team1Name.equalsIgnoreCase("india")) {
				bg1Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_india.png")));
			} else if (team1Name.equalsIgnoreCase("australia")) {
				bg1Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_aus.png")));
			}

			else if (team1Name.equalsIgnoreCase("england")) {
				bg1Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_eng.png")));
			}

			else if (team1Name.equalsIgnoreCase("south africa")) {
				bg1Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_sa.png")));
			}

			if (team2Name.equalsIgnoreCase("india")) {
				bg2Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_india.png")));
			} else if (team2Name.equalsIgnoreCase("australia")) {
				bg2Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_aus.png")));
			}

			else if (team2Name.equalsIgnoreCase("england")) {
				bg2Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_eng.png")));
			}

			else if (team2Name.equalsIgnoreCase("south africa")) {
				bg2Val = new JLabel(new ImageIcon(
						ClassLoader.getSystemResource("images/ic_sa.png")));
			}
			team1Panel.add(bg1);
			team1Panel.add(new JScrollPane(t1Table));

			lblt1Score.setText("Predicted Score " + selectedMatch.getTeam1()
					+ " : ");
			lblt1ScoreVal.setText(predictedScoreT1 + "");

			t1Score.add(lblt1Score);
			t1Score.add(lblt1ScoreVal);
			team1Panel.add(t1Score);

			t2Table = new JTable(dataTeam2, column);
			t2Table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			DynamicData.team2Score = (int) predictedScoreT2;
			team2Panel.setLayout(new BoxLayout(team2Panel, BoxLayout.Y_AXIS));
			team2Panel.add(t2Name);
			team2Panel.add(bg2);
			team2Panel.add(new JScrollPane(t2Table));

			lblt2Score.setText("Predicted Score " + selectedMatch.getTeam2()
					+ " : ");
			lblt2ScoreVal.setText(predictedScoreT2 + "");

			t2Score.add(lblt2Score);
			t2Score.add(lblt2ScoreVal);
			team2Panel.add(t2Score);

			mainPanel.add(team1Panel);
			mainPanel.add(empty);
			mainPanel.add(team2Panel);
		}
	}
}
package com.abhi.crickgo.staticview;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SelectTeam1 extends JInternalFrame implements ItemListener,
		ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel teamPanel = new JPanel();

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private JLabel title = new JLabel("Select Team1:");
	private JLabel lblBats = new JLabel("  	Batsman:");
	private JLabel lblBowlers = new JLabel(" 	 Bowlers:");
	private JLabel lblWK = new JLabel("	 	Wicket Keepers:");
	private JLabel lblAR = new JLabel("	 	All Rounders:");

	private String[] batsmenList1 = { "Rohit Sharma", "Shikhar Dhawan",
			"Virat Kohli", "Ajinkya Rahane", "Manish Pandey", "Shreyas Iyer",
			"Kedar Jadhav", "K L Rahul" };

	private String[] bowlerList1 = { "B Kumar", "Bumrah", "Umesh Yadav",
			"M Shami", "R Ashwin", "Kuldeep Y", "Yuzvendra Chahal" };

	private String[] wkList1 = { "Dinesh Karthik", "MS Dhoni" };

	private String[] arList1 = { "Pandya", "Axar Patel", "Ravindra Jadeja" };

	private String[] batsmenList2 = { "david", "finch", "Head",
			"PETER HANDSCOMB", "SHAUN MARSH", "STEVEN SMITH", "maxwell" };

	private String[] bowlerList2 = { "cummins", "Starc", "hazlewood", "zampa",
			"Ashton Agar", "COULTER NILE", "KEN RICHARDSON" };

	private String[] wkList2 = { "tim", "wade" };

	private String[] arList2 = { "hilton", "stoinnis", "mmarsh",
			"JAMES FAULKNAR" };

	private String[] batsmenList3 = { "JOSEPH ROOT" };

	private String[] bowlerList3 = { "LIAM PLUNKETT", "JACOB BALL",
			"CHRISTOPHER WOAKES" };

	private String[] wkList3 = { "JOSEPH BUTTLER" };

	private String[] arList3 = { "BENJAMIN STOKES", "Moeen Ali" };

	private String[] batsmenList4 = { "Aiden Markram", "DEAN ELGAR", "FAF" };

	private String[] bowlerList4 = { "IMRAN TAHIR", "RABADA",
			"VERNON PHILANDER" };

	private String[] wkList4 = { "KLAASEN" };

	private String[] arList4 = { "WAYNE PARNELL", "MORRIS" };

	private JList<String> batsmen = new JList<String>(batsmenList1);
	private JList<String> bowlers = new JList<String>(bowlerList1);
	private JList<String> wks = new JList<String>(wkList1);
	private JList<String> ars = new JList<String>(arList1);

	private String[] teams = { "India", "Australia", "England", "South Africa" };

	private JComboBox<String> cbTeams;

	private JButton btnDone = new JButton("Done");

	public SelectTeam1() {
		super("Select Team1", false, true, false, true);
		if (StaticData.team2Name != null) {
			if (StaticData.team2Name.equalsIgnoreCase("india")) {
				teams = new String[3];
				teams[0] = "Australia";
				teams[1] = "England";
				teams[2] = "South Africa";
			} else if (StaticData.team2Name.equalsIgnoreCase("australia")) {
				teams = new String[3];
				teams[0] = "India";
				teams[1] = "England";
				teams[2] = "South Africa";
			}

			else if (StaticData.team2Name.equalsIgnoreCase("england")) {
				teams = new String[3];
				teams[0] = "India";
				teams[1] = "Australia";
				teams[2] = "South Africa";
			}

			else if (StaticData.team2Name.equalsIgnoreCase("south africa")) {
				teams = new String[3];
				teams[0] = "India";
				teams[1] = "Australia";
				teams[2] = "England";
			}
		} else {
			teams = new String[4];
			teams[0] = "India";
			teams[1] = "Australia";
			teams[2] = "England";
			teams[3] = "South Africa";
		}
		cbTeams = new JComboBox<String>(teams);
		batsmen.setSelectionModel(new com.abhi.crickgo.staticview.ListSelectionModel(
				batsmen, 5));
		bowlers.setSelectionModel(new com.abhi.crickgo.staticview.ListSelectionModel(
				bowlers, 5));

		wks.setSelectionModel(new com.abhi.crickgo.staticview.ListSelectionModel(
				wks, 1));

		ars.setSelectionModel(new com.abhi.crickgo.staticview.ListSelectionModel(
				ars, 3));
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/team1.png")));
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		teamPanel.setLayout(new BoxLayout(teamPanel, BoxLayout.X_AXIS));
		teamPanel.setBounds(10, 10, 200, 100);
		teamPanel.setPreferredSize(new Dimension(100, 20));
		teamPanel.add(title);
		teamPanel.add(cbTeams);
		cp.add("North", teamPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
		leftPanel.setPreferredSize(new Dimension(800, 200));
		leftPanel.add(lblBats);
		leftPanel.add(batsmen);
		leftPanel.add(lblBowlers);
		leftPanel.add(bowlers);
		cp.add("Center", leftPanel);

		rightPanel.setLayout(new FlowLayout());
		rightPanel.setPreferredSize(new Dimension(800, 200));
		rightPanel.add(lblWK);
		rightPanel.add(wks);
		rightPanel.add(lblAR);
		rightPanel.add(ars);
		cp.add("South", rightPanel);

		buttonPanel.add(btnDone);
		cp.add(buttonPanel);
		btnDone.addActionListener(this);
		setVisible(true);
		pack();
		cbTeams.addItemListener(this);
		initList();
	}

	public void initList() {
		String tname = cbTeams.getSelectedItem().toString();
		DefaultListModel<String> batsModel = new DefaultListModel<String>();
		DefaultListModel<String> bowlerModel = new DefaultListModel<String>();
		DefaultListModel<String> wkModel = new DefaultListModel<String>();
		DefaultListModel<String> arModel = new DefaultListModel<String>();
		if (tname.equalsIgnoreCase("india")) {
			for (String s : batsmenList1) {
				batsModel.addElement(s);
			}
			for (String s : bowlerList1) {
				bowlerModel.addElement(s);
			}

			for (String s : wkList1) {
				wkModel.addElement(s);
			}
			for (String s : arList1) {
				arModel.addElement(s);
			}
		} else if (tname.equalsIgnoreCase("australia")) {
			for (String s : batsmenList2) {
				batsModel.addElement(s);
			}
			for (String s : bowlerList2) {
				bowlerModel.addElement(s);
			}

			for (String s : wkList2) {
				wkModel.addElement(s);
			}
			for (String s : arList2) {
				arModel.addElement(s);
			}

		}

		else if (tname.equalsIgnoreCase("england")) {
			for (String s : batsmenList3) {
				batsModel.addElement(s);
			}
			for (String s : bowlerList3) {
				bowlerModel.addElement(s);
			}

			for (String s : wkList3) {
				wkModel.addElement(s);
			}
			for (String s : arList3) {
				arModel.addElement(s);
			}

		}

		else if (tname.equalsIgnoreCase("south africa")) {
			for (String s : batsmenList4) {
				batsModel.addElement(s);
			}
			for (String s : bowlerList4) {
				bowlerModel.addElement(s);
			}

			for (String s : wkList4) {
				wkModel.addElement(s);
			}
			for (String s : arList4) {
				arModel.addElement(s);
			}

		}
		batsmen.setModel(batsModel);
		bowlers.setModel(bowlerModel);
		wks.setModel(wkModel);
		ars.setModel(arModel);
		invalidate();
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		initList();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnDone) {
			StaticData.team1Name = cbTeams.getSelectedItem().toString();
			List<String> batList = batsmen.getSelectedValuesList();
			List<String> bowlerList = bowlers.getSelectedValuesList();
			List<String> wkList = wks.getSelectedValuesList();
			List<String> arList = ars.getSelectedValuesList();

			int bowlerCount = bowlerList.size();
			int batmanCount = batList.size();
			int wkCount = wkList.size();
			int arCount = arList.size();

			boolean isValid = true;

			if (wkCount == 1 && batmanCount == 5 && arCount == 2
					&& bowlerCount == 3) {
				isValid = true;
			} else if (wkCount == 1 && batmanCount == 5 && arCount == 1
					&& bowlerCount == 4) {
				isValid = true;
			}

			else if (wkCount == 1 && batmanCount == 4 && arCount == 1
					&& bowlerCount == 5) {
				isValid = true;
			} else if (wkCount == 1 && batmanCount == 4 && arCount == 2
					&& bowlerCount == 4) {
				isValid = true;
			}

			else if (wkCount == 1 && batmanCount == 4 && arCount == 3
					&& bowlerCount == 3) {
				isValid = true;
			} else if (wkCount == 1 && batmanCount == 3 && arCount == 2
					&& bowlerCount == 5) {
				isValid = true;
			}

			else if (wkCount == 1 && batmanCount == 3 && arCount == 3
					&& bowlerCount == 4) {
				isValid = true;
			} else {
				isValid = false;
			}

			if (isValid) {

				StaticData.team1 = new ArrayList<String>(batList);
				StaticData.team1.addAll(bowlerList);
				StaticData.team1.addAll(wkList);
				StaticData.team1.addAll(arList);
				JOptionPane.showMessageDialog(this, StaticData.team1Name
						+ " selected as team1");
			} else {
				JOptionPane
						.showMessageDialog(
								this,
								"Your team selection is not as per the rules.\n Please revise Team combination hint!");
			}
		}

	}

}
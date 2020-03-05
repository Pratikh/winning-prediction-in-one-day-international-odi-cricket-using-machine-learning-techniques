package com.abhi.crickgo.staticview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StaticAnalyzer extends JFrame implements ActionListener {

	private JDesktopPane desktop = new JDesktopPane();
	private MenuBar menu;
	private Toolbar toolbar;
	private Statusbar statusbar = new Statusbar();
	private JPanel searchPanel = new JPanel();
	private SelectGroundScreen search;
	private SelectTeam1 team1;
	private SelectTeam2 team2;
	private StaticPrediction prediction;
	private SelectTossScreen toss;
	private ViewGraph viewGraph;
	private TeamComination comination;

	public StaticAnalyzer() {
		super("Cricket Analyzer");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage(ClassLoader
				.getSystemResource("images/logo.jpg"));
		setIconImage(image);
		menu = new MenuBar();
		toolbar = new Toolbar();
		setJMenuBar(menu);
		menu.selectGround.addActionListener(this);
		menu.selectTeam1.addActionListener(this);
		menu.selectTeam2.addActionListener(this);
		menu.selectToss.addActionListener(this);
		menu.viewScore.addActionListener(this);

		Container cp = getContentPane();
		// desktop.setBackground(Color.WHITE);
		cp.add("Center", desktop);
		for (int i = 0; i < toolbar.imgNames.length; i++) {
			toolbar.btn[i].addActionListener(this);
		}

		searchPanel.setLayout(new BorderLayout());

		searchPanel.add("Center", toolbar);

		cp.add("North", searchPanel);

		cp.add("South", statusbar);
		setBackgroundImage();

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		show();
	}

	protected void setBackgroundImage() {
		try {
			ImageIcon icon = new ImageIcon(
					ClassLoader.getSystemResource("images/logo.jpg"));
			JLabel label = new JLabel(icon);
			label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
			desktop.add(label, new Integer(Integer.MIN_VALUE));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void actionPerformed(ActionEvent ae) {

		Object source = ae.getSource();
		if (source == menu.selectGround || source == toolbar.btn[0]) {
			search = new SelectGroundScreen();
			desktop.add(search);
			try {
				search.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.selectTeam1 || source == toolbar.btn[1]) {
			team1 = new SelectTeam1();
			desktop.add(team1);
			try {
				team1.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.selectTeam2 || source == toolbar.btn[2]) {
			team2 = new SelectTeam2();
			desktop.add(team2);
			try {
				team2.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.selectToss || source == toolbar.btn[3]) {
			toss = new SelectTossScreen();
			desktop.add(toss);
			try {
				toss.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.viewScore || source == toolbar.btn[4]) {
			prediction = new StaticPrediction();
			desktop.add(prediction);
			try {
				prediction.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.viewGraph || source == toolbar.btn[6]) {
			viewGraph = new ViewGraph();
			desktop.add(viewGraph);
			try {
				viewGraph.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == toolbar.btn[5]) {
			comination = new TeamComination();
			desktop.add(comination);
			try {
				comination.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

	}

	public static void main(String a[]) {
		new StaticAnalyzer();
	}
}

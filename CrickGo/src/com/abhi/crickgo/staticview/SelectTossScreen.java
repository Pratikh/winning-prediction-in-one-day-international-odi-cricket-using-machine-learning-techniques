package com.abhi.crickgo.staticview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SelectTossScreen extends JInternalFrame implements ActionListener {

	private JPanel northPanel = new JPanel();

	private JLabel title = new JLabel("Select Toss For Team1");

	private JPanel center = new JPanel();

	private JPanel centerGroundPanel = new JPanel();

	private JPanel selectgroundPanel = new JPanel();

	private JPanel selectGroundButtonPanel = new JPanel();

	private JLabel tossLabel = new JLabel(" Select Toss: ");
	private JComboBox tossTypes;

	private String[] toss = { "Batting First", "Chasing" };

	private JButton btnDone = new JButton("Done");

	private JPanel southPanel = new JPanel();

	public SelectTossScreen() {

		super("Select Toss", false, true, false, true);
		// for setting the icon
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/toss.png")));
		Container cp = getContentPane();

		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		title.setFont(new Font("Tahoma", Font.BOLD, 14));

		northPanel.add(title);

		cp.add("North", northPanel);

		center.setLayout(new BorderLayout());

		centerGroundPanel.setLayout(new BorderLayout());

		selectgroundPanel.add(tossLabel);
		// for adding the JComboBos[]
		selectgroundPanel.add(tossTypes = new JComboBox(toss));

		centerGroundPanel.add("North", selectgroundPanel);

		selectGroundButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		selectGroundButtonPanel.add(btnDone);

		centerGroundPanel.add("South", selectGroundButtonPanel);

		centerGroundPanel.setBorder(BorderFactory
				.createTitledBorder("Select Toss:"));

		center.add("West", centerGroundPanel);
		cp.add("Center", center);

		tossLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tossTypes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 11));

		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		southPanel.setBorder(BorderFactory.createEtchedBorder());

		cp.add("South", southPanel);
		setVisible(true);
		pack();
		btnDone.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnDone) {
			String tossType = tossTypes.getSelectedItem().toString();
			String msg = "";
			if (tossType.equalsIgnoreCase("batting")) {
				StaticData.team1Chasing = "false";
				msg = StaticData.team1Name + " will bat first";
			} else {
				StaticData.team1Chasing = "true";
				msg = StaticData.team1Name + " will chase";
			}

			JOptionPane.showMessageDialog(this, msg);
		}

	}

}
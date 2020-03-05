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

public class SelectGroundScreen extends JInternalFrame implements
		ActionListener {

	private JPanel northPanel = new JPanel();

	private JLabel title = new JLabel("Select Stadium");

	private JPanel center = new JPanel();

	private JPanel centerGroundPanel = new JPanel();

	private JPanel selectgroundPanel = new JPanel();

	private JPanel selectGroundButtonPanel = new JPanel();

	private JLabel searchBooksLabel = new JLabel(" Select Ground: ");
	private JComboBox groundTypes;

	private String[] grounds = {
			"Himachal Pradesh Cricket Association Stadium", "Feroz Shah Kotla",
			"Punjab Cricket Association IS Bindra Stadium",
			"Dr YS Rajasekhara Reddy Cricket Stadium",
			"Maharashtra Cricket Association Stadium", "Barabati Stadium",
			"Eden Gardens", "MA Chidambaram Stadium", "Holkar Cricket Stadium",
			"Vidarbha Cricket Association Stadium", "Wankhede Stadium",
			"Green Park", "Edgbaston", "Kennington Oval", "SuperSports Park",
			"Newsland", "New Wanderers", "St.George", "Kingsmead",
			"Sydney Cricket Ground" };

	private JButton btnDone = new JButton("Done");

	private JPanel southPanel = new JPanel();

	public SelectGroundScreen() {

		super("Select Stadium", false, true, false, true);
		// for setting the icon
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/ground.png")));
		Container cp = getContentPane();

		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		title.setFont(new Font("Tahoma", Font.BOLD, 14));

		northPanel.add(title);

		cp.add("North", northPanel);

		center.setLayout(new BorderLayout());

		centerGroundPanel.setLayout(new BorderLayout());

		selectgroundPanel.add(searchBooksLabel);
		// for adding the JComboBos[]
		selectgroundPanel.add(groundTypes = new JComboBox(grounds));

		centerGroundPanel.add("North", selectgroundPanel);

		selectGroundButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		selectGroundButtonPanel.add(btnDone);

		centerGroundPanel.add("South", selectGroundButtonPanel);

		centerGroundPanel.setBorder(BorderFactory
				.createTitledBorder("Select your stadium:"));

		center.add("West", centerGroundPanel);
		cp.add("Center", center);

		searchBooksLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		groundTypes.setFont(new Font("Tahoma", Font.BOLD, 11));
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
			String ground = groundTypes.getSelectedItem().toString();
			StaticData.ground = ground;
			JOptionPane.showMessageDialog(this, ground + " selected");
		}

	}

}
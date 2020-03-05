package com.abhi.crickgo.dynamicview;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DynamicAnalyzer extends JFrame implements ActionListener {

	private JDesktopPane desktop = new JDesktopPane();
	private DMenuBar menu;
	private DToolbar toolbar;
	private Statusbar statusbar = new Statusbar();
	private JPanel searchPanel = new JPanel();
	private DSelectMatch deDSelectMatch;
	private DLiveScore liveScore;
	private DynamicPrediction prediction;

	public DynamicAnalyzer() {
		super("Cricket Analyzer");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage(ClassLoader
				.getSystemResource("images/logo.jpg"));
		setIconImage(image);
		menu = new DMenuBar();
		toolbar = new DToolbar();
		setJMenuBar(menu);
		menu.viewScore.addActionListener(this);

		Container cp = getContentPane();
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
		if (source == menu.selectMatch || source == toolbar.btn[0]) {
			deDSelectMatch = new DSelectMatch();
			desktop.add(deDSelectMatch);
			try {
				deDSelectMatch.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.viewScore || source == toolbar.btn[1]) {
			liveScore = new DLiveScore();
			desktop.add(liveScore);
			try {
				liveScore.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

		if (source == menu.viewGraph || source == toolbar.btn[2]) {
			prediction = new DynamicPrediction();
			desktop.add(prediction);
			try {
				prediction.setSelected(true);
			} catch (java.beans.PropertyVetoException e) {
			}
		}

	}

	public static void main(String a[]) {
		new DynamicAnalyzer();
	}
}

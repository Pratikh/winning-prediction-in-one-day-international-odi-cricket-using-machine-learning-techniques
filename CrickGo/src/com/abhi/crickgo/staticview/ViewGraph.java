package com.abhi.crickgo.staticview;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.PieDatasetHandler;

public class ViewGraph extends JInternalFrame {

	private JPanel barPanel = new JPanel();
	private JPanel piePanel = new JPanel();
	private JPanel mainPanel = new JPanel();

	public ViewGraph() {
		super("Graphs", false, true, false, true);
		setFrameIcon(new ImageIcon(
				ClassLoader.getSystemResource("images/graph.png")));
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.setPreferredSize(new Dimension(1000, 800));
		mainPanel.add(barPanel);
		mainPanel.add(piePanel);
		cp.add(mainPanel);
		showChart();
		setVisible(true);
		pack();

	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(StaticData.team1Score, StaticData.team1Name, "");
		dataset.addValue(StaticData.team2Score, StaticData.team2Name, "");
		return dataset;
	}

	private static PieDataset createPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		double total = StaticData.team1Score + StaticData.team2Score;
		int per1 = (int) ((StaticData.team1Score / total) * 100);
		int per2 = (int) ((StaticData.team2Score / total) * 100);

		dataset.setValue(StaticData.team1Name, per1);
		dataset.setValue(StaticData.team2Name, per2);
		return dataset;
	}

	public void showChart() {
		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createBarChart("Match Statistics",
				"Team", "Prediction Scores", dataset, PlotOrientation.VERTICAL,
				true, true, false);
		chart.setBorderVisible(true);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(500, 500));
		barPanel.add(panel);

		PieDataset pie = createPieDataset();
		chart = ChartFactory.createPieChart("Match Statistics", pie, true,
				true, false);
		panel = new ChartPanel(chart);

		panel.setPreferredSize(new Dimension(500, 500));
		piePanel.add(panel);
	}

}

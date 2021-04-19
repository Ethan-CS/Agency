package io.github.ethankelly.std_lib;

import io.github.ethankelly.Graph;
import io.github.ethankelly.Model;
import io.github.ethankelly.Protection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Application to generate a graph to compare the results of different defence strategies in the stochastic SIRP model
 * of contagion.
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class StdChart extends ApplicationFrame {
	@Serial
	private static final long serialVersionUID = 1L;
	// The chart object
	private final JFreeChart chart;

	/**
	 * Class constructor.
	 *
	 * @param title          the frame title.
	 * @param filter         the value from the results we want to compare.
	 * @param protectionType which method of protection allocation the model uses.
	 * @param path           the path to the resources folder (i.e. directory containing model results).
	 * @throws IOException if the specified files do not exist.
	 */
	public StdChart(String title, Graph graph, String filter, Protection protectionType, String path, int round) throws IOException {
		super(title);
		String graphName = graph.getName();
		CategoryDataset dataset = Model.getResults(filter, path, round);
		chart = createChart(dataset, filter);
		String name;
		switch (protectionType) {
			case RANDOM -> name = "Random";
			case MIXED -> name = "Mixed";
			case DETERMINISTIC -> name = "Deterministic";
			default -> throw new IllegalStateException("Unexpected value: " + filter);
		}
		// Just to make first letters upper case and rest lower case
		String[] filterArray = filter.split("\\s+");
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < filterArray.length; i++) {
			filterArray[i] = filterArray[i].substring(0, 1).toUpperCase() + filterArray[i].substring(1).toLowerCase();
			s.append(filterArray[i]);
		}
		this.writeChartToImageFile(new File(path + s + "Chart.png"));
	}

	// Creates the required comparison chart.
	private static JFreeChart createChart(CategoryDataset dataset, String filter) {
		String yAxisLabel;
		String subTitle;
		switch (filter) {
			case "INFECTED" -> {
				yAxisLabel = "Infected Agents";
				subTitle = "Number of infected agents for each defence strategy by source node (smaller the better).";
			}
			case "END TURN" -> {
				yAxisLabel = "End turn count";
				subTitle = "End turn count for each defence strategy by source node (smaller the better).";
			}
			case "PROTECTED" -> {
				yAxisLabel = "Protected Agents";
				subTitle = "Number of protected agents for each defence strategy by source node (larger the better).";
			}
			default -> throw new IllegalStateException("Unexpected value: " + filter);
		}

		JFreeChart chart = ChartFactory.createBarChart(
				"Defence Strategy Performance",
				"Source vertex",
				yAxisLabel,
				dataset);
		Font titleFont = new Font("CMU Bright", Font.BOLD, 30);
		Font subtitleFont = new Font("CMU Bright", Font.PLAIN, 15);
		Font axisFont = new Font("CMU Bright", Font.ITALIC, 18);

		chart.getTitle().setFont(titleFont);
		TextTitle sub = new TextTitle((subTitle));
		sub.setFont(subtitleFont);
		chart.addSubtitle(sub);
		chart.setBackgroundPaint(Color.WHITE);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		plot.getDomainAxis().setLabelFont(axisFont);
		plot.getRangeAxis().setLabelFont(axisFont);

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		chart.getLegend().setFrame(BlockBorder.NONE);
		return chart;
	}

	/**
	 * Writes the current chart to an image file.
	 *
	 * @param chartFile the file name to which to write the chart.
	 */
	public void writeChartToImageFile(File chartFile) {
		BufferedImage chartImage = this.chart.createBufferedImage(1200, 500);
		try (OutputStream out = new FileOutputStream(chartFile)) {
			ImageIO.write(chartImage, "png", out);
		} catch (IOException e) {
			throw new IllegalArgumentException("Failed writing chartFile (" + chartFile + ").", e);
		}
	}
}
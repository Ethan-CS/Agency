package io.github.ethankelly;

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
public class Chart extends ApplicationFrame {
	@Serial
	private static final long serialVersionUID = 1L;
	private final JFreeChart chart;

	/**
	 * Class constructor.
	 *
	 * @param title          the frame title.
	 * @param filter         the value from the results we want to compare.
	 * @param protectionType which method of protection allocation the model uses.
	 */
	public Chart(String title, String filter, int protectionType) throws IOException {
		super(title);
		CategoryDataset dataset = Model.getResults(filter, protectionType);
		chart = createChart(dataset, filter);
		String name;
		switch (protectionType) {
			case Model.RANDOM -> name = "Random";
			case Model.MIXED -> name = "Mixed";
			case Model.DETERMINISTIC -> name = "Deterministic";
			default -> throw new IllegalStateException("Unexpected value: " + filter);
		}
		String[] filterArray = filter.split("\\s+");
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < filterArray.length; i++) {
            filterArray[i] = filterArray[i].substring(0, 1).toUpperCase() + filterArray[i].substring(1).toLowerCase();
            s.append(filterArray[i]);
        }
		this.writeChartToImageFile(new File("data/" + name + "/" + name + s + "Chart.png"));
	}

	/**
	 * Creates the required comparison chart.
	 *
	 * @param dataset the dataset.
	 * @param filter  the value we want to compare across different strategies.
	 * @return the chart.
	 */
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

		chart.addSubtitle(new TextTitle(subTitle));
		chart.setBackgroundPaint(Color.WHITE);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
		return chart;
	}

	public void writeChartToImageFile(File chartFile) {
		JFreeChart chart = this.chart;
		BufferedImage chartImage = chart.createBufferedImage(1200, 500);
		try (OutputStream out = new FileOutputStream(chartFile)) {
			ImageIO.write(chartImage, "png", out);
		} catch (IOException e) {
			throw new IllegalArgumentException("Failed writing chartFile (" + chartFile + ").", e);
		}
	}
}
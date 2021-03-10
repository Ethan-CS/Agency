package io.github.ethankelly;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serial;

/**
 * Application to generate a graph to compare the results of different defence strategies in the stochastic SIRP model
 * of contagion.
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class Chart extends ApplicationFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Class constructor.
     *
     * @param title the frame title.
     * @param filter the value from the results we want to compare.
     */
    public Chart(String title, String filter) throws IOException {
        super(title);
        CategoryDataset dataset = getResults(filter);
        JFreeChart chart = createChart(dataset, filter);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(1200, 500));
        setContentPane(chartPanel);
    }

    /**
     * Given a value that we want to compare, creates a new chart comparing results as specified.
     *
     * @param filter the value in different strategies we want to compare.
     * @throws IOException if the file to read data from cannot be found.
     */
    public static void getChart(String filter) throws IOException {
        Chart demo = new Chart("Defence Strategy Comparison", filter);
        demo.pack();
        UIUtils.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    /**
     * Creates the required comparison chart.
     *
     * @param dataset the dataset.
     * @param filter the value we want to compare across different strategies.
     * @return the chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset, String filter) {
        String yAxisLabel;
        String subTitle;
        switch(filter) {
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

    // Gets the results of a model from a CSV data file
    private static CategoryDataset getResults(String filter) throws IOException {
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        // Read in the model defence results and associated graph
        Reader in = new FileReader(StdOut.dataName);
        java.util.List<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in).getRecords();

        // Add each result to our dataset
        records.forEach(record -> data.addValue(Double.parseDouble(record.get(filter)),
                record.get("STRATEGY"),
                record.get("OUTBREAK")));
        return data;
    }
}
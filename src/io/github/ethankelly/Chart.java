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
     */
    public Chart(String title) throws IOException {
        super(title);
        CategoryDataset dataset = getResults();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(1200, 500));
        setContentPane(chartPanel);
    }

    private static CategoryDataset getResults() throws IOException {
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        // Read in the model defence results and associated graph
        Reader in = new FileReader("out/TestData.csv");
        java.util.List<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in).getRecords();

        // Add each result to our dataset
        records.forEach(record -> data.addValue(Double.parseDouble(record.get("INFECTED")),
                record.get("STRATEGY"),
                record.get("OUTBREAK")));
        return data;
    }

    /**
     * Creates the required comparison chart.
     *
     * @param dataset the dataset.
     * @return the chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Defence Strategy Performance",
                "Source vertex",
                "Infected Agents",
                dataset);

        chart.addSubtitle(new TextTitle("Number of infected agents for each defence strategy by source node."));
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(String[] args) throws IOException {
        Chart demo = new Chart("Defence Strategy Comparison");
        demo.pack();
        UIUtils.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
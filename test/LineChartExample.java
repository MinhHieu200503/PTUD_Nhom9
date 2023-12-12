
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class LineChartExample extends JFrame {
     private static final long serialVersionUID = 1L;  
  
  public LineChartExample(String title) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Site Traffic", // Chart title  
        "Date", // X-Axis Label  
        "Number of Visitor", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset(double[] phong, double[] dichVu) {  
  
    String series1 = "Ngày";  
    String series2 = "Doanh thu";  
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
 
    for (int i = 0 ; i<12 ; i++){
        dataset.addValue(phong[i], series1, String.valueOf(i+1));  
        dataset.addValue(dichVu[i], series2, String.valueOf(i+1));  
    }
  
    return dataset;  
  }  
  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(() -> {  
      LineChartExample example = new LineChartExample("Line Chart Example");  
      example.setAlwaysOnTop(true);  
      example.pack();  
      example.setSize(600, 400);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}

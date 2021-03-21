/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jchart;

/**
 *
 * @author wufan
 */
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;
 
public class PieChart_AWT extends ApplicationFrame 
{
   public PieChart_AWT( String title,HashMap<String,Integer> mapdata1,HashMap<String,Integer> mapdata2 ) 
   {
      super( title ); 
      CategoryDataset dataset = createDataset(mapdata1,mapdata2);
      JFreeChart chart = createChart(title,dataset);
      ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
//        chartPanel.setPreferredSize(new java.awt.Dimension(600, 380));
        setContentPane(chartPanel);
   }
   private static DefaultCategoryDataset createDataset(HashMap<String,Integer> mapdata1,HashMap<String,Integer> mapdata2) 
   {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//      dataset.setValue( "MotoG" , new Double( 40 ) );    
//      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
       double total = 0.0f;
       for(Integer value:mapdata1.values()){
           total+=value;
       }
      
       for (Entry<String, Integer> entry : mapdata1.entrySet()) {
            entry.getKey();
            entry.getValue(); 
//            System.out.println(entry.getKey()+"("+entry.getValue()+"/"+(total*100)+"%"+")");
            dataset.addValue( entry.getValue(), entry.getKey()+"("+(Math.round(entry.getValue()/total*100))+"%"+")", "Top 50 percentage");
       }
//       System.out.println("---------");
       total = 0.0f;
       for(Integer value:mapdata2.values()){
           total+=value;
       }
      
       for (Entry<String, Integer> entry : mapdata2.entrySet()) {
            entry.getKey();
            entry.getValue(); 
//            System.out.println(entry.getKey()+"("+entry.getValue()+"/"+(total*100)+"%"+")");
            dataset.addValue( entry.getValue(), entry.getKey()+"("+(Math.round(entry.getValue()/total*100))+"%"+")", "Last 50 percentage");
       }
      return dataset;         
   }
   private static JFreeChart createChart(String title, CategoryDataset  dataset )
   {
       //创建主题样式
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
        //设置标题字体
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
        //设置图例的字体
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));
        //设置轴向的字体
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));
        //应用主题样式
        ChartFactory.setChartTheme(standardChartTheme);
        final JFreeChart chart = ChartFactory.createMultiplePieChart3D(
            title, dataset, TableOrder.BY_COLUMN, false, true, false
        ); 
        chart.setBackgroundPaint(new Color(216, 255, 216));
        final MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        final JFreeChart subchart = plot.getPieChart();

        plot.setLimit(0.0010);
        final PiePlot p = (PiePlot) subchart.getPlot();
        p.setLabelFont(new Font("SansSerif", Font.PLAIN, 16));
//        p.setInteriorGap(0.30);

      return chart;
   }
}



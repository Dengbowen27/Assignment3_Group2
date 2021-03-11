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
import java.awt.Font;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart_AWT extends ApplicationFrame 
{
   public PieChart_AWT( String title,HashMap<String,Integer> mapdata ) 
   {
      super( title ); 
      setContentPane(createDemoPanel(title,mapdata ));
   }
   private static PieDataset createDataset(HashMap<String,Integer> mapdata) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
//      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//      dataset.setValue( "MotoG" , new Double( 40 ) );    
//      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
       double total = 0.0f;
       for(Integer value:mapdata.values()){
           total+=value;
       }
      
       for (Entry<String, Integer> entry : mapdata.entrySet()) {
            entry.getKey();
            entry.getValue(); 
            dataset.setValue( entry.getKey()+"("+(Math.round(entry.getValue()/total*100))+"%"+")" , entry.getValue() );  
       }
      return dataset;         
   }
   private static JFreeChart createChart(String title, PieDataset dataset )
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
      JFreeChart chart = ChartFactory.createPieChart(      
         title,  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel(String title,HashMap<String,Integer> mapdata )
   {
      PieDataset data = createDataset(mapdata);
      JFreeChart chart = createChart(title,data );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args )
   {
      
   }
}



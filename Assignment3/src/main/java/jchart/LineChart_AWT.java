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
import java.util.ArrayList;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame
{
   public LineChart_AWT( String applicationTitle , String chartTitle,ArrayList<Float> arr,String name )
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Rank","Gpa",
         createDataset(arr,name),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset(ArrayList<Float> arr,String name )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
//      dataset.addValue( 15 , "schools" , "1970" );
//      dataset.addValue( 30 , "schools" , "1980" );
//      dataset.addValue( 60 , "schools" ,  "1990" );
//      dataset.addValue( 120 , "schools" , "2000" );
//      dataset.addValue( 240 , "schools" , "2010" );
//      dataset.addValue( 300 , "schools" , "2014" );
       for (int i = 0; i < arr.size(); i++) {
           dataset.addValue( arr.get(i) , name ,""+i);
           
       }
      return dataset;
   }
   public static void main( String[ ] args ) 
   {
      
   }
}



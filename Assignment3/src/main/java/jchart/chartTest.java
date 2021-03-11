/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jchart;

import java.util.ArrayList;
import java.util.HashMap;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author wufan
 */
public class chartTest {
    public static void main(String[] args) {
      HashMap<String,Integer> maps =  new HashMap<>();
      maps.put("1门",5);
      maps.put("2门",10);
      maps.put("3门",15);
      maps.put("4门",15);
      maps.put("5门",20);
      maps.put("6门",25);
      PieChart_AWT demo = new PieChart_AWT( "rank前100 选中相关课程数目的人数",maps );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
      
      ArrayList<Float> gpas = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            float gpa = i*0.1f+2.0f;
            gpa = gpa + ((int)(Math.random()*10))*0.01f;
            gpas.add(gpa);
        }
        gpas.add(4.0f);
      
      LineChart_AWT chart = new LineChart_AWT(
      "Gpa Vs Rank" ,
      "Gpas vs Ranks",
        gpas,
      "gpa");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
    }
}

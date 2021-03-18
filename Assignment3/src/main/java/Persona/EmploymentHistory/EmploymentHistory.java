/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.EmploymentHistory;

import Employer.EmployerProfile;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Dengbowen
 */
public class EmploymentHistory {
    ArrayList<Employment> employments;
    
    public EmploymentHistory(){
        employments = new ArrayList();
    }
    
    public void newEmployment(Employment e){
        employments.add(e);
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }
    
    
    public int getEmploymentGrade(){
        int sum = 0;
        int i = 0;
        for(Employment e:employments){
            EmployerProfile employer = e.getEmployer();
            sum =sum + employer.getQuality()*employer.getWeight()+e.getQuality()*e.getWeight();
            i++;
        }
        if(i==0)
        {
            return 0;
        }
        return sum/i;
    }
    
   public boolean isPromotion(){
        boolean a = true;
        for (Employment e1:employments) 
        for (Employment e2:employments){
            if(e2.getEmploymentGrade()>e1.getEmploymentGrade()){
                a=true;
            }else
                a=false;
        }
        return a;
        
          
    }
    
}

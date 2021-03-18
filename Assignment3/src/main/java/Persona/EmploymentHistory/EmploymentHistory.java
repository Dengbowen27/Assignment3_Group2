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
       // for (Employment e:employments) {
             int i = employments.size()-1;
             int grade[]=new int[i];
             String em[]=new String[i];
             for(int j=0;j<i;j++){
                grade[j]=employments.get(j).getEmploymentGrade();
                em[j]=employments.get(j).getEmployerName();
             }            
            return true; 
    }
    
}

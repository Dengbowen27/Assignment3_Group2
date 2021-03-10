/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.EmploymentHistory;

import Employer.EmployerProfile;
import java.util.ArrayList;

/**
 *
 * @author Dengbowen
 */
public class EmploymentHistory {
    ArrayList<Employment> employments;
    
    public EmploymentHistory(){
        employments = new ArrayList();
    }
    
    public Employment newEmployment(String job,int weight,int quality,EmployerProfile employer){
        
        Employment ne = new Employment(job,weight,quality,employer);
        employments.add(ne);
        return ne;
    }
    public int getEmploymentGrade(){
        int sum = 0;
        int i = 0;
        for(Employment e:employments){
            EmployerProfile employer = e.getEmployer();
            sum = sum + employer.getQuality()*employer.getWeight()+e.getQuality()*e.getWeight();
            i++;
        }
        return sum/i;
    }
}

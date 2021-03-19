/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.EmploymentHistory;

import CourseCatalog.Course;
import Employer.EmployerProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author Dengbowen
 */
public class EmploymentHistory {
    ArrayList<Employment> employments;
    
    public EmploymentHistory(){
        employments = new ArrayList();
    }
    
    public Employment newEmployment(Employment e){
        employments.add(e);
        return e;
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }
    
    
    public int getEmploymentGrade(){
        int sum = 0;
        int i = 0;
        for(Employment e:employments){
            EmployerProfile employer = e.getEmployer();
            sum += employer.getQuality()*employer.getWeight()+ e.getEmploymentGrade();
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
        Employment max = Collections.max(employments);
        //Employment min = Collections.min(employments);
        if(max.getEmploymentGrade()!=0){
            if(max.getEmploymentGrade()>employments.get(0).getEmploymentGrade()){
                a = true;
            }else
                a = false;
        }else a =false;
        
        return a;
        
          
    }
   
   //get relevant courses without repeat
    public HashSet<Course> getRelevantCourses(){
        HashSet<Course> rc = new HashSet<>();
        for (Employment e : employments) {
            for (Course f : e.getRelevantcourses()) {
                rc.add(f);
            }
        }
        return rc;
    }
    
    //get the number of same courses appeared both in employment and transcript
    public int getSameCoursesNum(ArrayList<Course> transarr){
        int num = 0;
        HashSet<Course> rc = this.getRelevantCourses();
        if(rc.isEmpty()){
            return 0;
        }
        for(Course c:transarr){
            if(rc.contains(c))
               num+=1; 
        }
        return num;
    }
}

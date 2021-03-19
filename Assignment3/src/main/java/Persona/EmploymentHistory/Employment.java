/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.EmploymentHistory;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import java.util.ArrayList;
import CourseSchedule.CourseOffer;
import Employer.EmployerProfile;
/**
 *
 * @author Dengbowen
 */
public class Employment implements Comparable<Employment>{

    ArrayList<Course> relevantcourses;
    
    int weight;
    int quality;
    String job;

    CourseCatalog coursecatalog;
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    
    public Employment(String job,int weight,int quality,EmployerProfile employer){
        
        this.job = job;
        this.weight = weight;
        this.quality = quality;
        this.employer = employer;
        this.employer.addEmpoyment(this);
        ArrayList relevantcourses = new ArrayList();
        this.relevantcourses = relevantcourses;
        
    }
    public Employment(){
    
    }
    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuality() {
        return quality;
    }

    
    public void setQuality(int quality) {
        this.quality = quality;
    }

    public EmployerProfile getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerProfile employer) {
        this.employer = employer;
    }

    public String getJob() {
        return job;
    }
    public String getEmployerName(){
       return employer.getName();
    }
    
    public Course newRelevantCourse(Course c){
        relevantcourses.add(c);
        return c;
        
    }

    public ArrayList<Course> getRelevantcourses() {
        return relevantcourses;
    }
    public int getEmploymentGrade(){
       return weight*quality;
    }

    @Override
    public int compareTo(Employment o) {
         int level = o.getEmploymentGrade()-this.getEmploymentGrade();
         if(level!=0){
             return level;
         }
         return 0;
    }

    @Override
    public String toString() {
        return employer.getName();
    }
    
    
}

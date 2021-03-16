/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.EmploymentHistory;

import CourseCatalog.Course;
import java.util.ArrayList;
import CourseSchedule.CourseOffer;
import Employer.EmployerProfile;
/**
 *
 * @author Dengbowen
 */
public class Employment {

    ArrayList<CourseOffer> relevantcourseoffers;
    
    int weight;
    int quality;
    String job;

    
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    
    public Employment(String job,int weight,int quality,EmployerProfile employer){
        
        this.job = job;
        this.weight = weight;
        this.quality = quality;
        this.employer = employer;
        this.employer.addEmpoyment(this);
        //ArrayList relevantcourseoffers = new ArrayList();
        ArrayList relevantcourseoffers = new ArrayList();
        
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
    
    
    public CourseOffer newRelevantCourseoffer(Course c){
        CourseOffer newcourseoffer = new CourseOffer(c);
        relevantcourseoffers.add(newcourseoffer);
        return newcourseoffer;
        
    }
    
}

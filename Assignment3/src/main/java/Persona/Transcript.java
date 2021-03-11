/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import java.util.HashMap;

/**
 *
 * @author Dengbowen
 */
public class Transcript {
    HashMap<String, CourseLoad> courseloadlist;
    StudentProfile student;
    CourseLoad currentcourseload;

    public HashMap<String, CourseLoad> getCourseloadlist() {
        return courseloadlist;
    }
    
    
    public Transcript(/*StudentProfile sp*/){
        //student = sp;
        courseloadlist = new HashMap<String, CourseLoad>();
        
    }
    
    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
    public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
//    public float getStudentTotalScore(){
//        float sum = 0;
//        int n = 0;
//        for(CourseLoad cl : courseloadlist.values()){
//            sum = sum + cl.getSemesterScore();
//            
//        }
//        return sum;
//    }

    public float getCurrentGpa() {
        float sum = 0.0f;
        float credits = 0.0f;
        for (CourseLoad cl : courseloadlist.values()) {
            for (SeatAssignment sa : cl.getSeatAssignments()) {
                sum += sa.getCourseStudentScore();
                credits += sa.getCreditHours();
            }
        }
       return sum/credits;
       
    }
    

}


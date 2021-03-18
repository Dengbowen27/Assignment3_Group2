/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import CourseCatalog.Course;
import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import java.util.ArrayList;
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
    
    
    public Transcript(StudentProfile sp){
        student = sp;
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
    public void getAllCourse(){
      
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
    public int getTotalCreitHour(){
        int credit=0;
        for (CourseLoad cl : courseloadlist.values()) {
            for (SeatAssignment sa : cl.getSeatAssignments()) {
                credit += sa.getCreditHours();
            }
        }
        return credit;
    }
    
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
    
    //getCourses
    public ArrayList<Course> getCourses(){
       ArrayList<Course> cs = new ArrayList<>();
       for (CourseLoad cl : courseloadlist.values()) {
            for (SeatAssignment sa : cl.getSeatAssignments()) {
                cs.add(sa.getCourse());
            }
        }
       return cs;
    }

    @Override
    public String toString() {
        String res = "";
        for (CourseLoad cl : courseloadlist.values()) {
            for (SeatAssignment sa : cl.getSeatAssignments()) {
                res+= "Course:{"+sa.getSeat().getCourseoffer().getCourse().getNumber() + "}, grade:{"+ sa.getGrade()+"}\n";
            }
        }
        
        return res;
    }
    
    
}


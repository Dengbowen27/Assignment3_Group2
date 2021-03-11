/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import Persona.StudentProfile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 主子
 */
public class Degree {
    float requiredGpa;
    int requiredHour;
    ArrayList<Course> coreCourseList;
    ArrayList<Course> selectiveCourseList;

    public Degree(ArrayList<Course> core,ArrayList<Course> selective) {
        coreCourseList=core;
        selectiveCourseList=selective;
    }

    public float getRequiredGpa() {
        return requiredGpa;
    }

    public void setRequiredGpa(float requiredGpa) {
        this.requiredGpa = requiredGpa;
    }

    public int getRequiredHour() {
        return requiredHour;
    }

    public void setRequiredHour(int requiredHour) {
        this.requiredHour = requiredHour;
    }

    public ArrayList<Course> getCoreCourseList() {
        return coreCourseList;
    }

    public void setCoreCourseList(ArrayList<Course> coreCourseList) {
        this.coreCourseList = coreCourseList;
    }

    public ArrayList<Course> getSelectiveCourseList() {
        return selectiveCourseList;
    }

    public void setSelectiveCourseList(ArrayList<Course> selectiveCourseList) {
        this.selectiveCourseList = selectiveCourseList;
    }
    
    public boolean isStudentQualified(StudentProfile student){
        List<Course> studentCourseList=new ArrayList<>();
        for (CourseLoad cl : student.getTranscript().getCourseloadlist().values()) {
            for (SeatAssignment sa : cl.getSeatAssignments()) {
                studentCourseList.add(sa.getSeat().getCourseoffer().getCourse());
            }
        }
        //GPA小于要求或者总学时不够
        if(student.getCurrentGpa()<requiredGpa||student.getTranscript().getTotalCreitHour()<requiredHour)
            return false;
        //有一门必修课没选
        for(Course course:coreCourseList){
            if(!studentCourseList.contains(course))
                return false;
        }
        return true;
    }
}

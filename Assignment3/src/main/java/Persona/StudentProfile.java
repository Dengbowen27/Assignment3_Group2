/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import CourseSchedule.CourseLoad;
import Persona.EmploymentHistory.EmploymentHistory;

/**
 *
 * @author Dengbowen
 */
public class StudentProfile implements Comparable<StudentProfile>{
    Person person;
    Transcript transcript;
    EmploymentHistory employmenthistory;
    

    public StudentProfile(Person p) {

        person = p;
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistory();
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s){
        
        return transcript.newCourseLoad(s);
    }
    
    //get gpa
    public float getCurrentGpa(){
        return transcript.getCurrentGpa();
    }

    public Transcript getTranscript() {
        return transcript;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EmploymentHistory getEmploymenthistory() {
        return employmenthistory;
    }

    public void setEmploymenthistory(EmploymentHistory employmenthistory) {
        this.employmenthistory = employmenthistory;
    }

    @Override
    public String toString() {
        return person.toString();
    }

    
    //sort by rank
    @Override
    public int compareTo(StudentProfile o) {
        int thisrank = this.employmenthistory.getEmploymentGrade();
        int otherrank = o.employmenthistory.getEmploymentGrade();
        return otherrank-thisrank;
    }
    
    
    
    
}

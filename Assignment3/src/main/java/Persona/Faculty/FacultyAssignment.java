/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona.Faculty;

import CourseSchedule.CourseOffer;

/**
 *
 * @author Dengbowen
 */
public class FacultyAssignment {
    CourseOffer courseoffer;
    FacultyProfile facultyprofile;
    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        courseoffer = co;
        facultyprofile = fp;
    }

    public FacultyProfile getFacultyProfile(){
        return facultyprofile;
    }
}

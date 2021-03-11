/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example;

import CourseCatalog.Course;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Dengbowen
 */
public class Info5100 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");
        Course course = department.newCourse("app eng", "info 5100", 4);
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        courseoffer.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        //
        Course course2 = department.newCourse("spring eng", "info 5200", 2);
        CourseSchedule courseschedule2 = department.newCourseSchedule("spring2020");
        CourseOffer courseoffer2 = courseschedule.newCourseOffer("info 5200");
        courseoffer2.generatSeats(10);
        CourseLoad courseload2 = student.newCourseLoad("spring2020"); 
        
        SeatAssignment sa2 =  courseload2.newSeatAssignment(courseoffer2); //register student in class
        sa2.setGrade(3.3f);
        
//         
//        
        SeatAssignment sa = courseload.newSeatAssignment(courseoffer); //register student in class
        sa.setGrade(3.7f);
        
//        int total = department.calculateRevenuesBySemester("Fall2020");
//        System.out.print("Total: " + total);
        
        HashMap<String, CourseLoad> courseloadlist = student.getTranscript().getCourseloadlist();
        
       for (Map.Entry<String, CourseLoad> entry : courseloadlist.entrySet()) {
            entry.getValue(); 
           System.out.println("学期:"+entry.getKey());
           System.out.println("------------");
           CourseLoad cs = entry.getValue(); 
           if(cs==null)
           {
               System.out.println("null");
           }
           for(SeatAssignment saa : cs.getSeatAssignments()){
//               System.out.println(saa.getCreditHours());
//               System.out.println(saa.getSeat().getCourseoffer().getSubjectCourse().getName() +": "+saa.getGrade());
               String result = String.format("课程:(%s)   学时(%d)  成绩(%f)",saa.getSeat().getCourseoffer().getSubjectCourse().getName(),saa.getSeat().getCourseoffer().getCreditHours(),saa.getGrade());
               System.out.println(result); //sa.getSeat().getCourseoffer().getCreditHours()
           }
       }
       
        System.out.println("-----GPA");
        System.out.println(student.getCurrentGpa());
//        for( student.getTranscript().getCourseloadlist())
;

        //访问employment history
        student.getEmploymenthistory();
    }
}

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
import Employer.EmployerDirectory;
import Employer.EmployerProfile;
import Faker.FakerUtl;
import Persona.EmploymentHistory.Employment;
import Persona.EmploymentHistory.EmploymentHistory;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dengbowen
 */
public class Info5100 {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        
        Department department = new Department("Information Systems");
        
//        //Create semesters
        String[] sems = new String[]{"Fall2019","Spring2020","Fall2020","Spring2021"};
        
        //16 courses
        String[][] courses = {{"INFO-5001","INFO-5100","INFO-6105","INFO-6210","INFO-6250","INFO-7110","INFO-7250",
                                "CSYE-5001","CSYE-5100","CSYE-6105","CSYE-6210","CSYE-6250","CSYE-7110","CSYE-7250","INFO-7245","INFO-7374"},
                                 {"AMD","AED","DS PYTHON","DS MEHOD","WEB DESGIN","PROGRAM STRUCTURE","DATA MANAGEMENT",
                                  "OOD","OOD C++","OS","SCALA","Foundations of Parallel","User Experience Design ","Advanced Game Analytics","Agile Software","Advanced User Experience"}   }; 
        for (int j = 0; j < courses[0].length; j++) {
                Course course = department.newCourse(courses[1][j], courses[0][j], 4);
        }
        //generate courseoffer by semester
        for (int i = 0; i < sems.length; i++) {
           CourseSchedule courseschedule = department.newCourseSchedule(sems[i]);
            for (int j = 0; j < courses[0].length; j++) {
               CourseOffer courseoffer = courseschedule.newCourseOffer(courses[0][j]);
               courseoffer.generatSeats(100);
            }
            System.out.println(courseschedule.toString());
        }

        System.out.println("generate 100 students.. Enter");
        String str;
         while((str = sc.nextLine()) !="")
          {
             break;
          }
       // generate 100 students
        PersonDirectory pd = department.getPersonDirectory();
        StudentDirectory sd = department.getStudentDirectory();
        for (int i = 0; i < 100; i++) {
             Person person = pd.newPerson("00"+(15800+i),FakerUtl.name());
            StudentProfile student = sd.newStudentProfile(person);
            System.out.println(student);
        }
        
        //generate transcript for each student
        //every semester add 2 course offer
        //给所有学生添加课程和成绩
        for (StudentProfile stu : sd.getStudentlist()) {
            int courseIdx = 0;
            for (int i = 0; i < sems.length; i++) {
                CourseLoad courseload = stu.newCourseLoad(sems[i]); //给学生添加一个学期
                CourseSchedule courseschedule = department.getCourseSchedule(sems[i]); //获取部门内的某个学期课程数据
                //随机添加一门课，但不能添加重复的课程

                for (int j = 0; j < 2; j++) {
                    int cdx = FakerUtl.randomIntNum(1, 2);
                    if(courseIdx + cdx>15)
                    {
                       cdx = 1;
                    }
                    CourseOffer courseoffer = courseschedule.getCourseOfferByNumber(courses[0][courseIdx + cdx]); //获取该学期内的某节课
                    courseIdx += cdx;
                    SeatAssignment sa = courseload.newSeatAssignment(courseoffer); //给该学生添加这门课
                    sa.setGrade(FakerUtl.randomDoubleNum(2, 3, 4)); //给这门课分数
                }
            }
//            System.out.println(stu.getCurrentGpa());
        }
        
         System.out.println("create companies and create employment for students.. Enter");
         while((str = sc.nextLine()) !="")
          {
             break;
          }
        
        //create companies
        EmployerDirectory employerDirectory=department.getEmployerDirectory();
        for (int i = 0; i < 10; i++) { //create n companies
            EmployerProfile emp = employerDirectory.newEmployerProfile(FakerUtl.company(),FakerUtl.randomIntNum(1, 5), FakerUtl.randomIntNum(1, 5));  //name , weight, quality
            System.out.println(emp);
            for (int j = 0; j < 3; j++) { //create n jobs for each company
                Employment e = new Employment(FakerUtl.job(),j+1,j+1,emp); //string job,int weight,int quality,EmployerProfile employer
                System.out.println(e.getJob());
            }
            
        }
        
        //create employment for students
        for (StudentProfile stu : sd.getStudentlist()) {
            EmploymentHistory employmenthistory = stu.getEmploymenthistory();
            EmployerProfile oneEmployerProfile = employerDirectory.getOneEmployerProfile(); //随机拿一个公司
            int randomIntNum = FakerUtl.randomIntNum(0,oneEmployerProfile.getEmployments().size()-1);
            for (int i = 0; i < randomIntNum; i++) {//随机插入0-3份工作
                employmenthistory.newEmployment(oneEmployerProfile.getEmployments().get(i));
            }
            System.out.println(employmenthistory.getEmploymentGrade());
        }
                
        System.out.println("student sorts by rank.. Enter");
         while((str = sc.nextLine()) !="")
          {
             break;
          }
         
         Collections.sort(sd.getStudentlist());
         int index = 1;
         for (StudentProfile stu : sd.getStudentlist()) {
             System.out.println(String.format("%d    rank:{%d}    %s", index++,stu.getEmploymenthistory().getEmploymentGrade(),stu.getPerson()));
         }
         
         

//        int total = department.calculateRevenuesBySemester("Fall2020");
//        System.out.print("Total: " + total);
//        
//        HashMap<String, CourseLoad> courseloadlist = student.getTranscript().getCourseloadlist();
//        
//       for (Map.Entry<String, CourseLoad> entry : courseloadlist.entrySet()) {
//            entry.getValue(); 
//           System.out.println("学期:"+entry.getKey());
//           System.out.println("------------");
//           CourseLoad cs = entry.getValue(); 
//           if(cs==null)
//           {
//               System.out.println("null");
//           }
//           for(SeatAssignment saa : cs.getSeatAssignments()){
//               String result = String.format("课程:(%s)   学时(%d)  成绩(%f)",saa.getSeat().getCourseoffer().getSubjectCourse().getName(),saa.getSeat().getCourseoffer().getCreditHours(),saa.getGrade());
//               System.out.println(result); //sa.getSeat().getCourseoffer().getCreditHours()
//           }
//       }
//       
//        System.out.println("-----GPA");
//        System.out.println(student.getCurrentGpa());
//;
//        //create Employer here
//        EmployerDirectory employerDirectory=department.getEmployerDirectory();
//        EmployerProfile employerProfile;
//        employerProfile=employerDirectory.newEmployerProfile("Microsoft", 9, 8);
//        //visit employment history
//        Employment employment;
//        
//        EmploymentHistory employmentHistory1=student.getEmploymenthistory();
//        employment=employmentHistory1.newEmployment("JuniorSoftwareDevelopmentEngineer", total, total, employerProfile);
;

    }
}

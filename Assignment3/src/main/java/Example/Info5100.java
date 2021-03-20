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
import jchart.LineChart_AWT;
import jchart.PieChart_AWT;
import org.jfree.ui.RefineryUtilities;

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
//            System.out.println(student);
        }
        System.out.println("Done!");
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
            System.out.println(stu.getPerson().getName()+" trans 课程：");
            for(Course c:stu.getTranscript().getCourses()){
                System.out.println(c);
            }
//            System.out.println(stu.getCurrentGpa());
        }
        System.out.println("Done!");
         System.out.println("create companies and create employment for students.. Enter");
         while((str = sc.nextLine()) !="")
          {
             break;
          }
        
        //create companies
        EmployerDirectory employerDirectory=department.getEmployerDirectory();
        for (int i = 0; i < 3; i++) { //create n companies
            EmployerProfile emp = employerDirectory.newEmployerProfile(FakerUtl.company(),FakerUtl.randomIntNum(1, 10), FakerUtl.randomIntNum(1, 10
            ));  //name , weight, quality
//            System.out.println(emp);
            for (int j = 0; j < 3; j++) { //create n jobs for each company
                Employment e = new Employment(FakerUtl.job(),FakerUtl.randomIntNum(1, 10),FakerUtl.randomIntNum(1, 10),emp);
                //string job,int weight,int quality,EmployerProfile employer
        //creat relevant courses
                for(int k = 0;k<5;k++){ // 随机添加相关课程
                    int cdx = FakerUtl.randomIntNum(0, 15);
                    Course c = department.getCourseCatalog().getCourseByNumber(courses[0][cdx]);
                    e.newRelevantCourse(c);}
            }
            
        }
        
        //create employment for students
        for (StudentProfile stu : sd.getStudentlist()) {
            EmploymentHistory employmenthistory = stu.getEmploymenthistory();
            EmployerProfile oneEmployerProfile = employerDirectory.getOneEmployerProfile(); //随机拿一个公司
            int randomIntNum = FakerUtl.randomIntNum(1,3);
            for (int i = 0; i < randomIntNum; i++) {//随机插入0-3份工作
                employmenthistory.newEmployment(oneEmployerProfile.getEmployments().get(i));
            }
            //for(Employment e : employmenthistory.getEmployments()){
          //  System.out.println(e.getJob());
            
           // }
            System.out.println(stu.getPerson().getName());  
            System.out.println("相关课程：");
            for(Course c:stu.getEmploymenthistory().getRelevantCourses()){
                System.out.println(c);
            }
//            System.out.println(employmenthistory.getEmploymentGrade());
//            for(Employment e : employmenthistory.getEmployments()){
//                System.out.println(e.getJob());
//            }
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
         
//relevant course number
        int[] repC = new int[9]; //代表相关课程和个人选课的重复数目为0-8
        for (StudentProfile stu : sd.getStudentlist()) {
            
            ArrayList<Course> tcs = stu.getTranscript().getCourses();
            int num = stu.getEmploymenthistory().getSameCoursesNum(tcs);
            repC[num]+=1;
            System.out.println("重复课程数量="+num);
        }

//promotion
        //for (StudentProfile stu : sd.getStudentlist()) {
      //      boolean a;
       //     for (Employment e1 : stu.getEmploymenthistory().getEmployments()) {
       //         for (Employment e2 : stu.getEmploymenthistory().getEmployments()) {

       //             if (e2.getEmploymentGrade() > e1.getEmploymentGrade()) {
       //                 a = true;
      //              } else {
       //                 a = false;
       //             }
                
       //         }
       //     }
       // }
       for(StudentProfile stu : sd.getStudentlist()){
            System.out.println(Collections.max(stu.getEmploymenthistory().getEmployments()).getEmploymentGrade());
        }
//pieChart
        HashMap<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < repC.length; i++) {
            if(repC[i]!=0)
                maps.put(i + " course", repC[i]);
        }

//      PieChart_AWT demo = new PieChart_AWT( "rank前100 选中相关课程数目的人数",maps );  
//      demo.setSize( 560 , 367 );    
//      RefineryUtilities.centerFrameOnScreen( demo );    
//      demo.setVisible( true ); 

//LineChart
        ArrayList<Float> gpas = new ArrayList<>();
        for (StudentProfile stu : sd.getStudentlist()) {
            float gpa = stu.getCurrentGpa();
            gpas.add(gpa);
        }
//      gpas.add(4.0f);
        LineChart_AWT chart = new LineChart_AWT(
                "Gpa Vs Rank",
                "Gpas vs Ranks",
                gpas,
                "gpa");

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
                
         
         

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

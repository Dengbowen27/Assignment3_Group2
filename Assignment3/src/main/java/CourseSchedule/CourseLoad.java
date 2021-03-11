/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author Dengbowen
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment();
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }

//    public float getSemesterScore() {
//        float sum = 0;
//        float credit = 0;
//        for(SeatAssignment sa:seatassignments){
//            sum = sum + sa.getCourseStudentScore();
//            credit = credit + sa.getCreditHours();
//        }
//        return sum/credit;
//    }
    public ArrayList<SeatAssignment> getSeatAssignments(){
        return seatassignments;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

/**
 *
 * @author Dengbowen
 */
public class Seat {
    Boolean occupied; 
    int number;
    SeatAssignment seatassignment;
    CourseOffer courseoffer;
    public Seat (CourseOffer co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        
    }
    
    public Boolean isOccupied(){
        return occupied;

    }
    public SeatAssignment newSeatAssignment(){
        
        seatassignment = new SeatAssignment(); //links seatassignment to seat
        seatassignment.setSeat(this);
        occupied = true;   
        return seatassignment;
    }
    public CourseOffer getCourseoffer(){
        return courseoffer;
    
    }
    
    public int getCourseCredits(){
        return courseoffer.getCreditHours();
    }

}

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
public class SeatAssignment {
    Seat seat;
    CourseLoad courseload;
    double grade;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
    }
    public SeatAssignment(){

    }
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    public int getCreditHours(){
        return seat.getCourseCredits();
    }
    public double getCourseStudentScore(){
        return getCreditHours()*grade;
    }
    
    public void setGrade(double grade){
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
    
}

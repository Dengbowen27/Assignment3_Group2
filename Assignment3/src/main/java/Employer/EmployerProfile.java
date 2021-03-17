/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employer;

import Faker.FakerUtl;
import Persona.EmploymentHistory.Employment;
import java.util.ArrayList;

/**
 *
 * @author Dengbowen
 */
public class EmployerProfile {
    String name;
    int weight;
    int quality;
    
    ArrayList<Employment> employments;
    public EmployerProfile(String n,int w,int q){  //could be company instead of just a name as a string
        name = n;
        weight = w;
        quality = q;
        employments = new ArrayList<>();
    }
    public boolean isMatch(String id){
        if(name.equals(id)) return true;             //String is an object and can do equal matach
        return false;
    }

    public String getName() {
        return name;
    }

    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
    
    public void addEmpoyment(Employment e){
        employments.add(e);
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }
    public Employment getOneEmployment(){
        int lenght = employments.size()-1;
        return employments.get(FakerUtl.randomIntNum(0, lenght));
    }
    
    

    @Override
    public String toString() {
        return "EmployerProfile{" + "name=" + name + ", weight=" + weight + ", quality=" + quality + ", employments=" + employments + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

/**
 *
 * @author Dengbowen
 */
public class Person {
    String name;
    String id;
    public Person (String id,String name){
        this.name = name;
        this.id = id;
    }
    public String getPersonId(){
        return id;
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + '}';
    }
    
    
    
}

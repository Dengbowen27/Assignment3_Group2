/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employer;

import Persona.Faculty.*;
import Persona.*;
import Department.Department;
import Faker.FakerUtl;
import java.util.ArrayList;

/**
 *
 * @author Dengbowen
 */
public class EmployerDirectory {
    Department department;
    ArrayList<EmployerProfile> employerlist;

    public EmployerDirectory(Department d) {

        department = d;
        employerlist = new ArrayList();

    }

    public EmployerProfile newEmployerProfile(String name,int weight,int quality) {

        EmployerProfile sp = new EmployerProfile(name,weight,quality);
        employerlist.add(sp);
        return sp;
    }

    public EmployerProfile findEmployerProfile(String id) {

        for (EmployerProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
        return null; //not found after going through the whole list
    }
    
    //get one random employer (for ingest data)
    public EmployerProfile getOneEmployerProfile(){
        int lenght = employerlist.size()-1;
        return employerlist.get(FakerUtl.randomIntNum(0, lenght));
    }
}

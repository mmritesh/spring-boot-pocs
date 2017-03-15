package com.jpademo.Service;

import com.jpademo.Entities.Employee;
import com.jpademo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ritesh on 17-10-2016.
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;



    public void save(Employee employee){
        employeeRepo.save(employee);
    }

    public long count(){
        return employeeRepo.count();
    }

    public Employee findByEmpId(int id){

        return employeeRepo.findByEmpId(id);
    }

    public Employee findByName(String name){
        return employeeRepo.findByName(name);
    }

}

package com.jpademo.Service;

import com.jpademo.Entities.Department;
import com.jpademo.Entities.Employee;
import com.jpademo.Repository.DepartmentRepo;
import com.jpademo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Ritesh on 17-10-2016.
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public void save(Employee employee){

        Department department = departmentRepo.findByDeptName(employee.getDeptId().getDeptName());
        if(Objects.isNull(department)){
            department  = new Department();
            department.setDeptName(employee.getDeptId().getDeptName());
            department = departmentRepo.save(department);
        }
        employee.setDeptId(department);
        employeeRepo.save(employee);
    }

    public long count(){
        return employeeRepo.count();
    }

    public Employee findById(long id){

        return employeeRepo.findById(id);
    }

    public Employee findByName(String name){
        return employeeRepo.findByName(name);
    }

}

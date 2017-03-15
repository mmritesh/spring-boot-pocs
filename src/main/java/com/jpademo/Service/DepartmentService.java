package com.jpademo.Service;

import com.jpademo.Entities.Department;
import com.jpademo.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * Created by Ritesh on 17-10-2016.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department findById(int id){
        return departmentRepo.findById(id);
    }

    public Department save(Department dept){
        return departmentRepo.save(dept);
    }


    public int update (long id, String deptName){
       return departmentRepo.updateDeptName(id,deptName);
    }
}

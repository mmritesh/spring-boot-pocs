package com.jpademo.Service;

import com.jpademo.Entities.Department;
import com.jpademo.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public List<Department> findAll(){
        return departmentRepo.findAll();
    }
    public Department save(Department dept){
        Department department = departmentRepo.findByDeptName(dept.getDeptName());

        if(Objects.isNull(department)){
            return departmentRepo.save(dept);
        }else{
            return department;
        }

    }

    public int update (long id, String deptName){
       return departmentRepo.updateDeptName(id,deptName);
    }
}

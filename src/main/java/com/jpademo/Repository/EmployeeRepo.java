package com.jpademo.Repository;

import com.jpademo.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ritesh on 17-10-2016.
 */

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    public Employee findByEmpId(long id);

    public Employee findByName(String name);
}

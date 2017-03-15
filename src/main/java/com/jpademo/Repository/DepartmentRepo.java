package com.jpademo.Repository;

import com.jpademo.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Ritesh on 17-10-2016.
 */
@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    public Department findById(long id);

    public Department findByDeptName(String name);

    @Modifying
    @Query("UPDATE Department d SET d.deptName = :deptname WHERE d.id = :id")
    int updateDeptName(@Param("id") long id, @Param("deptname") String deptName);
}

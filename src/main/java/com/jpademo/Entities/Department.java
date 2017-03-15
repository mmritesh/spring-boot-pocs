package com.jpademo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Ritesh on 17-10-2016.
 */

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department extends Auditing {
    //@Id
    //private int id;

    /*@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private List<Employee> employees;*/

    private Long deptId;
    private String deptName;


}

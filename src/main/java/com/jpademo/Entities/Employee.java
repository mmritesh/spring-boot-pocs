package com.jpademo.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by Ritesh on 17-10-2016.
 */

@Getter
@Setter
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee extends Auditing {

   // @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private String name;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department deptId;

}

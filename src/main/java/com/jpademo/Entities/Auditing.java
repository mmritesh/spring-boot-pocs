package com.jpademo.Entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by Ritesh on 24-10-2016.
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditing extends Persistable {
    @Column(name = "created_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date modifiedDate;

    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private String createdBy = "";

    @LastModifiedBy
    @Column(name = "modified_by", nullable = false)
    private String modifiedBy = "";

}

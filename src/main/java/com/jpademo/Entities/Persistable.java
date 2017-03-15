package com.jpademo.Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ritesh on 24-10-2016.
 */

@MappedSuperclass
public class Persistable implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    protected long id;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
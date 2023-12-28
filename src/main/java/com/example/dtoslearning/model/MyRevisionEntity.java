package com.example.dtoslearning.model;

import jakarta.persistence.Entity;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@RevisionEntity(MyRevisionListener.class)
public class MyRevisionEntity extends DefaultRevisionEntity {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

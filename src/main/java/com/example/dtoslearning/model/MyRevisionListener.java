package com.example.dtoslearning.model;

import org.hibernate.envers.RevisionListener;


import java.util.Date;

public class MyRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object o) {
        MyRevisionEntity myRevisionEntity = (MyRevisionEntity) o;
        myRevisionEntity.setDate(new Date());
    }

}

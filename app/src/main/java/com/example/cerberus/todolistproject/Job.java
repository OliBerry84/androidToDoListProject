package com.example.cerberus.todolistproject;

import java.io.Serializable;

/**
 * Created by cerberus on 27/03/2018.
 */

public class Job implements Serializable {

    private Integer id;
    private String title;
    private String description;

    public Job (Integer id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

}
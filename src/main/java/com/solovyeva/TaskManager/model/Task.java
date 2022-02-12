package com.solovyeva.TaskManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column( name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date lastUpdate;


    public Task() {
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Task(String name, String description, Date lastUpdate) {
        this.name = name;
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    public Task(int id, String name, String description, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

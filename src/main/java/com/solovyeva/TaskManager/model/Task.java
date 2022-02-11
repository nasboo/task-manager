package com.solovyeva.TaskManager.model;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private String description;
    private Date lastUpdate;

    public Task() {
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

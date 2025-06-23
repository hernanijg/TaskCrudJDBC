package org.jdbc.model;


//import java.util.Date;

import java.sql.Date;

public class Task {
    private long id;
    private String name;
    private Date register_date;
    private Enum<TaskStatus> status;
    private Date due_date;
    private Enum<TaskPriority> priority;

    public Task() {}

    public Task(Long id, String name, Date register_date, Enum<TaskStatus> status, Date due_date, Enum<TaskPriority> priority) {
        this.id = id;
        this.name = name;
        this.register_date = register_date;
        this.status = status;
        this.due_date = due_date;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Enum<TaskStatus> getStatus() {
        return status;
    }

    public void setStatus(Enum<TaskStatus> status) {
        this.status = status;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Enum<TaskPriority> getPriority() {
        return priority;
    }

    public void setPriority(Enum<TaskPriority> priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {

        StringBuilder m = new StringBuilder();
        m.append(this.id).append("| -").append(this.name).append(" ").append(this.register_date)
                .append(" -> ").append(this.due_date).append("\n").append(this.status)
                .append(" ").append(this.priority);

        return m.toString();
    }
}

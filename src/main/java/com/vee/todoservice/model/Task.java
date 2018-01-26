package com.vee.todoservice.model;

public class Task {

    private Long id;
    private String taskName;
    private boolean isChecked;
    public Task() {
        // default creation isChecked = false
        isChecked = false;
    }

    public Task(String taskName) {
        this();
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", taskName=" + taskName + ", isChecked=" + isChecked + "]";
    }
}

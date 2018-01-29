package com.vee.todoservice.model;

public class Task {

    private Long id;
    private String taskName;
    private boolean checked;
    public Task() {
        // default creation isChecked = false
        checked = false;
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
        return checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    @Override
    public String toString() {
        return "Task [id=" + id + ", taskName=" + taskName + ", checked=" + checked + "]";
    }
}

package com.vee.todoservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vee.todoservice.model.Task;
import com.vee.todoservice.services.TaskService;

@Service
public class DummyTaskService implements TaskService {

    private List<Task> dummyTaskContainer;
   
    private Long getNextId() {
        return dummyTaskContainer.stream().mapToLong(t -> t.getId()).max().orElseGet(() -> 0L) + 1;
    }
    
    public DummyTaskService() {
        resetDummyData();
    }
    
    public Task addTask(Task task) {
        // avoid task without task description
        if(!task.getTaskName().isEmpty()) {
            task.setId(getNextId());
            this.dummyTaskContainer.add(task);
        }
        return task;
    }

    public void removeTask(Task task) {
        this.dummyTaskContainer.remove(task);
    }

    public void toggleTaskCheck(Task task) {
        if(dummyTaskContainer.contains(task)) {
            int idx = dummyTaskContainer.indexOf(task);
            dummyTaskContainer.get(idx).setChecked(!task.isChecked());
        }
    }

    public List<Task> findAll() {
        return this.dummyTaskContainer;
    }

    public Task findByID(final Long id) {
        Optional<Task> optTask = this.dummyTaskContainer.stream().filter(t -> t.getId().equals(id)).findAny();
        return optTask.get();
    }
    
    public void resetDummyData() {
        this.dummyTaskContainer = new ArrayList<Task>();
        for(int a=1;a<=5;a++) {
            Task task = addTask(new Task(String.format("Dummy Task %d", a)));
            if(a%2==0)
                task.setChecked(true);
        }
    }

}

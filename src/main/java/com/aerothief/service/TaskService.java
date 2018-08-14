package com.aerothief.service;

import com.aerothief.entity.Series;
import com.aerothief.entity.Task;
import org.jsoup.nodes.Document;

import java.util.List;

public interface TaskService {
    public List<Task> getTaskFromVideoCode(Document doc);
    public Task createTask(Task task);
    public List<Task> createTasks(List<Task> taskList);
    public Task getOneTaskUnsuccess();
    public void setTaskSuccess(int id);
    public void setTaskError(int id);
}

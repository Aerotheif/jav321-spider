package com.aerothief.dao;

import com.aerothief.entity.Task;

public interface TaskDao {
    public Boolean selectTaskExist(String videoPath);
    public Task insertTask(Task task);
    public Task selectUnSuccessTask();
    public void updateTaskSuccessById(int id);
    public void updateTaskWorkingById(int id);
    public void updateTaskErrorById(int id);
}

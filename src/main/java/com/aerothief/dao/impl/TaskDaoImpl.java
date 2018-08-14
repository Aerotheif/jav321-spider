package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.TaskDao;
import com.aerothief.entity.Task;

public class TaskDaoImpl implements TaskDao {
    @Override
    public Boolean selectTaskExist(String videoPath) {
        int flag=MybatisConnecter.sqlSessionTemplate.selectOne("Task.selectTaskExist",videoPath);
        return flag>=1;
    }

    @Override
    public Task insertTask(Task task) {
        MybatisConnecter.sqlSessionTemplate.selectOne("Task.insertTask",task);
        return task;
    }

    @Override
    public Task selectUnSuccessTask() {
        return MybatisConnecter.sqlSessionTemplate.selectOne("Task.selectUnSuccessTask");
    }

    @Override
    public void updateTaskSuccessById(int id) {
        MybatisConnecter.sqlSessionTemplate.update("Task.updateTaskSuccessById",id);
    }

    @Override
    public void updateTaskWorkingById(int id) {
        MybatisConnecter.sqlSessionTemplate.update("Task.updateTaskWorkingById",id);
    }



    @Override
    public void updateTaskErrorById(int id) {
        MybatisConnecter.sqlSessionTemplate.update("Task.updateTaskErrorById",id);
    }
}

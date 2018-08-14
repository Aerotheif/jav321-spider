package com.aerothief.service.impl;

import com.aerothief.common.Const;
import com.aerothief.dao.TaskDao;
import com.aerothief.dao.impl.TaskDaoImpl;
import com.aerothief.entity.Task;
import com.aerothief.service.TaskService;
import com.aerothief.util.DocumentUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao=new TaskDaoImpl();
    private Logger logger =Logger.getLogger(TaskServiceImpl.class);
    @Override
    public List<Task> getTaskFromVideoCode(Document doc) {
        List<Element> aElementList=doc.getElementsByTag("a");
        List<Task> taskList=new ArrayList<>();
        for(Element element:aElementList){
            String[] urlSplit=element.attr("href").split("/");
            if(urlSplit.length>2&&"video".equals(urlSplit[1])){
                taskList.add(new Task(urlSplit[2]));
            }
        }
        return taskList;
    }

    @Override
    public Task createTask(Task task) {
        if(!taskDao.selectTaskExist(task.getVideoPath())){
            task=taskDao.insertTask(task);
            logger.info("新建任务:"+task);
        }else {
            logger.info("任务已存在:"+task);
        }
        return task;
    }

    @Override
    public List<Task> createTasks(List<Task> taskList) {
        List<Task> reqTaskList=new ArrayList<>();
        for(Task task:taskList){
            reqTaskList.add(this.createTask(task));
        }
        return reqTaskList;
    }

    @Override
    public Task getOneTaskUnsuccess() {
        Task task=taskDao.selectUnSuccessTask();
        taskDao.updateTaskWorkingById(task.getId());
        return task;
    }

    @Override
    public void setTaskSuccess(int id) {
        taskDao.updateTaskSuccessById(id);
    }

    @Override
    public void setTaskError(int id) {
        taskDao.updateTaskErrorById(id);
    }


    public static void main(String[] args) {
//        String videoUrl=Const.URL+Const.VIDEO_PATH+"mifd00046";
//        DocumentUtils.setDoc(videoUrl);
        TaskService taskService=new TaskServiceImpl();
//        List<Task> taskList=taskService.getTaskFromVideoCode(DocumentUtils.getDoc());
//        taskService.createTasks(taskList);
        Task task=((TaskServiceImpl) taskService).taskDao.selectUnSuccessTask();
        System.out.println(task);
    }
}

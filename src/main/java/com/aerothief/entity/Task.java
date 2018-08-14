package com.aerothief.entity;

import java.sql.Timestamp;

public class Task {
    private Integer id;
    private String videoPath;
    private String success;
    private Integer retryTimes;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", videoPath='" + videoPath + '\'' +
                ", success='" + success + '\'' +
                ", retryTimes=" + retryTimes +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Task(String videoPath) {
        this.videoPath = videoPath;
    }

    public Task( String videoPath, String success,Integer id, Integer retryTimes, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.videoPath = videoPath;
        this.success = success;
        this.retryTimes = retryTimes;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}

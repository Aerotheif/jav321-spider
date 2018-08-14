package com.aerothief.entity;

import java.sql.Timestamp;

public class Video {
    private Integer id;
    private String videoCode;
    private String pathCode;
    private String name;
    private String context;
    private String title;
    private Timestamp publishDate;
    private Integer publisherId;
    private Integer duration;
    private Integer seriesId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getPathCode() {
        return pathCode;
    }

    public void setPathCode(String pathCode) {
        this.pathCode = pathCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
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

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoCode='" + videoCode + '\'' +
                ", pathCode='" + pathCode + '\'' +
                ", name='" + name + '\'' +
                ", context='" + context + '\'' +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", publisherId=" + publisherId +
                ", duration=" + duration +
                ", seriesId=" + seriesId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

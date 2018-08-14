package com.aerothief.entity;

import java.sql.Time;
import java.sql.Timestamp;

public class Genre {
    private String name;
    private Integer id;
    private String webCode;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Genre() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebCode() {
        return webCode;
    }

    public void setWebCode(String webCode) {
        this.webCode = webCode;
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

    public Genre(String name, String webCode) {
        this.name = name;
        this.webCode = webCode;
    }

    public Genre(String name, int id, String webCode, Timestamp createTime, Timestamp updateTime) {

        this.name = name;
        this.id = id;
        this.webCode = webCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", webCode='" + webCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

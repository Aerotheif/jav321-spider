package com.aerothief.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Series {
    private String name;
    private String webCode;
    private Integer id;
    private Timestamp updateTime;
    private Timestamp createTime;

    public String getWebCode() {
        return webCode;
    }

    public void setWebCode(String webCode) {
        this.webCode = webCode;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Series(String name, Integer id, Timestamp updateTime, Timestamp createTime,String webCode) {
        this.webCode=webCode;
        this.name = name;
        this.id = id;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public Series(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Series(String name,String webCode) {
        this.name = name;
        this.webCode=webCode;
    }

    public Series(String name, String webCode, Integer id, Timestamp updateTime, Timestamp createTime) {
        this.name = name;
        this.webCode = webCode;
        this.id = id;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", webCode='" + webCode + '\'' +
                ", id=" + id +
                '}';
    }
}

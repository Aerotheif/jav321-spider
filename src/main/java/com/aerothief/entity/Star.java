package com.aerothief.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Star {
    private int id;
    private String webCode;
    private String name;
    private Timestamp updateTime;
    private Timestamp createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Objects.equals(webCode, star.webCode) &&
                Objects.equals(name, star.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(webCode, name);
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", webCode='" + webCode + '\'' +
                ", name='" + name + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }

    public Star() {
    }

    public Star(int id, String webCode, String name, Timestamp updateTime, Timestamp createTime) {
        this.id = id;
        this.webCode = webCode;
        this.name = name;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public Star(String webCode, String name) {
        this.webCode = webCode;
        this.name = name;
    }

    public int getId() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

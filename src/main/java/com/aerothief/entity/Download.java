package com.aerothief.entity;

import java.sql.Timestamp;

public class Download {
    private String downloadUrl;
    private Integer id;
    private Float size;
    private Integer hot;
    private String name;
    private String unit;
    private String urlType;
    private Integer videoId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
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

    public Download(String downloadUrl, Integer id, Float size, Integer hot, String name, String unit, String urlType, Integer videoId, Timestamp createTime, Timestamp updateTime) {
        this.downloadUrl = downloadUrl;
        this.id = id;
        this.size = size;
        this.hot = hot;
        this.name = name;
        this.unit = unit;
        this.urlType = urlType;
        this.videoId = videoId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Download() {
    }

    @Override
    public String toString() {
        return "Download{" +
                "downloadUrl='" + downloadUrl + '\'' +
                ", id=" + id +
                ", size=" + size +
                ", hot=" + hot +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", urlType='" + urlType + '\'' +
                ", videoId=" + videoId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

package com.aerothief.dao;

import com.aerothief.entity.Video;

import java.util.Map;

public interface VideoDao {
    public Video insertVideo(Video video);
    public Boolean selectVideoExistByVideoCode(String videoCode);
    public Video selectVideoByVideoCode(String videoCode);
    public void insertTheVideoToGenre(Map map);
    public void insertTheVideoToStar(Map map);
    public void updateVideo(Video video);
    public int selectVideoCount();


}

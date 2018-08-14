package com.aerothief.service;

import com.aerothief.entity.Video;
import org.jsoup.nodes.Document;

import java.util.Map;

public interface VideoService {
    public Video getVideoFromVideoCode(Document doc);
    public Video createVideo(Video video);
    public void setVideoToGenre(Map map);
    public void setVideoToStar(Map map);
    public void updateVideo(Video video);
    public int getVideoCount();
}

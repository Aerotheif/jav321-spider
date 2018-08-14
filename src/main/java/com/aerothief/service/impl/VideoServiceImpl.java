package com.aerothief.service.impl;

import com.aerothief.common.Const;
import com.aerothief.dao.VideoDao;
import com.aerothief.dao.impl.VideoDaoImpl;
import com.aerothief.entity.*;
import com.aerothief.service.*;
import com.aerothief.util.DocumentUtils;
import com.aerothief.util.TimeUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VideoServiceImpl implements VideoService {
    private VideoDao videoDao=new VideoDaoImpl();
    private PublisherService publisherService=new PublisherServiceImpl();
    private GenreService genreService=new GenreServiceImpl();
    private SeriesService seriesService=new SeriesServiceImpl();
    private TaskService taskService=new TaskServiceImpl();
    private DownloadService downloadService=new DownloadServiceImpl();
    private Logger logger=Logger.getLogger(VideoServiceImpl.class);

    @Override
    public Video getVideoFromVideoCode(Document doc) {
        Video video=new Video();
        String name=doc.getElementsByTag("h3").get(0).text();
        String pathCode=DocumentUtils.path.split("/")[DocumentUtils.path.split("/").length-1];
        video.setPathCode(pathCode);
        video.setName(name);
        Element panelBodyElement=doc.getElementsByClass("panel-body").get(0);
        Element mainInfosElement=doc.getElementsByClass("col-md-9").get(0);
        String[] values=mainInfosElement.text().split(" ");
        for(int i=0;i<values.length;i++){
            if(values[i].indexOf(':')!=-1){
                values[i]=values[i].substring(0,values[i].lastIndexOf(':'));
            }
            values[i]=values[i].trim();
        }
        for(int i=0;i<values.length;i++){
            switch (values[i]){
                case "标签":
                    //todo
                    break;
                case "番号":
                    video.setVideoCode(values[i+1].trim());
                    break;
                case "发行日期":
                    video.setPublishDate(TimeUtils.stringToTimestamp(values[i+1]));
                    break;
                case "播放时长":
                    video.setDuration(Integer.valueOf(values[i+1]));
                    break;
                default:
                    break;
            }
        }
        return video;
    }

    @Override
    public Video createVideo(Video video) {
        if(!videoDao.selectVideoExistByVideoCode(video.getVideoCode())){
            video=videoDao.insertVideo(video);
            logger.info("新建video:"+video);
        }else{
            video=videoDao.selectVideoByVideoCode(video.getVideoCode());
            logger.info("video已存在:"+video);
        }
        return video;
    }

    @Override
    public void setVideoToGenre(Map map) {
        videoDao.insertTheVideoToGenre(map);
    }

    @Override
    public void setVideoToStar(Map map) {
        videoDao.insertTheVideoToStar(map);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public int getVideoCount() {
        return videoDao.selectVideoCount();
    }
}

package com.aerothief;

import com.aerothief.common.Const;
import com.aerothief.dao.SeriesDao;
import com.aerothief.dao.impl.SeriesDaoImpl;
import com.aerothief.entity.*;
import com.aerothief.service.*;
import com.aerothief.service.impl.*;
import com.aerothief.util.DocumentUtils;
import org.apache.log4j.Logger;
import org.jsoup.HttpStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static TaskService taskService=new TaskServiceImpl();
    public static VideoService videoService=new VideoServiceImpl();
    public static SeriesService seriesService=new SeriesServiceImpl();
    public static GenreService genreService=new GenreServiceImpl();
    public static PublisherService publisherService=new PublisherServiceImpl();
    public static DownloadService downloadService=new DownloadServiceImpl();
    public static PicService picService=new PicServiceImpl();
    public static StarService starService=new StarServiceImpl();
    private static Logger logger=Logger.getLogger(Main.class);
    private static Task task;

    public static void main(String[] args) {
        while(true){
            try{
                doMain();
            }catch (Exception e){
                e.printStackTrace();
                taskService.setTaskError(task.getId());
            }

        }
    }

    private static void doMain() throws HttpStatusException {

        task=taskService.getOneTaskUnsuccess();
        String videoUrl=Const.URL+Const.VIDEO_PATH+task.getVideoPath();
        Boolean flag=true;
        DocumentUtils.setDoc(videoUrl);
        if(flag){
            Video video=videoService.getVideoFromVideoCode(DocumentUtils.getDoc());
            video=videoService.createVideo(video);

            //处理磁力链信息
            List<Download> downloadList=downloadService.getDownloadFromVideoCode(DocumentUtils.getDoc(),video.getId());
            downloadService.createDownloads(downloadList);

            //处理专辑信息
            Series series=seriesService.getSeriesFromVideoCode(DocumentUtils.getDoc());
            series=seriesService.createSeries(series);
            video.setSeriesId(series.getId());

            //处理标签信息
            List<Genre> genreList=genreService.getGenreFromVideoCode(DocumentUtils.getDoc());
            genreList=genreService.createGenres(genreList);

            // 建立标签与影片对应关系
            for(Genre genre:genreList){
                Map videoToGenreMap=new HashMap();
                videoToGenreMap.put("videoId",video.getId());
                videoToGenreMap.put("genreId",genre.getId());
                videoService.setVideoToGenre(videoToGenreMap);
            }

            //处理演员信息
            List<Star> starList=starService.getStarFromVideoCode(DocumentUtils.getDoc());
            starList=starService.createStars(starList);
            //处理演员影片对应关系
            for(Star star:starList){
                Map videoToStarMap=new HashMap();
                videoToStarMap.put("videoId",video.getId());
                videoToStarMap.put("starId",star.getId());
                videoService.setVideoToStar(videoToStarMap);
            }



            //处理发行商信息
            Publisher publisher=publisherService.getPublisherFromVideoCode(DocumentUtils.getDoc());
            publisher=publisherService.createPublisher(publisher);
            video.setPublisherId(publisher.getId());

            //保存影片截图
            Boolean savePicSuccess=picService.getPicFromVideoCode(DocumentUtils.getDoc());

            //写入video的片商与专辑信息
            videoService.updateVideo(video);

            //处理该页面任务
            List<Task> taskList=taskService.getTaskFromVideoCode(DocumentUtils.getDoc());
            taskService.createTasks(taskList);

            if(savePicSuccess){
                taskService.setTaskSuccess(task.getId());
            }else{
                taskService.setTaskError(task.getId());
            }

        }
    }
}

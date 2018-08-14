package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.VideoDao;
import com.aerothief.entity.Video;

import java.util.Map;

public class VideoDaoImpl implements VideoDao {
    @Override
    public Video insertVideo(Video video) {
        MybatisConnecter.sqlSessionTemplate.insert("Video.insertVideo",video);
        return video;
    }

    @Override
    public Boolean selectVideoExistByVideoCode(String videoCode) {
        int flag=MybatisConnecter.sqlSessionTemplate.selectOne("Video.selectVideoExistByVideoCode",videoCode);
        return flag>=1;
    }

    @Override
    public Video selectVideoByVideoCode(String videoCode) {
        return MybatisConnecter.sqlSessionTemplate.selectOne("Video.selectVideoByVideoCode",videoCode);
    }

    @Override
    public void insertTheVideoToGenre(Map map) {
        MybatisConnecter.sqlSessionTemplate.insert("Video.insertTheVideoToGenre",map);
    }
    @Override
    public void insertTheVideoToStar(Map map) {
        MybatisConnecter.sqlSessionTemplate.insert("Video.insertTheVideoToStar",map);
    }

    @Override
    public void updateVideo(Video video) {
        MybatisConnecter.sqlSessionTemplate.update("Video.updateVideo",video);
    }

    @Override
    public int selectVideoCount() {
        return MybatisConnecter.sqlSessionTemplate.selectOne("Video.selectVideoCount");
    }
}

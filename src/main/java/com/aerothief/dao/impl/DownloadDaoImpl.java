package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.DownloadDao;
import com.aerothief.entity.Download;
import com.aerothief.service.DownloadService;

public class DownloadDaoImpl implements DownloadDao {
    @Override
    public Download insertDownload(Download download) {
        MybatisConnecter.sqlSessionTemplate.insert("Download.insertDownload",download);
        return download;
    }

    @Override
    public Boolean selectDownLoadExist(String downloadUrl) {
       int flag= MybatisConnecter.sqlSessionTemplate.selectOne("Download.selectDownLoadExist",downloadUrl);
       return flag>=1;
    }
}

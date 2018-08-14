package com.aerothief.dao;

import com.aerothief.entity.Download;

public interface DownloadDao {
    public Download insertDownload(Download download);
    public Boolean selectDownLoadExist(String downloadUrl);
}

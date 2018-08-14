package com.aerothief.service;

import com.aerothief.entity.Download;
import com.aerothief.entity.Genre;
import org.jsoup.nodes.Document;

import java.util.List;

public interface DownloadService {
    public List<Download> getDownloadFromVideoCode(Document doc,int videoId);
    public Download createDownload(Download download);
    public List<Download> createDownloads(List<Download> downloads);
}

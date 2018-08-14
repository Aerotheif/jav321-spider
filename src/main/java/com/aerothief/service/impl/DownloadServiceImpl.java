package com.aerothief.service.impl;

import com.aerothief.common.Const;
import com.aerothief.dao.DownloadDao;
import com.aerothief.dao.impl.DownloadDaoImpl;
import com.aerothief.entity.Download;
import com.aerothief.service.DownloadService;
import com.aerothief.util.DocumentUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class DownloadServiceImpl implements DownloadService {
    private DownloadDao downloadDao=new DownloadDaoImpl();
    Logger logger=Logger.getLogger(DownloadServiceImpl.class);
    @Override
    public List<Download> getDownloadFromVideoCode(Document doc,int videoId) {
        List<Element> brElementList=doc.getElementsByTag("tr");
        List<Download> downloadList=new ArrayList<>();
        for(Element element:brElementList){
            String domString=element.toString();
            if(domString.indexOf("magnet")!=-1||domString.indexOf("ed2k://")!=-1){
                Download download=new Download();
                download.setVideoId(videoId);
                String size=element.getElementsByTag("td").get(1).text().trim();
                if(size.indexOf("GB")!=-1){
                    download.setSize(Float.valueOf(size.substring(0,size.indexOf("GB"))));
                    download.setUnit("GB");
                }else if(size.indexOf("MB")!=-1){
                    download.setSize(Float.valueOf(size.substring(0,size.indexOf("MB"))));
                    download.setUnit("MB");
                }
                if(domString.indexOf("magnet")!=-1){
                    download.setUrlType("magnet");
                    download.setHot(Integer.parseInt(element.getElementsByTag("td").get(2).text()));
                    download.setName(element.getElementsByTag("td").get(0).text());
                    download.setDownloadUrl(element.getElementsByTag("td").get(3).getElementsByTag("a").get(0).attr("href"));
                    downloadList.add(download);
                }else if(domString.indexOf("ed2k://")!=-1){
                    download.setUrlType("ed2k");
                    download.setHot(Integer.parseInt(element.getElementsByTag("td").get(2).text()));
                    download.setName(element.getElementsByTag("td").get(0).text());
                    download.setDownloadUrl(element.getElementsByTag("td").get(4).getElementsByTag("a").get(0).attr("href"));
                    downloadList.add(download);
                }
            }
        }
        return downloadList;
    }

    @Override
    public Download createDownload(Download download) {
        if(!downloadDao.selectDownLoadExist(download.getDownloadUrl())){
            download=downloadDao.insertDownload(download);
            logger.info("新建Doanload:"+download);
        }
        return download;
    }

    @Override
    public List<Download> createDownloads(List<Download> downloads) {
        List<Download> reqDownloadList=new ArrayList<>();
        for(Download download:downloads){
            reqDownloadList.add(this.createDownload(download));
        }
        return reqDownloadList;
    }
}

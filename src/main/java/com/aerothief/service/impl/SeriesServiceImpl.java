package com.aerothief.service.impl;

import com.aerothief.common.Const;
import com.aerothief.dao.SeriesDao;
import com.aerothief.dao.impl.SeriesDaoImpl;
import com.aerothief.entity.Series;
import com.aerothief.service.SeriesService;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class SeriesServiceImpl implements SeriesService {
    private SeriesDao seriesDao=new SeriesDaoImpl();
    private Logger logger=Logger.getLogger(SeriesServiceImpl.class);
    /**
     * 从给定影片网站代码获取专辑信息
     * @param doc
     * @return
     */
    @Override
    public Series getSeriesFromVideoCode(Document doc) {
        Element mainContextElement=doc.getElementsByClass("row").get(1).getElementsByClass("row").get(1).getElementsByTag("div").get(2);
        Element seriesNameElement=mainContextElement.getElementsByTag("a").get(mainContextElement.getElementsByTag("a").size()-1);
        String name=seriesNameElement.text();
        String[] webUrl=seriesNameElement.attr("href").split("/");
        String webCode;
        if("series".equals(webUrl[1])){
            webCode=webUrl[2];
        }else{
            name="暂无专辑分类信息";
            webCode="000000";
        }
        Series series=new Series(name,webCode);
        return series;
    }

    @Override
    public Series createSeries(Series series) {
        if(!seriesDao.selectSeriesExistByName(series.getName())){
            series=seriesDao.insertSeries(series);
            logger.info("新增Series:"+series);
        }else{
            logger.info("Series已存在:"+series);
            series=seriesDao.selectSeries(series);
        }
        return series;
    }
}

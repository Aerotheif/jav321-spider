package com.aerothief.service.impl;

import com.aerothief.dao.StarDao;
import com.aerothief.dao.impl.StarDaoImpl;
import com.aerothief.entity.Star;
import com.aerothief.service.StarService;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StarServiceImpl implements StarService {
    Logger logger=Logger.getLogger(StarServiceImpl.class);
    StarDao starDao=new StarDaoImpl();
    @Override
    public List<Star> getStarFromVideoCode(Document doc) {
        List<Element> aElement=doc.getElementsByTag("a");
        List<Star> starList=new ArrayList<>();
        for(Element element:aElement){
            String hrefString=element.attr("href");
            if(hrefString.indexOf("/star/")!=-1){
                Star star=new Star(hrefString.split("/")[2],element.text());
                starList.add(star);
            }
        }
        Set set = new HashSet();
        //去重
        List newStartList = new  ArrayList();
        for (Star star:starList) {
            if(set.add(star)){
                newStartList.add(star);
            }
        }
        return newStartList;
    }

    @Override
    public Star createStar(Star star) {
        if(!starDao.selectStarExist(star.getWebCode())){
            star=starDao.insertStar(star);
            logger.info("新建Star:"+star);
        }else {
            star=starDao.selectStar(star.getWebCode());
            logger.info("Star已存在:"+star);
        }
        return star;
    }

    @Override
    public List<Star> createStars(List<Star> starList) {
        List<Star> reqList=new ArrayList<>();
        for (Star star:starList){
            reqList.add(this.createStar(star));
        }
        return reqList;
    }
}

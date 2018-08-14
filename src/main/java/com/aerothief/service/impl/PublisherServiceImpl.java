package com.aerothief.service.impl;

import com.aerothief.dao.PublisherDao;
import com.aerothief.dao.impl.PublisherDaoImpl;
import com.aerothief.entity.Publisher;
import com.aerothief.service.PublisherService;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    public PublisherDao publisherDao =new PublisherDaoImpl();
    private Logger logger=Logger.getLogger(PublisherServiceImpl.class);

    /**
     * 从给定影片网站代码获取发行商信息
     * @param doc
     * @return
     */
    @Override
    public Publisher getPublisherFromVideoCode(Document doc) {
        Element mainContextElement=doc.getElementsByClass("row").get(1).getElementsByClass("panel-body").get(0);
        List<Element> aElementList=mainContextElement.getElementsByTag("a");
        Element targetElement = null;
        for(Element element:aElementList){
            String[] temp=element.attr("href").split("/");
            if(temp.length>1&&"company".equals(temp[1].trim())){
                targetElement=element;
            }
        }
        Publisher publisher=null;
        if(targetElement==null){
            publisher =new Publisher("暂无制片公司信息");
        }else{
            publisher =new Publisher(targetElement.text());
        }
        return publisher;
    }

    /**
     * 创建新的发行商
     * @param publisher
     * @return
     */
    @Override
    public Publisher createPublisher(Publisher publisher) {
        if(!publisherDao.selectPublisherExist(publisher.getName().trim())){
            publisher = publisherDao.insertPublisher(publisher);
            logger.info("新增"+ publisher);
        }else{
            publisher=publisherDao.selectPublisher(publisher);
            logger.info(publisher+"已存在");
        }
        return publisher;
    }
}

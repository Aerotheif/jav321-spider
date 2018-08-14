package com.aerothief.service.impl;

import com.aerothief.common.Const;
import com.aerothief.service.PicService;
import com.aerothief.util.DocumentUtils;
import com.aerothief.util.PicUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PicServiceImpl implements PicService {
    @Override
    public Boolean getPicFromVideoCode(Document doc) {
        int expectionTimes=0;
        File file=new File(Const.PIC_SAVE_PATH+DocumentUtils.videoPath);
        if(!file.exists()){
            file.mkdir();
        }
        List<Element> picElementList=doc.getElementsByTag("img");
        List<String> forcePicUrlList=new ArrayList<>();
        for(Element element:picElementList){
            if(element.toString().indexOf(DocumentUtils.videoPath)!=-1){
                forcePicUrlList.add(element.attr("src"));
            }
        }
        for(int i=0;i<forcePicUrlList.size();i++){
            if(expectionTimes>=5){
                return false;
            }
            String picSrc=forcePicUrlList.get(i);
            try {
                PicUtils.savaPic(picSrc,DocumentUtils.videoPath);
            } catch (Exception e) {
                e.printStackTrace();
                expectionTimes++;
                i--;
            }
        }

        return true;
    }

}

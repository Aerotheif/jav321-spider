package com.aerothief.service.impl;

import com.aerothief.common.Const;
import com.aerothief.dao.GenreDao;
import com.aerothief.dao.impl.GenreDaoImpl;
import com.aerothief.entity.Genre;
import com.aerothief.service.GenreService;
import com.aerothief.util.DocumentUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenreServiceImpl implements GenreService {
    Logger logger=Logger.getLogger(GenreServiceImpl.class);
    private GenreDao genreDao=new GenreDaoImpl();
    @Override
    public List<Genre> getGenreFromVideoCode(Document doc) {
        Element mainContextElement=doc.getElementsByClass("row").get(1).getElementsByClass("row").get(1).getElementsByTag("div").get(2);
        List<Element> aTagElementList=mainContextElement.getElementsByTag("a");
        List<Genre> genreList=new ArrayList<>();
        for(Element element:aTagElementList){
            String[] tags=element.attr("href").split("/");
            if(tags.length>1&&"genre".equals(tags[1])){
                genreList.add(new Genre(element.text(),tags[2]));
            }
        }
        return genreList;
    }

    @Override
    public Genre getGenreByWebCodeAndName(Genre genre) {
        genre=genreDao.selectGenre(genre);
        return genre;
    }

    @Override
    public Genre createGenre(Genre genre) {
        if(!genreDao.selectGenreExistByName(genre.getName())){
            genre=genreDao.insertGenre(genre);
            logger.info("新建Genre:"+genre);
        }else {
            genre.setWebCode(null);
            genre=genreDao.selectGenre(genre);
            logger.info("Genre已存在:"+genre);
        }
        return genre;
    }

    @Override
    public List<Genre> createGenres(List<Genre> genres) {
        List<Genre> reqGenreList=new ArrayList<>();
        for(Genre genre:genres){
            reqGenreList.add(this.createGenre(genre));
        }
        return reqGenreList;
    }


}

package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.GenreDao;
import com.aerothief.entity.Genre;

import java.util.List;

public class GenreDaoImpl implements GenreDao {

    @Override
    public Genre selectGenre(Genre genre) {
        return MybatisConnecter.sqlSessionTemplate.selectOne("Genre.selectGenre",genre);
    }

    @Override
    public void insertGenreList(List<Genre> seriesList) {
        MybatisConnecter.sqlSessionTemplate.insert("Genre.insertGenreList",seriesList);
    }

    @Override
    public Genre insertGenre(Genre series) {
        MybatisConnecter.sqlSessionTemplate.insert("Genre.insertGenre",series);
        return series;
    }

    @Override
    public Boolean selectGenreExistByName(String name) {
        int flag=MybatisConnecter.sqlSessionTemplate.selectOne("Genre.selectGenreExist",name);
        return flag>=1;
    }
}

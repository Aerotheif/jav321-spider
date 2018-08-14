package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.SeriesDao;
import com.aerothief.entity.Series;

import java.util.List;

public class SeriesDaoImpl implements SeriesDao {
    @Override
    public void insertSeriesList(List<Series> seriesList) {
        MybatisConnecter.sqlSessionTemplate.insert("Series.insertSeriesList",seriesList);
    }
    @Override
    public Series insertSeries(Series series) {
        MybatisConnecter.sqlSessionTemplate.insert("Series.insertSeries",series);
        return series;
    }

    @Override
    public Boolean selectSeriesExistByName(String name) {
        int flag=MybatisConnecter.sqlSessionTemplate.selectOne("Series.selectSeriesExist",name);
        return flag>=1;
    }

    @Override
    public Series selectSeries(Series series) {
        return  MybatisConnecter.sqlSessionTemplate.selectOne("Series.selectSeries",series);
    }
}

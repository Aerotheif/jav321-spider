package com.aerothief.dao;

import com.aerothief.entity.Series;

import java.util.List;

public interface SeriesDao {
    public void insertSeriesList(List<Series> seriesList);
    public Series insertSeries(Series series);
    public Boolean selectSeriesExistByName(String name);
    public Series selectSeries(Series series);
}

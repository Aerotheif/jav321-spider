package com.aerothief.service;

import com.aerothief.entity.Series;
import org.jsoup.nodes.Document;

public interface SeriesService {
    public Series getSeriesFromVideoCode(Document doc);
    public Series createSeries(Series series);
}

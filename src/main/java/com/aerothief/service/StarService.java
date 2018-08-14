package com.aerothief.service;

import com.aerothief.entity.Download;
import com.aerothief.entity.Star;
import org.jsoup.nodes.Document;

import java.util.List;

public interface StarService {
    public List<Star> getStarFromVideoCode(Document doc);
    public Star createStar(Star star);
    public List<Star> createStars(List<Star> starList);
}

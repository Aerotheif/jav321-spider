package com.aerothief.dao;

import com.aerothief.entity.Download;
import com.aerothief.entity.Star;

public interface StarDao {
    public Star insertStar(Star star);
    public Star selectStar(String webCode);
    public Boolean selectStarExist(String webCode);
}

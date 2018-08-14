package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.StarDao;
import com.aerothief.entity.Star;

public class StarDaoImpl implements StarDao {
    @Override
    public Star insertStar(Star star) {
        MybatisConnecter.sqlSessionTemplate.insert("Star.insertStar",star);
        return star;
    }

    @Override
    public Star selectStar(String webCode) {
        return MybatisConnecter.sqlSessionTemplate.selectOne("Star.selectStar",webCode);
    }

    @Override
    public Boolean selectStarExist(String webCode) {
        System.out.println(webCode);
        int flag= MybatisConnecter.sqlSessionTemplate.selectOne("Star.selectStarExist",webCode);
        return flag>=1;
    }
}

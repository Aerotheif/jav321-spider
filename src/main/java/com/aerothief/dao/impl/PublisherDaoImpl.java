package com.aerothief.dao.impl;

import com.aerothief.common.MybatisConnecter;
import com.aerothief.dao.PublisherDao;
import com.aerothief.entity.Publisher;

public class PublisherDaoImpl implements PublisherDao {
    public Publisher insertPublisher(Publisher publisher){
        MybatisConnecter.sqlSessionTemplate.insert("Publisher.insertPublisher", publisher);
        return publisher;
    }

    @Override
    public Publisher selectPublisher(Publisher publisher) {
        return MybatisConnecter.sqlSessionTemplate.selectOne("Publisher.selectPublisher",publisher);
    }

    @Override
    public Boolean selectPublisherExist(String name) {
        int flag=MybatisConnecter.sqlSessionTemplate.selectOne("Publisher.selectPublisherExist",name);
        Boolean exist=flag>=1?true:false;
        return exist;
    }
}

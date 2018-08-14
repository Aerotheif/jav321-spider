package com.aerothief.dao;

import com.aerothief.entity.Publisher;

public interface PublisherDao {
    public Publisher insertPublisher(Publisher publisher);
    public Publisher selectPublisher(Publisher publisher);
    public Boolean selectPublisherExist(String name);
}

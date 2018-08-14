package com.aerothief.service;

import com.aerothief.entity.Publisher;
import org.jsoup.nodes.Document;

public interface PublisherService {
    public Publisher getPublisherFromVideoCode(Document doc);
    public Publisher createPublisher(Publisher publisher);
}

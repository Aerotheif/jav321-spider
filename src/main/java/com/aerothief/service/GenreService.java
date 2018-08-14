package com.aerothief.service;

import com.aerothief.entity.Genre;
import com.aerothief.entity.Series;
import org.jsoup.nodes.Document;

import java.util.List;

public interface GenreService {
    public List<Genre> getGenreFromVideoCode(Document doc);
    public Genre getGenreByWebCodeAndName(Genre genre);
    public Genre createGenre(Genre genre);
    public List<Genre> createGenres(List<Genre> genres);
}

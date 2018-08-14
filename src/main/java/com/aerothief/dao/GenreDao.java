package com.aerothief.dao;

import com.aerothief.entity.Genre;

import java.util.List;

public interface GenreDao {
    public Genre selectGenre(Genre genre);
    public void insertGenreList(List<Genre> seriesList);
    public Genre insertGenre(Genre series);
    public Boolean selectGenreExistByName(String name);
}

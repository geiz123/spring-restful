package com.dao;

import java.util.List;

import com.entity.Album;

public interface AlbumDao {
    public List<Album> getAll();

    public List<Album> getByName(String name);

    public Album getById(int id);
}

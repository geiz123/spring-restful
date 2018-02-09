package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.AlbumDao;
import com.entity.Album;
import com.entity.mapper.AlbumMapper;

@Repository("albumDaoImpl")
public class AlbumDaoImpl implements AlbumDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Album> getAll() {
        List<Album> employees = jdbcTemplate.query("select * from albums", new AlbumMapper());

        return employees;
    }

    @Override
    public List<Album> getByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Album getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}

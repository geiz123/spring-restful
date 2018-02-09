package com.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.SpringConfig;
import com.dao.AlbumDao;
import com.entity.Album;

@RestController
public class AlbumCtrler {
    
    @RequestMapping("/albums")
    public List<Album> getAllEmployees() {
        List<Album> ret = null;
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            AlbumDao pd = (AlbumDao) context.getBean("albumDaoImpl");
            
            ret = pd.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}

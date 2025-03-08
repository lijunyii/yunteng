package com.yunteng.service.impl;

import com.yunteng.mapper.ManageMapper;
import com.yunteng.pojo.Manage;
import com.yunteng.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public  class ManageServiceImpl implements ManageService {

    @Autowired
    private ManageMapper manageMapper;



    @Override
    public void save(Manage manage) {
        manage.setCreateTime(LocalDateTime.now());
        manage.setUpdateTime(LocalDateTime.now());
        manageMapper.insert(manage);
    }

    @Override
    public Manage getById(Integer id) {
        return null;
    }


    @Override
    public Manage login(Manage manage){
        return manageMapper.getByUsernameAndPassword(manage);
    }

    @Override
    public Manage login(String username, String password) {
        Manage manage = new Manage();
        manage.setUsername(username);
        manage.setPassword(password);
        return manageMapper.getByUsernameAndPassword(manage);
    }
}

package com.yunteng.service.impl;

import com.yunteng.mapper.ManageMapper;
import com.yunteng.pojo.Manage;
import com.yunteng.service.ManageService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManageServicelmpl implements ManageService {
    @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<Manage> list() {
        return manageMapper.list();
    }

    @Override
    public void delete(Integer id) {
        try {
            manageMapper.deleteById(id);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    private void setCreateAndUpdateTime(Manage manage) {
        manage.setCreateTime(LocalDateTime.now());
        manage.setUpdateTime(LocalDateTime.now());
    }

    @Override
    public void add(Manage manage) {
        setCreateAndUpdateTime(manage);
        try {
            manageMapper.insert(manage);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    @Override
    public void save(Manage manage) {
        add(manage);
    }

    @Override
    public Manage getById(Integer id) {
        try {
            return manageMapper.getById(id);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Manage login(Manage manage) {
        try {
            return manageMapper.getByUsernameAndPassword(manage);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Manage login(String username, String password) {
        Manage manage = new Manage();
        manage.setUsername(username);
        manage.setPassword(password);
        return login(manage);
    }
}
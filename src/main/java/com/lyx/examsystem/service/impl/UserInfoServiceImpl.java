package com.lyx.examsystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lyx.examsystem.dao.UserInfoEntityMapper;
import com.lyx.examsystem.entity.UserInfoEntity;
import com.lyx.examsystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoEntityMapper mapper;


    @Override
    public boolean save(UserInfoEntity entity) {
        try{
          int i=  mapper.insert(entity);
          return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserInfoEntity selectByID(Integer id) {
        UserInfoEntity entity=new UserInfoEntity();
        try {
            entity=mapper.selectByPrimaryKey(id);
        }catch (Exception e){
           e.printStackTrace();
        }
        return entity;
    }


    @Override
    public boolean updateByID(UserInfoEntity entity) {
        try{
            int i=  mapper.updateByPrimaryKey(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteByID(Integer id) {
        try{
            int i=  mapper.deleteByPrimaryKey(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public JSONObject loginCheck(UserInfoEntity entity) {
        JSONObject out_data = new JSONObject();
        try {
            UserInfoEntity userInfoEntity = mapper.selectByAccount(entity.getAccount());
            if (userInfoEntity != null && entity.getPassword().equals(userInfoEntity.getPassword())) {
                out_data.put("ID", userInfoEntity.getId());
                out_data.put("Account", userInfoEntity.getAccount());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return out_data;
    }

}

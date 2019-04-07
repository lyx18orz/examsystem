package com.lyx.examsystem.service;

import com.alibaba.fastjson.JSONObject;
import com.lyx.examsystem.entity.UserInfoEntity;

public interface UserInfoService {
     boolean save(UserInfoEntity entity);

     UserInfoEntity selectByID(Integer id);

     boolean updateByID(UserInfoEntity entity);

     boolean deleteByID(Integer id);

     JSONObject loginCheck(UserInfoEntity entity);

}

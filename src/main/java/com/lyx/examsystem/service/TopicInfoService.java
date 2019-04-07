package com.lyx.examsystem.service;

import com.alibaba.fastjson.JSONObject;
import com.lyx.base.page.Page;
import com.lyx.examsystem.entity.TopicInfoEntity;

import javax.servlet.http.HttpServletRequest;

public interface TopicInfoService {
     boolean save(TopicInfoEntity entity);
     JSONObject selectByID(Integer id);
     boolean updateByID(TopicInfoEntity entity);
     boolean deleteByID(Integer id);
     JSONObject selectPageByContent(Page page);
     boolean deleteByIds(String ids);
     JSONObject selectListByRandom(HttpServletRequest request);

}

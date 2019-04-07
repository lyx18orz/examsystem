package com.lyx.examsystem.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lyx.base.page.Page;
import com.lyx.examsystem.dao.TopicInfoEntityMapper;
import com.lyx.examsystem.entity.TopicInfoEntity;
import com.lyx.examsystem.service.TopicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TopicInfoServiceImpl implements TopicInfoService {
    @Autowired
    private TopicInfoEntityMapper mapper;


    @Override
    public boolean save(TopicInfoEntity entity) {
        HttpServletRequest request;
        try {
            int i = mapper.insert(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public JSONObject selectByID(Integer id) {
        SimpleDateFormat iddate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TopicInfoEntity entity;
        JSONObject out_data = new JSONObject();
        try {
            entity = mapper.selectByPrimaryKey(id);
            JSONObject json_data = new JSONObject();
            json_data.put("ID", entity.getId());

            if (entity.getType() == null) {
                json_data.put("Type", "");
            } else {
                json_data.put("Type", entity.getType());
            }
            if (entity.getTitle() == null) {
                json_data.put("Title", "");
            } else {
                json_data.put("Title", entity.getTitle());

            }
            if (entity.getOptiona() == null) {
                json_data.put("OptionA", "");
            } else {
                json_data.put("OptionA", entity.getOptiona());

            }
            if (entity.getOptionb() == null) {
                json_data.put("OptionB", "");
            } else {
                json_data.put("OptionB", entity.getOptionb());

            }
            if (entity.getOptionc() == null) {
                json_data.put("OptionC", "");
            } else {
                json_data.put("OptionC", entity.getOptionc());

            }
            if (entity.getOptiond() == null) {
                json_data.put("OptionD", "");
            } else {
                json_data.put("OptionD", entity.getOptiond());

            }
            if (entity.getOptione() == null) {
                json_data.put("OptionE", "");
            } else {
                json_data.put("OptionE", entity.getOptione());

            }
            if (entity.getOptionf() == null) {
                json_data.put("OptionF", "");
            } else {
                json_data.put("OptionF", entity.getOptionf());

            }
            if (entity.getResult() == null) {
                json_data.put("Result", "");
            } else {
                json_data.put("Result", entity.getResult());

            }
            if (entity.getComplexity() == null) {
                json_data.put("Complexity", "");
            } else {
                json_data.put("Complexity", entity.getComplexity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out_data;
    }

    @Override
    public boolean updateByID(TopicInfoEntity entity) {
        try {
            int i = mapper.updateByPrimaryKey(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteByID(Integer id) {
        try {
            int i = mapper.deleteByPrimaryKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public JSONObject selectPageByContent(Page page) {
        SimpleDateFormat iddate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject out_data = new JSONObject();
        JSONArray jsonArray_data = new JSONArray();
        page.setTotalPages(mapper.selectCountByContent(page.getContent()));
        page.setTotalRows((page.getTotalPages() + page.getPageSize() - 1) / page.getPageSize());
        List<TopicInfoEntity> entityList = mapper.selectPageByContent(page);
        for (TopicInfoEntity entity : entityList) {
            JSONObject json_data = new JSONObject();
            json_data.put("ID", entity.getId());
            if (entity.getType() == null) {
                json_data.put("Type", "");
            } else {
                json_data.put("Type", entity.getType());
            }
            if (entity.getTitle() == null) {
                json_data.put("Title", "");
            } else {
                json_data.put("Title", entity.getTitle());

            }
            if (entity.getOptiona() == null) {
                json_data.put("OptionA", "");
            } else {
                json_data.put("OptionA", entity.getOptiona());

            }
            if (entity.getOptionb() == null) {
                json_data.put("OptionB", "");
            } else {
                json_data.put("OptionB", entity.getOptionb());

            }
            if (entity.getOptionc() == null) {
                json_data.put("OptionC", "");
            } else {
                json_data.put("OptionC", entity.getOptionc());

            }
            if (entity.getOptiond() == null) {
                json_data.put("OptionD", "");
            } else {
                json_data.put("OptionD", entity.getOptiond());

            }
            if (entity.getOptione() == null) {
                json_data.put("OptionE", "");
            } else {
                json_data.put("OptionE", entity.getOptione());

            }
            if (entity.getOptionf() == null) {
                json_data.put("OptionF", "");
            } else {
                json_data.put("OptionF", entity.getOptionf());

            }
            if (entity.getResult() == null) {
                json_data.put("Result", "");
            } else {
                json_data.put("Result", entity.getResult());

            }
            if (entity.getComplexity() == null) {
                json_data.put("Complexity", "");
            } else {
                json_data.put("Complexity", entity.getComplexity());
            }
            jsonArray_data.add(json_data);
        }
        page.setTotalPages(mapper.selectCountByContent(page.getContent()));
        page.setTotalRows((page.getTotalPages() + page.getPageSize() - 1) / page.getPageSize());
        out_data.put("TopicInfo", jsonArray_data);
        out_data.put("TotalRows", page.getTotalRows());
        out_data.put("TotalPages", page.getTotalPages());

        return out_data;
    }

    @Override
    public boolean deleteByIds(String ids) {
        try {
            int i = mapper.deleteByIds(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public JSONObject selectListByRandom(HttpServletRequest request) {
        HttpSession session = request.getSession();
        JSONObject out_data = new JSONObject();
        JSONArray jsonArray_data = new JSONArray();
        JSONArray sessionJsonArray = new JSONArray();
        List<TopicInfoEntity> entityList = mapper.selectListByRandom();

        for (TopicInfoEntity entity : entityList) {
            JSONObject json_data = new JSONObject();
            JSONObject sessionJson = new JSONObject();
            json_data.put("ID", entity.getId());
            sessionJson.put("ID",entity.getId());
            sessionJson.put("Result",entity.getResult());
            if (entity.getType() == null) {
                json_data.put("Type", "");
            } else {
                json_data.put("Type", entity.getType());
            }
            if (entity.getTitle() == null) {
                json_data.put("Title", "");
            } else {
                json_data.put("Title", entity.getTitle());

            }
            if (entity.getOptiona() == null) {
                json_data.put("OptionA", "");
            } else {
                json_data.put("OptionA", entity.getOptiona());

            }
            if (entity.getOptionb() == null) {
                json_data.put("OptionB", "");
            } else {
                json_data.put("OptionB", entity.getOptionb());

            }
            if (entity.getOptionc() == null) {
                json_data.put("OptionC", "");
            } else {
                json_data.put("OptionC", entity.getOptionc());

            }
            if (entity.getOptiond() == null) {
                json_data.put("OptionD", "");
            } else {
                json_data.put("OptionD", entity.getOptiond());

            }
            if (entity.getOptione() == null) {
                json_data.put("OptionE", "");
            } else {
                json_data.put("OptionE", entity.getOptione());

            }
            if (entity.getOptionf() == null) {
                json_data.put("OptionF", "");
            } else {
                json_data.put("OptionF", entity.getOptionf());

            }
            if (entity.getResult() == null) {
                json_data.put("Result", "");
            } else {
                json_data.put("Result", entity.getResult());

            }
            if (entity.getComplexity() == null) {
                json_data.put("Complexity", "");
            } else {
                json_data.put("Complexity", entity.getComplexity());
            }
            sessionJsonArray.add(sessionJson);
            jsonArray_data.add(json_data);
        }
        session.setAttribute("entitySession",sessionJsonArray);
        out_data.put("TopicInfo", jsonArray_data);
        return out_data;
    }


}

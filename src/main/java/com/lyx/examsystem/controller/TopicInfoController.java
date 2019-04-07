package com.lyx.examsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyx.base.Create.MyCreate;
import com.lyx.base.File.MyFile;
import com.lyx.base.page.Page;
import com.lyx.base.result.ResultConstants;
import com.lyx.base.result.ResultData;
import com.lyx.examsystem.service.TopicInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.commons.lang.StringUtils.isBlank;

@Controller
@RequestMapping("clientTopic")
public class TopicInfoController {
    //   code;//ReturnCode0：指令执行成功1：指令格式有误2：服务端请求其他链接出错（如极光服务）3：校验失败4：Token过期5：指令不存在9：其他错误
// 日志打印
    private static Logger logger = Logger.getLogger(TopicInfoController.class);

    @Autowired
    private TopicInfoService topicInfoService;
    @Autowired
    private MyFile myFile;
    @Autowired
    private MyCreate myCreate;


    /**
     * 1显示所有分页查询结果
     */
    @RequestMapping(value = "/getTopicInfoList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String TopicInfoList(HttpServletRequest request, HttpServletResponse response) {

        System.out.print("ExamSystem.clientTopic.List Start!");
        ResultData resultData = new ResultData();
        JSONObject out_data;
        resultData.setCode(ResultConstants.ERROR);
            try {
                out_data = topicInfoService.selectListByRandom(request);
                System.out.println(request.getSession().getAttribute("entitySession"));
                if (out_data == null) {
                    resultData.setMsg("ERROR!");
                } else {
                    resultData.setData(out_data);
                    resultData.setCode(ResultConstants.SUCCESS);
                }
            } catch (Exception e) {
                resultData.setCode(ResultConstants.BAD_REQUEST);
                resultData.setMsg("Bad Request!");
                e.printStackTrace();
            }
        return JSON.toJSONString(resultData);
    }
    @RequestMapping(value = "/getExamResults", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String List(HttpServletRequest request, HttpServletResponse response) {

        System.out.print("ExamSystem.clientTopic.List Start!");
        ResultData resultData = new ResultData();
        JSONObject out_data;
        resultData.setCode(ResultConstants.ERROR);
        try {
            out_data = topicInfoService.selectListByRandom(request);
            System.out.println(request.getSession().getAttribute("entitySession"));
            if (out_data == null) {
                resultData.setMsg("ERROR!");
            } else {
                resultData.setData(out_data);
                resultData.setCode(ResultConstants.SUCCESS);
            }
        } catch (Exception e) {
            resultData.setCode(ResultConstants.BAD_REQUEST);
            resultData.setMsg("Bad Request!");
            e.printStackTrace();
        }
        return JSON.toJSONString(resultData);
    }
}
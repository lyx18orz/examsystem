package com.lyx.examsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lyx.base.result.ResultConstants;
import com.lyx.base.result.ResultData;
import com.lyx.examsystem.entity.UserInfoEntity;
import com.lyx.examsystem.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.apache.commons.lang.StringUtils.isBlank;


@Controller
@RequestMapping("login")
public class LoginController {
    //   code;//ReturnCode0：指令执行成功1：指令格式有误2：服务端请求其他链接出错（如极光服务）3：校验失败4：Token过期5：指令不存在9：其他错误
// 日志打印
    private static Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    UserInfoService userInfoService;

    /**
     * //     * @param Account
     * //     * @param Password
     * 验证登录
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public String Check(HttpServletRequest request, HttpServletResponse response) {
        logger.info("WollarTicketUser.Login.Check Start!");
        UserInfoEntity entity = new UserInfoEntity();
        JSONObject out_data;
        ResultData resultData = new ResultData();
        resultData.setCode(ResultConstants.ERROR);
        if (isBlank(request.getParameter("Account"))) {
            resultData.setMsg("Account missing!");
        } else if (isBlank(request.getParameter("Password"))) {
            resultData.setMsg("Password missing!");
        } else {
            try {
                entity.setAccount(request.getParameter("Account"));
                entity.setPassword(request.getParameter("Password"));
                out_data = userInfoService.loginCheck(entity);
                if (out_data==null){
                    resultData.setMsg("Incorrect account or password!");
                }else {
                    resultData.setData(out_data);
                    HttpSession session = request.getSession();
                    Map<String, String> loginmap = new HashMap();
                    loginmap.put(session.getId(), entity.getAccount());
                    request.getSession().setAttribute("LoginMap", loginmap);
                    resultData.setCode(ResultConstants.SUCCESS);
                }
            } catch (Exception e) {
                resultData.setCode(ResultConstants.BAD_REQUEST);
                resultData.setMsg("Bad Request!");
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(resultData);
    }
    
    /**
     * return
     * throws Exception
     */
    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    @ResponseBody
    public void Exit(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            //清除登陆页面缓存
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
            response.sendRedirect(request.getContextPath());//返回项目根目录
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
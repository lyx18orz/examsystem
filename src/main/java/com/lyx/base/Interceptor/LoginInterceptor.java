package com.lyx.base.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        System.out.println("SecurityInterceptor...preHandle...");
        //这里可以根据session的用户来判断角色的权限，根据权限来转发不同的页面
        HttpSession session=request.getSession();
        Map<String, String> loginMap = (Map<String, String>)session.getAttribute("LoginMap");
        if(loginMap==null){
            loginMap = new HashMap<>();
        }
//        System.out.println(loginMap.toString());
        for(String key:loginMap.keySet()) {
            //验证当前用户的sessionId是否相同
            if (session.getId().equals(key)) {

//                        System.out.println(Account+"在同一地点多次登录！");
                    return true;
            }
        }
//        response.getWriter().print("需要重新登录");
        response.sendRedirect(request.getContextPath());
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }
}

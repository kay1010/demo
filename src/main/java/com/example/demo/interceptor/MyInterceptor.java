package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 自定义拦截器
 *
 * @author FKK
 * @date 2019/09/20
 */
public class MyInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("-------MyInterceptor preHandle run-------");
        HttpSession session= request.getSession();
       if(session.getAttribute("id")!=null){
           return true;
       }
        logger.info("-------MyInterceptor preHandle:用户未登录");
       response.sendError(403);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("-------MyInterceptor postHandle run-------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("-------MyInterceptor afterCompletion run-------");
    }
}

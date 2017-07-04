package com.faype.security.core.interceptor;


import com.faype.security.core.exception.DomainNotFoundException;
import com.faype.security.core.global.ThreadScope;
import com.faype.security.domain.Token;
import com.faype.security.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wmfsystem
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
        if (hsr.getRequestURI().contains("/public")) {
            return true;
        }

        String requestToken = hsr.getHeader("faypeToken") != null ? hsr.getHeader("faypeToken") : hsr.getParameter("faypeToken");

        if (requestToken != null) {
            Token token = tokenService.findOne(requestToken);
            ThreadScope.token.set(token);
            if (token != null) {
                return true;
            }
        }

        throw new DomainNotFoundException("Operation not allowed! Especify the Token and operation!");
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {

    }
}

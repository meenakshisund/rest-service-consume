package com.webservice.call.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogginInterceptor implements HandlerInterceptor {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        createMDC(request, handler);
        LOGGER.info("Incoming Request");
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        LOGGER.info("Request Completed");
        MDC.clear();
    }

    private void createMDC(HttpServletRequest request, Object handler) {
        MDC.put("requestId", request.getHeader("X-Request-ID"));
    }
}

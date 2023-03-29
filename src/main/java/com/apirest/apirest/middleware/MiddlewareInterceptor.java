package com.apirest.apirest.middleware;
import com.apirest.apirest.models.User;
import com.apirest.apirest.utils.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Component
public class MiddlewareInterceptor implements HandlerInterceptor {
    @Autowired
    JWTUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String url = request.getRequestURI();
       if(url.isEmpty()) return false;
       String token = request.getHeader("Authorization");

        if (url.equals("/api/users/all")) {
            if(authorization(jwtUtil, token)) {
                response.setStatus(401);
                return false;
            };
        }

        if (url.startsWith("/api/users/id")) {
          if(authorization(jwtUtil, token)) {
              response.setStatus(401);
              return false;
          };

        }

        if (url.startsWith("/api/users/delete")) {
            if(authorization(jwtUtil, token)) {
                response.setStatus(401);
                return false;
            };
        }

        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    private static boolean  authorization (JWTUtil jwtUtil , String token){
        if(token == null || token.equals("undefined")) return true;
        try {
            String idJWT = jwtUtil.getKey( token);
            if(idJWT == null) return true;
        }catch (Exception e){return true;}
        return false;
    }


}
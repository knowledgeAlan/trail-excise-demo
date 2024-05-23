package com.zcd.config.idemptotent;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class IdempotentFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getParameter("token");


        HttpSession httpSession = request.getSession(false);

        Object value = httpSession.getAttribute(token);

        if(value != null){
            throw new ServletException("幂等性校验");
        }

        httpSession.setAttribute(token,token);

        try{
            filterChain.doFilter(request,response);
        }finally {
            httpSession.removeAttribute(token);
        }
    }
}

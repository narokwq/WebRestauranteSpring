package com.br.interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{ 

   @Override 
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{

       HttpSession session = request.getSession();
       String uri = request.getRequestURI(); 
       System.out.println(uri);
       if(uri.endsWith("login") || uri.endsWith("logar")){ 
           return true; 
       } 
       if(session.getAttribute("user") != null) {  
         return true; 
       } 
       response.sendRedirect("/WebRestauranteSpring/login"); 
       return false; 
   } 
}
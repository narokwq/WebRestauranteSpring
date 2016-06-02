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
       String contextPath = request.getContextPath();
       System.out.println(uri);
       if(uri.endsWith("login") || uri.endsWith("logar") || uri.endsWith("cliente/form") || uri.endsWith("cliente/save")){ 
           return true; 
       } 
       if(session.getAttribute("usuario") != null) {  
         return true; 
       } 
       response.sendRedirect(contextPath+"/login"); 
       return false; 
   } 
}
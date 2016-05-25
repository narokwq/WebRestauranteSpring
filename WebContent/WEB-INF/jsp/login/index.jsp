<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tela Login</title>
    <link rel="stylesheet" type="text/css" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/bootstrap4.css">
</head>
<body>
	 <div id="login-box">
        <div id="login-box-interno">
            <div id="login-box-interno-label">
                    <span>Controle de Restaurante</span>
            </div>
            <c:url var="url" value="/logar" />
            <form:form method="post" action="${url}" modelAttribute="user" class="form-horizontal">
				  <div class="form-group">
				    <label class="col-sm-2 control-label">Login</label>
				    <div class="col-sm-9">
				    <form:input path="login" class="form-control" name="tLogin" placeholder="Login" required="required"/>
				    </div>
				  </div>
				  <div class="form-group" >
				    <label  class="col-sm-2 control-label" style="margin-top: 15px;">Senha</label>
				    <div class="col-sm-9">
				    <form:password path="senha" style="margin-top: 15px;" class="form-control" name="tSenha" placeholder="Senha" required="required"/>
				    </div>
				  </div>
				  <div>
				  
				  </div>
				 
				  <div class="form-group" >
				    <div class="col-sm-offset-2 col-sm-10" style="margin-top: 30px;">
				    	<a class="btn btn-info" href="cadastroCliente" role="button" >Cadastra-se</a>
				      	<button type="submit" class="btn btn-info" style="margin-left: 126px;">Acessar</button>
				      
				    </div>
				  </div>
			</form:form>
			
        </div>
        
    </div>
		
</body>
</html>
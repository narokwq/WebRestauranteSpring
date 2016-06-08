<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cowboy Restaurante</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap4.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/mycss.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/cadastrocliente.css" />">

	<script  type="text/javascript" src="<c:url value="/resources/js/mascaras.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.2.4.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
    
    <script type="text/javascript">
        $(window).scroll(function(){
            if ($(window).scrollTop() >= 80)
            {
                $("#topofixo").css({position:'fixed',left:'0',top:'0'});
            }
            else
            {
                $("#topofixo").css({position:'absolute',left:'0',top:'80px'});
            }
        });
    </script>

</head>
<body>
<header>
    <c:if test="${home == 'cliente'}">
	<%@ include file="navcliente.jsp" %>
	</c:if>
	<c:if test="${home == 'funcionario'}">
	<%@ include file="navfuncionario.jsp" %>
	</c:if>
	<c:if test="${home == 'gerente'}">
	<%@ include file="navgerente.jsp" %>
	</c:if>
	<c:if test="${usuario == null}">
    <div id="topo">
        <span>Restaurante</span>
    </div >
    <div id="topofixo" style="height:50px">
    </div>
    </c:if>
</header>
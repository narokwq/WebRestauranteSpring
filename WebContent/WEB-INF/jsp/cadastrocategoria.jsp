<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="header.jsp" %>
    <section>
        <div class="centrodiv">
        	<c:url var="url" value="/categoria/save" />
            <form:form action="${url}" method="post" modelAttribute="categoria">
            	<form:hidden path="id" />
                <div class="form-group row">
                    <label for="inputNome" class="col-sm-2 form-control-label">Nome</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" id="inputNome" placeholder="Nome" name="nome" required="required" path="nome" />
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">Status</label>
                    <div class="col-sm-4">
                        <form:select  path="status" class="form-control">
                        	<form:options items="${statusItens}" />
                        </form:select>
                    </div>
                    
                </div>
                <div class="form-group row">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-secondary">Cadastrar</button>
                    </div>
                </div>
           </form:form>
        </div>
    </section>

<%@ include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
</body>
</body>
</html>
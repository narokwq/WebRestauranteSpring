<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="header.jsp" %>
    <section>
        <div class="centrodiv">
        	<c:url var="url" value="/cargo/save" />
            <form:form action="${url}" method="post" modelAttribute="cargo">
            	<form:hidden path="id" />
                <div class="form-group row">
                    <label  class="col-sm-2 form-control-label">Descrição</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" id="inputNome" placeholder="Descrição" required="required" path="descricao" />
                    </div>   
                    <label  class="col-sm-2 form-control-label">Status</label>
                    <div class="col-sm-4">
                        <form:select  path="desativado" class="form-control">
                        	<form:options items="${statusDesativado}" />
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
</body>
</body>
</html>
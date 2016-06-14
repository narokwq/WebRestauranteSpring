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
        <c:url var="url" value="/reserva/save"></c:url>
            <form:form action="${url}" method="post" modelAttribute="reserva">
            	<form:hidden path='id'/>
                <div class="form-group row">
                    <label for="inputDateInicio" class="col-sm-2 form-control-label">Data Inicio</label>
                    <div class="col-sm-4">
                       <form:input type="datetime-local" path="dataInicio" class="form-control" id="inputDateInicio"  required='required' /> 
                       <form:errors path="dataInicio" class="erros"></form:errors> 
                    </div>
                    <label for="inputDateFim" class="col-sm-2 form-control-label">Data Fim</label>
                    <div class="col-sm-4">
                        <form:input type="datetime-local" class="form-control" id="inputDateFim" path="dataFim" required="required" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPreco" class="col-sm-2 form-control-label">Responsavel</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" id="inputResponsavel" placeholder="Nome Responsavel" path="nomeResp" required="required" />
                        <form:errors path="nomeResp" class="erros"></form:errors> 
                    </div>
                    <label for="inputMesa" class="col-sm-2 form-control-label">Mesa</label>
                    <div class="col-sm-4">
                        <form:select class="form-control" id="inputMesa" path="mesa.id" >
                            <form:options items="${mesaOpcao}" />
                        </form:select>
                        <form:errors></form:errors>
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
</html>
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
        <c:url var="url" value="/mesa/save"></c:url>
            <form:form action="${url}" method="post" modelAttribute="mesa">
            	<form:hidden path='id'/>
                <div class="form-group row">
                    <label for="inputNumero" class="col-sm-2 form-control-label">Numero</label>
                    <div class="col-sm-4">
                        <form:input type="number" class="form-control" id="inputNumero" placeholder="000" path="numero" required="required" />
                    </div>
                    <label for="inputDescricao" class="col-sm-2 form-control-label">Descricao</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" id="inputDescricao" placeholder="Mesa" path="descricao" required="required" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPreco" class="col-sm-2 form-control-label">Capacidade</label>
                    <div class="col-sm-4">
                        <form:input type="number" min="0" class="form-control" id="inputPreco" placeholder="00" path="capacidade" required="required" />
                    </div>
                    <label for="inputCategoria" class="col-sm-2 form-control-label">De reserva?</label>
                    <div class="col-sm-4">
                        <form:select class="form-control" id="inputCategoria" path="perReserva" >
                            <form:options items="${reservaOpcao}" />
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
</html>
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
		<c:url var="url" value="/cardapio/filtrar"/>
		<form:form action="${url}" modelAttribute="filtro" method="get">
				<div class="form-group row">

						<label for="inputNome" class="col-sm-1 form-control-label">Nome</label>
	                    <div class="col-sm-3">
	                        <form:input class="form-control" id="inputNome" path="nome" />
	                    </div>
	                    <label for="inputCategoria" class="col-sm-2 form-control-label">Categoria</label>
	                   	<div class="col-sm-3" >
	                         <form:select id="inputReserva" class="form-control" path="categoria.id" >
	                         	<form:option value="0">Todos</form:option>
                            	<form:options items="${categoriaItens}" />
                            </form:select>	
	                    </div>
	                    <div class="col-sm-offset-0 col-sm-2" >
	                        <button style="float:right;" type="submit" class="btn btn-secondary">Pesquisar</button>
	                    </div>
	              
				</div>
			</form:form>
	 		<table class="table table-sm">
	            <thead>
	            <tr>
	                <th>Codigo</th>
	                <th>Descrição</th>
	                <th>Preço</th>
	                <th>Status</th>
	                <th>Categoria</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>
	            
				<c:forEach var="cardapio" items="${cardapios}" >
	            <tr>
	                <th scope="row">${cardapio.id}</th>
	                <td>${cardapio.nome}</td>
	                <td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${cardapio.preco}"/></td>
	                <td>
	                	<c:if test="${cardapio.status == true}">Ativo</c:if>
	                	<c:if test="${cardapio.status == false}">Inativo</c:if>
	                </td>
					<td>${cardapio.categoria.nome}</td>
					<td>
						<a href="<c:url value="/cardapio/${cardapio.id}/form" />"><img src="<c:url value="/resources/image/edit.png" />" class="icon-tb"></a> 
						<a href="<c:url value="/cardapio/${cardapio.id}/remove" />"><img src="<c:url value="/resources/image/switch.png" />" class="icon-tb"></a>
					</td>
	
	            </tr>
	           	</c:forEach>
	            </tbody>
	        </table>
   	
	     </div>
	     <form	 style="width: 800px;position: relative;margin:0 auto;padding: 1.5rem;">
                <div class="form-group row" style="margin-top: 30px;">
                  	<div class="col-sm-offset-6 col-sm-5" >
                        <a href="javascript:history.back();" style="float:right;" class="btn btn-secondary">Voltar</a>
                    </div>   
                </div>
            </form>
	     	<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}.
				</div>
			</c:if>
	</section>
	
<%@ include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
</body>
</html>
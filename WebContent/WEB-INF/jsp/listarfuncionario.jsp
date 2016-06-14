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
			<c:url var="url" value="/funcionario/filtrar"/>
			<form:form action="${url}" modelAttribute="filtro" method="get">
				<div class="form-group row">
				
						<label for="inputNome" class="col-sm-1 form-control-label">Nome</label>
	                    <div class="col-sm-4 col-sm-offset-0">
	                        <form:input path="nome" class="form-control" placeholder="Nome do funcionario" />
	                    </div>
	                    <div class="col-sm-offset-0 col-sm-6" >
	                        <button style="float:right;" type="submit" class="btn btn-secondary">Pesquisar</button>
	                    </div>
				</div>
			</form:form>
			<div class="form-group row">
	 		<table class="table table-sm">
	            <thead>
		            <tr>
		                <th>Nome</th>
		                <th>CPF</th>
		                <th>Cargo</th>
		                <th>Salário</th>
		                <th>Açoes</th>
		            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="funcionario" items="${funcionarios}">
	            <tr>
	                <th scope="row">${funcionario.nome}</th>
	                <td>${funcionario.cpf}</td>
					<td>${funcionario.cargo.descricao}</td>
					<td>${funcionario.salario}</td>
					<td>
						<a href="<c:url value="/funcionario/${funcionario.id}/form" />" title="alterar"><img src="<c:url value="/resources/image/edit.png" />" class="icon-tb"></a>
					</td>
					
	            </tr>
	            </c:forEach>
	            </tbody>
	        </table>
	        
	        
		</div>
	     
	     	
	     </div>
	     	<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}.
				</div>
			</c:if>	
	</section>
<%@ include file="footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<%@ include file="header.jsp" %>
	<section>
		<div class="centrodiv1">
			<c:url var="url" value="/pedido/filtrar" />
			<form:form action="${url}" modelAttribute="filtro" method="get">
				<div class="form-group row">
				
						<label for="inputNumero" class="col-sm-2 form-control-label">Numero do Pedido</label>
	                    <div class="col-sm-1">
	                        <form:input type="number" class="form-control" id="inputNumero" placeholder="000" path="id" />
	                    </div>
	                    <label for="inputStatus" class="col-sm-1 form-control-label">Tipo</label>
	                   	<div class="col-sm-2" >
	                         <form:select id="inputStatus"  path="tipo" class="form-control" >
	                         			<option  value="Todos" selected="selected" >Todos</option>
			                        	<option  value="Delivery" >Delivery</option>
			                        	<option  value="Tradicional" >Tradicional</option>
	                    	 </form:select>
	                    </div>
	                    <label for="inputStatus" class="col-sm-1 form-control-label">Status</label>
	                   	<div class="col-sm-2" >
	                         <form:select id="inputStatus"  path="status" class="form-control" >
	                         			<option  value="Todos" selected="selected" >Todos</option>
			                        	<option  value="Pendente" >Pendente</option>
			                        	<option  value="Atendido" >Atendido</option>
			                        	<option  value="Cancelado" >Cancelado</option>
	                    	 </form:select>
	                    </div>
	                    <div class="col-sm-offset-0 col-sm-2" >
	                        <button style="float:right;" type="submit" class="btn btn-secondary">Pesquisar</button>
	                    </div>
				</div>
			</form:form>
			<div class="form-group row">
	 		<table class="table table-sm">
	            <thead>
	            <tr>
	                <th>Numero</th>
	                <th>Data</th>
	                <th>Total</th>
	                <th>Status</th>
	                <th>Cliente</th>
	                <th>Atendido Por</th>
	                <th>Tipo</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="pedidos" items="${pedidos}">
	            <tr>
	                <th scope="row">${pedidos.id}</th>
	                <td><fmt:formatDate type="date" value="${pedidos.data}" /></td>
					<td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${pedidos.total}" /></td>
					<td>${pedidos.status}</td>
					
					<td>
						<c:if test="${empty pedidos.funcionario}">
							<c:if test="${pedidos['class'].simpleName == 'Delivery'}">
								<c:catch var="e">
									<c:out value="${pedidos.cliente.nome}"></c:out>
								</c:catch>
							</c:if>
							<c:if test="${pedidos['class'].simpleName == 'Tradicional'}">
								<c:catch var="e">
									<c:out value="${pedidos.mesa.descricao}"></c:out>
								</c:catch>
							</c:if>
							
						</c:if>
						<c:if test="${!empty pedidos.funcionario}">
							<c:catch var="e">
								<c:out value="${pedidos.funcionario.nome}"></c:out>
							</c:catch>
						</c:if>
					</td>					
					<td>${pedidos.funcionario.nome}</td>
					<td>
						<c:out value="${pedidos['class'].simpleName}" />
						<%-- <c:if test="${empty pedidos.funcionario}">
							<c:out value="Delivery"></c:out>
						</c:if>
						<c:if test="${!empty pedidos.funcionario}">
							<c:out value="Tradicional"></c:out>
						</c:if> --%>
					</td>
					<td>
						<a href="<c:url value="/pedido/${pedidos.id}/detalhar" />" title="detalhar"><img src="<c:url value="/resources/image/detalhe.png" />" class="icon-tb"></a> 
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
<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
</body>
</html>
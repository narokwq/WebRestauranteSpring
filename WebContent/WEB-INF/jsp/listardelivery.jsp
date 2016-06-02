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
			<c:url var="url" value="/delivery/filtrar" />
			<form:form action="${url}" modelAttribute="filtro" method="get" >
				<div class="form-group row">
				
						<label for="inputNumero" class="col-sm-3 form-control-label">Numero do Pedido</label>
	                    <div class="col-sm-2">
	                        <form:input type="number" class="form-control" id="inputNumero" placeholder="000" path="id" />
	                    </div>
	                    <label for="inputStatus" class="col-sm-1 form-control-label">Status</label>
	                   	<div class="col-sm-3" >
	                         <form:select path="status" id="inputStatus" class="form-control" >
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
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>

				<c:forEach var="delivery" items="${deliverys}">
	            <tr>
	                <th scope="row">${delivery.id}</th>
	                <td><fmt:formatDate type="date" value="${delivery.data}" /></td>
					<td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${delivery.total}" /></td>
					<td>${delivery.status}</td>
					<td>
						<a href="<c:url value="/delivery/${delivery.id}/detalhado" />" title="Detalhar Pedido"><img src="<c:url value="/resources/image/detalhe.png" />" class="icon-tb"></a> 
						<c:if test="${delivery.status == \"Pendente\"}"><a href="<c:url value="/delivery/${delivery.id}/cancelar" />" title="Cancelar Pedido"><img src="<c:url value="/resources/image/delete.png" />" class="icon-tb"></a> </c:if>
					</td>
	
	            </tr>
	            </c:forEach>
	            </tbody>
	        </table>       
	        
		</div>
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
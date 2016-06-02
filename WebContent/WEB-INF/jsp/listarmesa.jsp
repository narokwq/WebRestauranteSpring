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
		<c:url var="url" value="/mesa/filtrar"/>
		<form:form action="${url}" modelAttribute="filtro" method="get">
				<div class="form-group row">

						<label for="inputNome" class="col-sm-1 form-control-label">Nome</label>
	                    <div class="col-sm-3">
	                        <form:input type="text" class="form-control" id="inputNome" path="descricao" />
	                    </div>
	                    <label for="inputReserva" class="col-sm-2 form-control-label">De reserva?</label>
	                   	<div class="col-sm-3" >
	                         <form:select id="inputReserva"  path="perReserva" class="form-control" >
	                         			<form:option value="">Todos</form:option>
			                        	<form:options items="${reservaOpcao}" />		                        
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
	                <th>Numero</th>
	                <th>Descrição</th>
	                <th>Capacidade</th>
	                <th>Resevavel</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>
	            
				<c:forEach var="mesa" items="${mesas}" >
	            <tr>
	                <th scope="row">${mesa.numero}</th>
	                <td>${mesa.descricao}</td>
	                <td>${mesa.capacidade}</td>
	             	
					<td>
					<c:if test="${mesa.perReserva eq true}">
							Sim
					</c:if>
					<c:if test="${mesa.perReserva eq false}">
							Não
					</c:if>
					</td>
					<td>
						<a href="<c:url value="/mesa/${mesa.id}/form" />"><img src="<c:url value="../resources/image/edit.png" />" class="icon-tb"></a> 
						<a href="/mesa/${mesa.id}/form"><img src="<c:url value="../resources/image/delete.png" />" class="icon-tb"></a>
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
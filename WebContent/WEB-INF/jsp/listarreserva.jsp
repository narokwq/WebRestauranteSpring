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
		<c:url var="url" value="/reserva/filtrar"/>
		<form:form action="${url}" modelAttribute="filtro" method="get">
				<div class="form-group row">

						<label for="inputDateInicio" class="col-sm-2 form-control-label">Data Inicio</label>
	                    <div class="col-sm-4">
	                        <form:input type="datetime-local" style="padding-top: 2px; padding-bottom: 2px;" path="dataInicio" class="form-control" id="inputDateInicio"/> 
	                    </div>
	                    <label for="inputDateFim" class="col-sm-2 form-control-label">Data Fim</label>
	                    <div class="col-sm-4">
	                        <form:input type="datetime-local" style="padding-top: 2px; padding-bottom: 2px;" class="form-control" id="inputDateFim" path="dataFim"/>
	                    </div>
	                   	
	                    
	              
				</div>
				<div class="form-group row">
					<label for="inputResponsavel" class="col-sm-2 form-control-label">Responsavel</label>
	                <div class="col-sm-4">
	                	<form:input path="nomeResp" class="form-control" id="inputResponsavel"/> 
	                </div>
	                <label for="inputMesa" class="col-sm-1  form-control-label">Mesa</label>
	                    <div class="col-sm-3">
	                        <form:select class="form-control" id="inputMesa" path="mesa.id" >
	                        	<form:option value="0">Todos</form:option>
	                            <form:options items="${mesaOpcao}" />
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
	                <th>Data Início</th>
	                <th>Data Fim</th>
	                <th>Mesa</th>
	                <th>Responsavel</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            <tbody>
	            
				<c:forEach var="reserva" items="${reservas}" >
	            <tr>
	                <th><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${reserva.dataInicio}"/></th>
	                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${reserva.dataFim}"/></td>
	                <td>${reserva.mesa.descricao}</td>
					<td>${reserva.nomeResp}</td>
					<td> 
						<a href="/mesa/${mesa.id}/remove"><img src="<c:url value="../resources/image/delete.png" />" class="icon-tb"></a>
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
</body>
</html>
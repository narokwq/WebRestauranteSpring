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
			<c:url var="url" value="/cargo/filtrar" />
			<form:form action="${url}" modelAttribute="filtro" method="GET">
				<div class="form-group row">

						<label class="col-sm-1 form-control-label">Descrição</label>
	                    <div class="col-sm-3 col-sm-offset-1">
	                        <form:input path="descricao" class="form-control" />
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
	                <th>Status</th>
	                <th></th>
	            </tr>
	            </thead>
	            <tbody>
	            
				<c:forEach var="cargos" items="${cargos}" >
	            <tr>
	                <th scope="row">${cargos.id}</th>
	                <td>${cargos.descricao}</td>	             	
					<td>
					<c:if test="${cargos.desativado eq true}">
							Ativo
					</c:if>
					<c:if test="${cargos.desativado eq false}">
							Desativado
					</c:if>
					</td>
					<td>				
						<a href='<c:url value="/cargo/${cargos.id}/form" />'><img src="<c:url value="/resources/image/switch.png" />" class="icon-tb"></a> 
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
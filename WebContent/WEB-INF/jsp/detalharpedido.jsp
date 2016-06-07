<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="header.jsp" %>
    <section>
        <div class="centrodiv">
        	<div class="form-group row negrito">
        		 <div class="col-sm-3">Numero: <c:out value="${pedido.id}"/></div>
        		 <div class="col-sm-3">Status: <c:out value="${pedido.status}"/></div>
        		 <div class="col-sm-3">Tipo: <c:out value="${pedido['class'].simpleName}"/></div>
        		 <div class="col-sm-3">Troco para: <c:catch var="e"><c:out value="${pedido.troco}"/></c:catch></div>
        	</div>
            <table class="table table-sm">
	            <thead>
	            <tr>	            
	                <th>Codigo</th>
	                <th>Descrição</th>
	                <th>Quantidade</th>	  
	                <th>Total</th>	             
	            </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="item" items="${pedido.itensCardapio}">
	            	<tr>
	            		<td>${item.cardapio.id}</td>
		            	<td>${item.cardapio.nome}</td>
		            	<td>${item.qtd}</td>
		            	<td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${item.qtd*item.cardapio.preco}"/></td>		                             
		            </tr>
		            </c:forEach>
		            
	            </tbody>
	        </table>               	
               
                <div class="form-group row" style="margin-top: 30px;">
	                <div class=" col-sm-2" >
	                	<a href="" style="margin:auto;" class="btn btn-secondary">Em Espera</a>
	                </div> 
	                <div class="col-sm-2" >
	                	<a href="" style="margin-left:8px;" class="btn btn-secondary">Atendido</a>
	                </div> 
	                <div class="col-sm-2" >
	                	<a href="" style="margin:auto;" class="btn btn-secondary">Concluido</a>
	                </div> 
	                <div class="col-sm-2" >
	                	<a href="" style="margin:auto;" class="btn btn-secondary">Cancelar</a>
	                </div> 
	                <div class="col-sm-offset-2 col-sm-2" >
	                	<a href="javascript:history.back();" style="float:right;" class="btn btn-secondary ">Voltar</a>
	                </div>   
                </div>

        	<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}.
				</div>
			</c:if>	
			</div>
    </section>

<%@ include file="footer.jsp" %>
</body>
</body>
</html>
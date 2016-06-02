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
        	<c:url var="url" value="/delivery/adiciona" />
            <form:form action="${url}" modelAttribute="itemCardapio" method="post">            	
                <div class="form-group row">
                    <label for="inputNome"  class="col-sm-1	 form-control-label">Produto</label>
                 	<div class="col-sm-4" >
                         <form:select id="cCardapio"  path="id" class="form-control" required="required" >
								<form:options items="${cardapioItens}"/>
                    	 </form:select>
                    </div>
                    <label for="inputQuantidade"   class="col-sm-2 form-control-label">Quantidade</label>
                    <div class="col-sm-2">
                        <form:input type="number" min="1" value="1" class="form-control" id="inputQuantidade" placeholder="00" path="qtd" required="required" />
                    </div>
                  	<div class="col-sm-offset-0 col-sm-2" >
                        <button style="margin-left: 30px;" type="submit" class="btn btn-secondary">Adicionar Item</button>
                    </div>
                </div>
             </form:form>  
            <c:set var="test" value="" scope="application" />
            <table class="table table-sm">
	            <thead>
	            <tr>	            
	                <th>Produto</th>
	                <th>Quantidade</th>
	                <th>Total</th>
	                <th>Ações</th>
	            </tr>
	            </thead>
	            
	            <tbody>
	            
	          	<c:forEach var="item" items="${delivery.itensCardapio}">
		            <tr>
		            	<td>${item.cardapio.nome}</td>
		            	<td>${item.qtd}</td>
		            	<td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${item.qtd*item.cardapio.preco}"/></td>
		            	<c:set var="test" value="${test += item.qtd*item.cardapio.preco}" scope="application" />
		                <td><a href="<c:url value="/delivery/${item.cardapio.id}/remove" />"><img src="<c:url value="/resources/image/delete.png" />" class="icon-tb"></a></td>	               
		            </tr>
				</c:forEach>
					<tr>
		            	<td></td>
		            	<td></td>
		            	<td><fmt:formatNumber type="currency" currencySymbol="R$ " value="${delivery.total}"/></td>
		            	<td></td>
	            </tbody>
	        </table>               	
        </div>
       		<c:url var="url" value="/delivery/save" />
         	<form:form action="${url}" class="troco-form" style="width: 800px;position: relative;margin:0 auto;padding: 1.5rem;">
                 <div class="form-group row" style="margin-top: 30px;">
                
                	<div class="col-sm-3" >
                         
                    </div>
                    <div class="form-group">
	                    <label class="col-sm-2 control-label">Troco para</label>
	                    <div class="col-sm-3">
	                    	<input type="number" class="form-control" min="0" step="0.01" placeholder="R$100.00" name="pagamento" required="required" />
	                        <span class="erro-mensage" style="color:red;"></span>
	                    </div>
	                  	<div class="col-sm-offset-2 col-sm-2" >
	                        <button style="float:right;" type="submit" class="btn btn-secondary">Confirmar Pedido</button>
	                    </div>
                 	</div>
                        
                    
                </div>
          	</form:form>
        		<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin:auto; width: 50%;">
  					${mensagem}.
				</div>
				</c:if>	
				<c:if test="${erro != null}">	
				<div class="alert alert-warner" role="alert" style="margin:auto; width: 50%;">
  					${erro}.
				</div>
				</c:if>	
    </section>

<%@ include file="footer.jsp" %>
<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
</body>
</body>
</html>
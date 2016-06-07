<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="header.jsp" %>
<section>
	<div class="centrodiv" >
		<c:url var="url" value="/cliente/save"></c:url>
        <form:form name="formC" class="form-inline"  id="formulario-cadastro" action="${url}" method="post" modelAttribute="cliente" >
        	
        	<form:hidden path="dataCadastro" name="dataCadastro" />
        	<form:hidden path="id" />
            <fieldset id="dados-acesso">
                <legend style="font: bold 18px/45px sans-serif;">Dados de Acesso</legend>
                <div class="form-group">
                  <label  class="col-sm-2 form-control-label">Login:</label>
                	<div class="col-sm-10">
                	   <form:input  path="login.login" class="form-control" type="text" size="16"  maxlength="20" required="required"  />
               	   </div>
               	</div>
               	<div class="form-group">
                	<%-- <label for="cSenha" class="col-sm-2 form-control-label">Senha:</label> 
                  	<div class="col-sm-10">  
                  		<input value="${usuario.login.senha}"  class="form-control" id="cSenha" type="password" name="tSenha" size="16"  maxlength="8" placeholder="Password" style="margin-left: 10px;" disabled="disabled"  />
 -                	</div>	
 +                	</div> --%>
           	   </div>	
            </fieldset>
            <fieldset id="info-pessoal">
               <legend style="font: bold 18px/45px sans-serif;">Informações Pessoais</legend>
               	<div class="form-group" >
          	     	<label for="cNome" class="col-sm-2 form-control-label">Nome:</label>    
	           	     	<div class="col-sm-10"> 
						<p><form:input path="nome" class="form-control" id="cNome" type="text" name="nome" size="30" maxlength="30"   /> </p>
						</div>
				
					<label for="cTelefone" class="col-sm-2 form-control-label">Telefone:</label>    
						<div class="col-sm-10"> 	
						<p>	<form:input path="telefone" class="form-control" id="cTelefone" type="text" name="telefone" size="11" maxlength="14"  placeholder="(00)00000-0000" onkeypress="return mascaraTEL(this,'(##)#####-####')"  /> </p>
						</div>
				</div>
				<div class="form-group" >                    
                    <label for="cEmail" class="col-sm-2 form-control-label">Email:</label> 
                    	<div class="col-sm-10"> 
                    	<p>	<form:input path="email" class="form-control" id="cEmail" type="email" name="email" size="30" placeholder="nome@example.com"   /> </p>
               	 		</div>
           	 		<label for="cData" class="col-sm-2 form-control-label">Data de Nascimento</label>  
                   	<div class="col-sm-10">                     
                        <p>	<form:input  path="dataNasc" class="form-control" type="date" /> </p>
                	</div>
               	</div>
            </fieldset>
            <fieldset name="fieldEndereco" id="endereco" >
                <legend style="font: bold 18px/45px sans-serif;">Endereço</legend>
                <div class="form-group">
                     <label for="cRua" class="col-sm-2 form-control-label">Rua:</label>     
                     <div class="col-sm-10"> 
                        <p>	<form:input path="endereco.logradouro" class="form-control" type="text" required="required" /> </p>
               		 </div>
               
                     <label for="cNumero" class="col-sm-2 form-control-label">Número:</label>  
                     <div class="col-sm-10"> 
                     	<p>	<form:input path="endereco.numero" class="form-control" type="text" required="required" /> </p>
                	 </div>
                
                     <label for="cComplemento" class="col-sm-2 form-control-label">Complemento:</label>     
                     <div class="col-sm-10"> 
                     	<p>	<form:input path="endereco.complemento" class="form-control" type="text" required="required"   /> </p>
                	 </div>
                
                     <label for="cBairro" class="col-sm-2 form-control-label">Bairro:</label>    
                     <div class="col-sm-10"> 
                     	<p>	<form:input path="endereco.bairro" class="form-control" type="text" required="required" /> </p>
                	 </div>
                
                     <label for="cCep" class="col-sm-2 form-control-label">CEP:</label>   
                     <div class="col-sm-10">   
                     	<p>	<form:input path="endereco.cep" class="form-control" type="text" name="endereco.cep" size="6" maxlength="9" placeholder="00000-000"   required="required" onkeypress="return mascaraCEP(this,'#####-###')" /> </p>
                	 </div>
               	
                     <label for="cPais" class="col-sm-2 form-control-label">País:</label>
                     <div class="col-sm-10"> 
                     	<p> <form:input path="endereco.pais" class="form-control" type="text" required="required"  /> </p>
                	 </div>
               	 
	                     <label for="cEst"  class="col-sm-2 form-control-label">Estado:</label>
	                   	 <div class="col-sm-10">
	                   	 <p>
		                   	 <form:input name="endereco.estado" class="form-control"   path="endereco.estado" required="required" />		                    
                    	  </p>
	                	</div>
	                	
	                	<label for="cCidade" class="col-sm-2 form-control-label">Cidade:</label>
	                	<div class="col-sm-10"> 
	                		<form:input path="endereco.cidade" class="form-control" type="text" name="endereco.cidade"  required="required"  />	                		
	                	</div>
                	
               	</div>
                	
            </fieldset>
        	<div style="margin-top: 20px;">	
	           	<input name="bntEnviar" id="bnt-enviar"  class="btn btn-secondary" type="submit" value="Enviar"  >
	       		<a id="bnt-voltar" class="btn btn-secondary" role="button" href="javascript:history.back();" >Voltar</a>
        	</div>
        </form:form>
        	<c:if test="${mensagem != null}">	
				<div class="alert alert-success" role="alert" style="margin-left:auto; margin-right:auto;margin-top:30px; width: 50%;">
	 					${mensagem}.
				</div>
			</c:if>	
       </div>
</section>
<%@ include file="footer.jsp" %>
<body>
</body>
</html>
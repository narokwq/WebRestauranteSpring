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
        <form:form class="form-inline"  id="formulario-cadastro" action="${url}" method="post" modelAttribute="cliente">
            <fieldset id="dados-acesso">
                <legend style="font: bold 18px/45px sans-serif;">Dados de Acesso</legend>
                <div class="form-group">
                  <label for="cLogin" class="col-sm-2 form-control-label">Login:</label>
                	<div class="col-sm-10">
                	   <form:input path="login.login" class="form-control" id="cLogin" size="16"  maxlength="20" placeholder="Login" required='required' />
               	   </div>
               	</div>
               	<div class="form-group">
                	<label for="cSenha" class="col-sm-2 form-control-label">Senha:</label> 
                	<div class="col-sm-10">  
                		<form:password path="login.senha" class="form-control" id="cSenha" size="16"  maxlength="8" placeholder="Password" style="margin-left: 10px;" required='required' />
                	</div>	
           	   </div>	
            </fieldset>
            <fieldset id="info-pessoal">
               <legend style="font: bold 18px/45px sans-serif;">Informações Pessoais</legend>
               	<div class="form-group" >
          	     	<label for="cNome" class="col-sm-2 form-control-label">Nome:</label>    
	           	     	<div class="col-sm-10"> 
	            	     <p>	<form:input path="nome" class="form-control" id="cNome" size="30" maxlength="30" required='required' /> </p>
						</div>
				
					<label for="cTelefone" class="col-sm-2 form-control-label">Telefone:</label>    
						<div class="col-sm-10"> 	
						<p>	<form:input path="telefone" class="form-control" id="cTelefone" type="text" size="11" maxlength="14" placeholder="(00)00000-0000" onkeypress="return mascaraTEL(this,'(##)#####-####')" required='required' /> </p>
						</div>
				</div>
				<div class="form-group" >                    
                    <label for="cEmail" class="col-sm-2 form-control-label">Email:</label> 
                    	<div class="col-sm-10"> 
                    	<p>	<form:input path="email" class="form-control" id="cEmail" type="email" size="30" placeholder="nome@example.com" required='required' /> </p>
               	 		</div>
           	 		<label for="cData" class="col-sm-2 form-control-label">Data de Nascimento</label>  
                    	<div class="col-sm-10"> 
                        	<p>	       							
                        		<form:input path="dataNasc" class="form-control" id="cData" type="date" required='required' />                 <!-- Aqui não está pegando a data,tentei usa jstl fmt:date mas nao consegui. -->        	
                       		</p>               	 			
               	 		</div>
                </div>
            </fieldset>
            <fieldset name="fieldEndereco" id="endereco" >
                <legend style="font: bold 18px/45px sans-serif;">Endereço</legend>
                <div class="form-group">
                     <label for="cRua" class="col-sm-2 form-control-label">Rua:</label>     
                     <div class="col-sm-10"> 
                        <p>	<form:input path="endereco.logradouro" class="form-control" id="cRua" type="text" name="tRua" required='required' /> </p>
               		 </div>
               
                     <label for="cNumero" class="col-sm-2 form-control-label">Número:</label>  
                     <div class="col-sm-10"> 
                     	<p>	<form:input path="endereco.numero" class="form-control" id="cNumero" type="text" name="tNumero" required='required' /> </p>
                	 </div>
                
                     <label for="cComplemento" class="col-sm-2 form-control-label">Complemento:</label>     
                     <div class="col-sm-10"> 
                     	<p>	<form:input path="endereco.complemento" class="form-control" id="cComplemento" type="text" name="tComplemento" required='required' /> </p>
                	 </div>
                
                     <label for="cBairro" class="col-sm-2 form-control-label">Bairro:</label>    
                     <div class="col-sm-10"> 
                     	<p>	<form:input path="endereco.bairro" class="form-control" id="cBairro" type="text" name="tBairro" required='required' /> </p>
                	 </div>
                
                     <label for="cCep" class="col-sm-2 form-control-label">CEP:</label>   
                     <div class="col-sm-10">   
                     	<p>	<form:input path="endereco.cep" class="form-control" id="cCep" type="text" name="tCep" size="6" maxlength="9" placeholder="00000-000" onkeypress="return mascaraCEP(this,'#####-###')" required='required' /> </p>
                	 </div>
               	
                     <label for="cPais" class="col-sm-2 form-control-label">País:</label>
                     <div class="col-sm-10"> 
                     	<p> <form:input path="endereco.pais" class="form-control" id="cPais" type="text" name="tPais" required='required' /> </p>
                	 </div>
               	 
	                     <label for="cEst"  class="col-sm-2 form-control-label">Estado:</label>
	                   	 <div class="col-sm-10">
	                   	 <p>
		                   	 <form:select id="cEst" name="tEst" class="form-control" path="endereco.estado" required='required'>
		                        <option value="Distrito Federal" >Distrito Federal</option>
		                        <option value="Mato Grosso">Mato Grosso</option>
		                        <option value="Paraíba" selected>Paraíba</option>
		                        <option value="Pernambuco">Pernambuco</option>
		                        <option value="Rio de Janeiro">Rio de Janeiro</option>
		                        <option value="São Paulo">São Paulo</option>
	                    	 </form:select>
                    	  </p>
	                	</div>
	                	
	                	<label for="cCidade" class="col-sm-2 form-control-label">Cidade:</label>
	                	<div class="col-sm-10"> 
	                		<form:input path="endereco.cidade" class="form-control" id="cCidade" type="text" name="tCidade" required='required'/>	          
	                	</div>
                	
               	</div>
                	
            </fieldset>
            	<div style="margin-top: 20px;">	
	           		<input name="bntEnviar" id="bnt-enviar"  class="btn btn-secondary" type="submit" value="Enviar" >
	       			<a id="bnt-voltar" class="btn btn-secondary" role="button" href="javascript:history.back();" >Voltar</a>
	        	</div>
        </form:form>
       </div>
</section>
<%@ include file="footer.jsp" %>  
<body>
</body>
</html>
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
	<c:url var="url" value="/funcionario/update"></c:url>
        <form:form name="formC" class="form-inline"  id="formulario-cadastro" action="${url}" method="post" modelAttribute="funcionario">
        <form:hidden path="id"/>
            <fieldset id="dados-acesso">
                <legend style="font: bold 18px/45px sans-serif;">Dados de Acesso</legend>
                <div class="form-group">
                  <label for="cLogin" class="col-sm-2 form-control-label">Login:</label>
                	<div class="col-sm-10">
                	   <form:input path="login.login" class="form-control" id="cLogin" type="text" name="login.login" size="16"  maxlength="20" placeholder="Login" required='required' />
               	   </div>
               	</div>
               	<div class="form-group">
                	<label for="cSenha" class="col-sm-2 form-control-label">Senha:</label> 
                	<div class="col-sm-10">  
                		<form:input path="login.senha" class="form-control" id="cSenha" type="password" name="login.senha" size="16"  maxlength="8" placeholder="Password" style="margin-left: 10px;" required='required' />
                	</div>	
           	   </div>	
            </fieldset>
            <fieldset id="info-pessoal">
               <legend style="font: bold 18px/45px sans-serif;">Informações Pessoais</legend>
               	<div class="form-group" >
          	     	<label for="cNome" class="col-sm-2 form-control-label">Nome:</label>    
	           	     	<div class="col-sm-10"> 
	            	     <p>	<form:input path="nome" class="form-control" id="cNome" type="text" name="nome" size="30" maxlength="30" required='required' /> </p>
						</div>
				
					<label for="cTelefone" class="col-sm-2 form-control-label">Telefone:</label>    
						<div class="col-sm-10"> 	
						<p>	<form:input path="telefone" class="form-control" id="cTelefone" type="text" name="telefone" size="11" maxlength="14" placeholder="(00)00000-0000" onkeypress="return mascaraTEL(this,'(##)#####-####')" required='required' /> </p>
						</div>
				</div>
				<div class="form-group" >                    
                    <label for="cEmail" class="col-sm-2 form-control-label">Email:</label> 
                    	<div class="col-sm-10"> 
                    	<p>	<form:input path="email" class="form-control" id="cEmail" type="email" name="tEmail" size="30" placeholder="nome@example.com" required='required' /> </p>
               	 		</div>
               	 		<form:errors  path="cpf"></form:errors>	
           	 		<label for="cCpf" class="col-sm-2 form-control-label">Cpf:</label>  
                    	<div class="col-sm-10"> 
                        	<p>	       							
                        		<form:input path="cpf" class="form-control" id="cData" type="text" name="cpf" size="14" maxlength="14" required='required' />                	
                       		</p>               	 			
               	 		</div>             	 	
           	 		<label  for="cSalario" class="col-sm-2 form-control-label">Salario</label>  
	                 	<div class="col-sm-1"> 
                     		<p>	       							
	                     		<form:input  path="salario" class="form-control" id="cSalario" type="number" step="0.01" name="salario" size="8" maxlength="8" required='required' />                	
                    		</p>               	 			
	            	 		</div>
                		</div>
                	<label for="inputNome"  class="col-sm-2 form-control-label">Cargo</label>
                 	<div class="col-sm-10" >           
                         <form:select id="cCardapio"  path="cargo.id" class="form-control" required="required" >
								<form:options items="${cargos}" />
                    	 </form:select>
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
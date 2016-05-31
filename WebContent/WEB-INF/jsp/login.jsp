<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Tela Login</title>
<link href="resources/css/index.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<body>
	<div id="login-box">
		<div id="login-box-interno">
			<div id="login-box-interno-label">
				<span>Controle de Restaurante</span>
			</div>
			<c:url var="url" value="/logar" />
			<form:form class="form-horizontal" action="${url}" method="post"
				modelAttribute="login">
				<div class="form-group">
					<label class="col-sm-2 control-label">Login</label>
					<div class="col-sm-9">
						<form:input path="login" type="text" class="form-control"
							name="tLogin" placeholder="Login" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" style="margin-top: 15px;">Senha</label>
					<div class="col-sm-9">
						<form:password path="senha" style="margin-top: 15px;"
							class="form-control" name="tSenha" placeholder="Senha"
							required="required" />
					</div>
				</div>
				<div class="form-group">
					<c:if test="${msg != null}">
						<div class="alert alert-danger" role="alert"
							style="margin-left:5%;  width: 90%;">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Error:</span>${msg}
						</div>
					</c:if>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style="margin-top: 30px;">
						<a class="btn btn-info" href="cadastroCliente" role="button">Cadastra-se</a>
						<button type="submit" class="btn btn-info"
							style="margin-left: 126px;">Acessar</button>

					</div>
				</div>
			</form:form>

		</div>

	</div>
	<div>
		<c:if test="${mensagem != null}">
			<div class="alert alert-danger" role="alert"
				style="margin: auto; width: 50%;">${mensagem}</div>
		</c:if>
	</div>

</body>
</html>
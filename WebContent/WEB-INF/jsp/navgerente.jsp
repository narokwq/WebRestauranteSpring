<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	<div id="topo">
        <h2 >Cowboy Restaurante</h2>
    </div >
    <nav class="navbar" id="topofixo">
        <ul class="nav navbar-nav nav-pills">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/home" />">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Categoria
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/categoria/form" />">Cadastrar</a>
                    <a class="dropdown-item" href="<c:url value="/categoria/listar" />">Listar</a>
                   
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Cardapio
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/cardapio/form" />">Cadastrar</a>
                    <a class="dropdown-item" href="<c:url value="/cardapio/listar" />">Listar</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Mesa
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/mesa/form" />">Cadastrar</a>
                    <a class="dropdown-item" href="<c:url value="/mesa/listar" />">Listar</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Pedidos
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/pedido/listar" />">Listar Pedidos</a>
                    <%-- <a class="dropdown-item" href="<c:url value="/tradicional/form" />">Tradicional</a> --%>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Funcionario
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                <a class="dropdown-item" href="<c:url value="/funcionario/form" />" >Cadastrar</a>
               	<a class="dropdown-item" href="<c:url value="/funcionario/listar" />">Listar</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Reserva
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                <a class="dropdown-item" href="<c:url value="/reserva/form" />">Cadastrar</a>          
                <a class="dropdown-item" href="<c:url value="/reserva/listar" />">Listar</a>
                </div>
            </li>            
             <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Cargo
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                <a class="dropdown-item" href="<c:url value="/cargo/form" />">Cadastrar</a>
                <a class="dropdown-item" href="<c:url value="/cargo/listar" />">Listar</a>
                </div>
            </li>
            <li class="nav-item dropdown pull-xs-right">
	        	<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <c:out value="Bem-Vindo:  ${usuario.nome}"></c:out>
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/gerente/form/alter"/>">Alterar Meus Dados</a>
                    <a class="dropdown-item" href="<c:url value="/gerente/remove"/>">Desativar Conta</a>
                    <a class="dropdown-item" href="<c:url value="/logout" />">Logout</a>
                </div>
	        </li>
            
        </ul>
       
	        
      
    </nav>


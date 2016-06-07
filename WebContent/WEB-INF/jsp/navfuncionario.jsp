<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div id="topo">
        <span>Restaurante</span>
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
                </div>
            </li>
         
            <li class="nav-item dropdown pull-xs-right">
	        	<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <c:out value="Bem-Vindo:  ${usuario.nome}"></c:out>
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/logout" />">Logout</a>
                </div>
	        </li>          
            
        </ul>
       
	        
      
    </nav>
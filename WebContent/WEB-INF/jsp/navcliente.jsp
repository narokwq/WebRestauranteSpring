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
                    Delivery
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/delivery/form" />">Fazer Pedido</a>
                    <a class="dropdown-item" href="<c:url value="/delivery/listar" />">Meus Pedidos</a>
                </div>
            </li>            
            <li class="nav-item dropdown pull-xs-right">
	        	<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <c:out value="Bem-Vindo:  ${usuario.nome}"></c:out>
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/cliente/form/alter"/>">Alterar Meus Dados</a>
                    <a class="dropdown-item" href="<c:url value="/cliente/remove"/>">Desativar Conta</a>
                    <a class="dropdown-item" href="<c:url value="/logout" />">Logout</a>
                </div>
	        </li>
            
        </ul>      
    </nav>
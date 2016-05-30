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
                    Delivery
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="<c:url value="/delivery/form" />">Fazer Pedido</a>
                    <a class="dropdown-item" href="<c:url value="/delivery/listar" />">Meus Pedidos</a>
                </div>
            </li>
            <li class="nav-item pull-xs-right">
	        	<a class="nav-link" href="<c:url value="/logout" />">Logout</a>
	        </li>
	       
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Meu Cadastro
                </a>
                <div class="dropdown-menu" aria-labelledby="Preview">
                    <a class="dropdown-item" href="AlterarContaCliente">Alterar Meus Dados</a>
                    <a class="dropdown-item" href="DesativarContaCliente">Desativar Conta</a>
                </div>
            </li>
        </ul>
       
	        
      
    </nav>
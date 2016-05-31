package com.br.model;

public enum StatusPedido {
	
	PENDENTE("Pendente"),
	EM_ANDAMENTO("Em Andamento"),
	ATENDIDO("Atendido"),
	CANCELADO("Cancelado"),
	CONCLUIDO("Concluido");
	
	String nick;

    StatusPedido(String nick) {
        this.nick = nick;
    }
}

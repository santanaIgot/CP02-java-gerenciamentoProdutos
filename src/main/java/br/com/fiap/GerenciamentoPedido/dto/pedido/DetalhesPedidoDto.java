package br.com.fiap.GerenciamentoPedido.dto.pedido;

import br.com.fiap.GerenciamentoPedido.model.Pedido;

import java.time.LocalDate;

public record DetalhesPedidoDto(Double valorPedido, LocalDate dataPedido,String st_pedido,String descricao) {
    public DetalhesPedidoDto(Pedido pedido){
        this(pedido.getValorPedido(), pedido.getDataPedido(),pedido.getSt_pedido(), pedido.getDescricao());
    }

}

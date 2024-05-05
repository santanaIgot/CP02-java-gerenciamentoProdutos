package br.com.fiap.GerenciamentoPedido.dto.pedido;

import java.time.LocalDate;

public record CadastroPedidoDto(Double valorPedido, LocalDate dataPedido, String st_pedido, String descricao) {
}

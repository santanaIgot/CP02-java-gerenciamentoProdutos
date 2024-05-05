package br.com.fiap.GerenciamentoPedido.model;

import br.com.fiap.GerenciamentoPedido.dto.pedido.CadastroPedidoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "cd_pedido", nullable = false)
    private Long id;
    @Column(name = "valor_pedido", nullable = false)
    private Double valorPedido;
    @Column(name = "nm_pedido", nullable = false, length = 100)
    private String nome;
    @Column(name = "dt_pedido", nullable = false)
    private LocalDate dataPedido;
    @Column(name = "st_pedido", nullable = false)
    private  String statusPedido;
    @Column(name = "desc_pedio", nullable = false, length = 100)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cd_usuario", nullable = false)
    private Usuario usuario;

    public Pedido(CadastroPedidoDto dto, Usuario usuario){
        valorPedido = dto.valorPedido();
        nome = dto.nome();
        dataPedido = dto.dataPedido();
        statusPedido = dto.statusPedido();
        descricao = dto.descricao();
        this.usuario = usuario;
    }



}

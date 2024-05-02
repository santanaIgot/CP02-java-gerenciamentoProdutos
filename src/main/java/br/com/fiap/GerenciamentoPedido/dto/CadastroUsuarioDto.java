package br.com.fiap.GerenciamentoPedido.dto;

import java.time.LocalDate;
import java.util.Date;

public record CadastroUsuarioDto(Long idUsuario,Long idDetalhesUsuario, String nome, String cpf, String email,
                                 Long telefone,LocalDate dataNascismento) {

}

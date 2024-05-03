package br.com.fiap.GerenciamentoPedido.dto;

import java.time.LocalDate;
import java.util.Date;

public record CadastroUsuarioDto(String nome, String cpf, String email,
                                 Long telefone,LocalDate dataNascismento) {

}

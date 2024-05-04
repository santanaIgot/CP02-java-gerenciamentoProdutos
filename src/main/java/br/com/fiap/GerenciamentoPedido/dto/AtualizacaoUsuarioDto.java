package br.com.fiap.GerenciamentoPedido.dto;

import java.time.LocalDate;

public record AtualizacaoUsuarioDto(String nome, String cpf, String email,
                                    String telefone, LocalDate dataNascimento) {
}

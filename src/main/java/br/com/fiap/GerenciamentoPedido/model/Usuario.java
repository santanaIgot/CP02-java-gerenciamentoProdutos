package br.com.fiap.GerenciamentoPedido.model;


import br.com.fiap.GerenciamentoPedido.dto.usuario.AtualizacaoUsuarioDto;
import br.com.fiap.GerenciamentoPedido.dto.usuario.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_USUARIO")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @GeneratedValue
    @Id
    @Column(name = "cd_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Column(name = "cpf_usuario", nullable = false, length = 11)
    private String cpf;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private DetalhesUsuario detalhesUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    public Usuario (CadastroUsuarioDto dto){
        nome = dto.nome();
        cpf = dto.cpf();
        detalhesUsuario = new DetalhesUsuario(dto);
        detalhesUsuario.setUsuario(this);
    }

    public void atualizaDados(AtualizacaoUsuarioDto dto){
        if(dto.nome() != null)
            nome = dto.nome();
        if(dto.cpf() != null)
            cpf = dto.cpf();
        if(dto.email() != null)
            this.detalhesUsuario.setEmail(dto.email());
        if(dto.dataNascimento() != null)
            this.detalhesUsuario.setDataNascimento(dto.dataNascimento());
        if(dto.telefone() != null)
            this.detalhesUsuario.setTelefone(dto.telefone());

    }
}

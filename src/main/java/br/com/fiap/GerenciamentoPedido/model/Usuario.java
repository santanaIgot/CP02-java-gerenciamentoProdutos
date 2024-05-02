package br.com.fiap.GerenciamentoPedido.model;


import br.com.fiap.GerenciamentoPedido.dto.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    @GeneratedValue
    @Id
    @Column(name = "cd_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "nm_usuario", nullable = false)
    private String nome;

    @Column(name = "cpf_usuario", nullable = false, length = 11)
    private String cpf;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.MERGE)
    private DetalhesUsuario detalhesUsuario;

    public Usuario (CadastroUsuarioDto dto){
        nome = dto.nome();
        cpf = dto.cpf();
        detalhesUsuario = new DetalhesUsuario(dto);
        detalhesUsuario.setUsuario(this);
    }
}

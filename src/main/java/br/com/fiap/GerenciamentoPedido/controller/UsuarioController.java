package br.com.fiap.GerenciamentoPedido.controller;

import br.com.fiap.GerenciamentoPedido.dto.CadastroUsuarioDto;
import br.com.fiap.GerenciamentoPedido.dto.DetalhesUsuarioDto;
import br.com.fiap.GerenciamentoPedido.model.Usuario;
import br.com.fiap.GerenciamentoPedido.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;
import java.util.List;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto dto, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
        var url = uriBuilder.path("/usuario").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuarioDto(usuario));
    }


    @GetMapping
    public ResponseEntity<List<DetalhesUsuarioDto>> get(Pageable pageable){
        var lista = usuarioRepository.findAll(pageable).stream().map(DetalhesUsuarioDto::new).toList();
        return ResponseEntity.ok(lista);
    }


    //get listar
    public ResponseEntity<List<DetalhesUsuarioDto>> listar(){
        var listaUsuario = usuarioRepository.findAll().stream().map(DetalhesUsuarioDto::new).toList();
        return ResponseEntity.ok(listaUsuario);
    }

    //pesquisa por id
    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> pesquisar(@PathVariable("id") Long idUsuario){
        var usuario = usuarioRepository.getReferenceById(idUsuario);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }
}

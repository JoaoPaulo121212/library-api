package com.jotape.library_api.controller;

import jakarta.validation.Valid;
import com.jotape.library_api.model.Livro;
import com.jotape.library_api.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Diz que é uma API REST
@RequestMapping("/livros") // Define a URL base
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping // Mapeia requisições POST (Salvar)
    @ResponseStatus(HttpStatus.CREATED)
    public Livro salvar(@RequestBody @Valid Livro livro) {
        return service.salvar(livro);
    }

    @GetMapping // Mapeia requisições GET (Listar)
    public List<Livro> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}") // URL: PUT /livros/1
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna 204 (Sucesso sem conteúdo)
    public void atualizar(@PathVariable Long id, @RequestBody @Valid Livro livro) {
        service.atualizar(id, livro);
    }

    @DeleteMapping("/{id}") // URL: DELETE /livros/1
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
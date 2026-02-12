package com.jotape.library_api.service;

import com.jotape.library_api.model.Livro;
import com.jotape.library_api.repository.LivroRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service 
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro salvar(Livro livro) {
        if (repository.existsByIsbn(livro.getIsbn())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "ISBN já cadastrado!");
        }
        return repository.save(livro);
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public void atualizar(Long id, Livro livroAtualizado) {
        repository.findById(id)
            .map(livroExistente -> {
                livroExistente.setTitulo(livroAtualizado.getTitulo());
                livroExistente.setAutor(livroAtualizado.getAutor());
                return repository.save(livroExistente);
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        repository.deleteById(id);
    }
}

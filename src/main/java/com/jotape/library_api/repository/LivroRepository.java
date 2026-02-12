package com.jotape.library_api.repository;

import com.jotape.library_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    boolean existsByIsbn(String isbn);
    
    Optional<Livro> findByIsbn(String isbn);
}
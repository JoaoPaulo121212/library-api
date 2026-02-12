package com.jotape.library_api.model; // (Mantenha seu pacote original)

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // Import novo
import jakarta.validation.constraints.Size;     // Import novo
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livros")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "O título é obrigatório") // Não aceita null nem vazio ""
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "O autor é obrigatório")
    private String autor;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank(message = "O ISBN é obrigatório")
    private String isbn;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;
    
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
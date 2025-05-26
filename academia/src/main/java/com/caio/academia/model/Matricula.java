package com.caio.academia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataMatricula = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    // Construtores
    public Matricula() {
    }

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}

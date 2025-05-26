package com.caio.academia.controller;

import com.caio.academia.model.Matricula;
import com.caio.academia.repository.AlunoRepository;
import com.caio.academia.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    @PostMapping
    public Matricula criar(@RequestParam Long alunoId) {
        return alunoRepository.findById(alunoId)
                .map(aluno -> matriculaRepository.save(new Matricula(aluno)))
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + alunoId));
    }

    @GetMapping("/{id}")
    public Matricula buscarPorId(@PathVariable Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        matriculaRepository.deleteById(id);
    }
}

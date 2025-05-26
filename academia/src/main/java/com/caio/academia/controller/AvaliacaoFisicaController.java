package com.caio.academia.controller;

import com.caio.academia.model.Aluno;
import com.caio.academia.model.AvaliacaoFisica;
import com.caio.academia.repository.AlunoRepository;
import com.caio.academia.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<AvaliacaoFisica> listarAvaliacoes() {
        return avaliacaoFisicaRepository.findAll();
    }

    @PostMapping
    public AvaliacaoFisica criarAvaliacao(@RequestParam Long alunoId,
            @RequestParam double peso,
            @RequestParam double altura) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        avaliacao.setAluno(aluno);
        avaliacao.setPeso(peso);
        avaliacao.setAltura(altura);
        return avaliacaoFisicaRepository.save(avaliacao);
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica buscarPorId(@PathVariable Long id) {
        return avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}

package com.caio.academia.controller;

import com.caio.academia.model.Aluno;
import com.caio.academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.buscarPorId(id)
                .map(alunoExistente -> {
                    aluno.setId(id);
                    Aluno atualizado = alunoService.salvar(aluno);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
                .map(aluno -> {
                    alunoService.deletar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Novo endpoint para buscar por nome (query param)
    @GetMapping("/buscar")
    public List<Aluno> buscarPorNome(@RequestParam String nome) {
        return alunoService.buscarPorNome(nome);
    }

    // Endpoint para buscar por idade exata
    @GetMapping("/idade")
    public List<Aluno> buscarPorIdade(@RequestParam Integer idade) {
        return alunoService.buscarPorIdade(idade);
    }

    // Endpoint para buscar por faixa etária
    @GetMapping("/faixa-etaria")
    public List<Aluno> buscarPorFaixaEtaria(@RequestParam Integer idadeInicial, @RequestParam Integer idadeFinal) {
        return alunoService.buscarPorFaixaEtaria(idadeInicial, idadeFinal);
    }
}

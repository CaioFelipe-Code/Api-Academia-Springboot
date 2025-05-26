package com.caio.academia.service;

import com.caio.academia.model.Aluno;
import com.caio.academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Aluno> buscarPorIdade(Integer idade) {
        return alunoRepository.findAll();
    }

    public List<Aluno> buscarPorFaixaEtaria(Integer idadeInicial, Integer idadeFinal) {
        return alunoRepository.findByIdadeBetween(idadeInicial, idadeFinal);
    }
}

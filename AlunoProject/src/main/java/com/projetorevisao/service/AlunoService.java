package com.projetorevisao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetorevisao.entites.Aluno;
import com.projetorevisao.repository.AlunoRepository;

@Service
public class AlunoService  {
	
private final AlunoRepository alunoRepository;
	
	@Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
	
	  public List<Aluno> getAllAluno() {
	        return alunoRepository.findAll();
	    }

	    public Aluno getAlunoById(Long id) {
	        Optional<Aluno> aluno = alunoRepository.findById(id);
	        return aluno.orElse(null);
	    }

	    public Aluno salvarAluno(Aluno aluno) {
	        return alunoRepository.save(aluno);
	    }

	    public Aluno updateAluno(Long id, Aluno updatedAluno) {
	        Optional<Aluno> existingAluno = alunoRepository.findById(id);
	        if (existingAluno.isPresent()) {
	            updatedAluno.setid(id);
	            return alunoRepository.save(updatedAluno);
	        }
	        return null;
	    }

	    public boolean deleteAluno(Long id) {
	        Optional<Aluno> existingAluno = alunoRepository.findById(id);
	        if (existingAluno.isPresent()) {
	           alunoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	  
}

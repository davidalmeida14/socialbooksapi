package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	public LivrosRepository livrosRepository;
	
	public List<Livro> listarLivros(){
		return livrosRepository.findAll();
	}	
	
	public Livro buscarLivro(Long id) {
		Livro livro = livrosRepository.findById(id).orElse(null);
		if(livro == null) {
			throw new LivroNaoEncontradoException("O livro não foi encontrado");
		}
		return livro;
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return  livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			 new LivroNaoEncontradoException("O livro não foi encontrado");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	public void verificarExistencia(Livro livro) {
		buscarLivro(livro.getId());
	}
	
}



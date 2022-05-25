package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.entity.Atividade;

import com.residencia.academia.repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	AtividadeRepository atividadeRepository;
	
	public List<Atividade> findAll(){
		return atividadeRepository.findAll();
	}
	
	public Atividade findAtividadeById(Integer id) {
		return atividadeRepository.findById(id).isPresent() ? atividadeRepository.findById(id).get():null;
	}
	
	public Atividade saveAtividade(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	
	public Atividade updateAtividade(Atividade atividade, Integer id) {
		atividade.setAtividadeId(id);
		return atividadeRepository.save(atividade);
	}
	
	public void deleteAtividade (Integer id) {
		Atividade ativ = atividadeRepository.findById(id).get();
		atividadeRepository.delete(ativ);
	}
	
	public void deleteAtividade(Atividade atividade) {
		atividadeRepository.delete(atividade);
	}
	
}


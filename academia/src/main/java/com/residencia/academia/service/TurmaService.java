package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	InstrutorService instrutorService;
	
	public List<Turma> findAllTurma(){
		return turmaRepository.findAll();
	}
	
//	public Turma findTurmaById (Integer id) {
//		return turmaRepository.findById(id).get();
//	}
	
	public Turma findTurmaById(Integer id) {
		return turmaRepository.findById(id).isPresent() ?
			turmaRepository.findById(id).get() :
				null;
	}
	
	public Turma saveTurma (Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public TurmaDTO saveTurmaDTO(TurmaDTO TurmaDTO) {
		Turma turma = convertDtoToEntity(TurmaDTO);
		
		Turma turmaNovo =turmaRepository.save(turma);
		
		 return convertEntitytoDto (turmaNovo);
	}
	
	public Turma updateTurma (Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public void deleteTurma (Integer id) {
		turmaRepository.deleteById(id);
	}
	
	/*
	public Boolean deleteTurmaComConferencia(Integer id) {
		if(turmaRepository.findById(id).isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	*/
	
	private TurmaDTO convertEntityToDto(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
		turmaDTO.setHorarioTurma(turma.getHorarioTurma());
		turmaDTO.setTurmaId(turma.getTurmaId());
		
		Instrutor instrutor = instrutorService.findInstrutorById(turmaDTO.getInstrutorDTO().getInstrutorId());
		
		return turmaDTO;
	}
	
	private Turma convertDtoToEntity(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		turma.setDataFim(turmaDTO.getDataFim());
		turma.setDataInicio(turmaDTO.getDataInicio());
		turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
		turma.setHorarioTurma(turmaDTO.getHorarioTurma());
		turma.setTurmaId(turmaDTO.getTurmaId());
		
		
		
		Turma turmaNovo = turmaRepository.save(turma);
		
		return  turmaNovo;
	}
	
	private TurmaDTO convertEntitytoDto (Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
		turmaDTO.setHorarioTurma(turma.getHorarioTurma());
		turmaDTO.setTurmaId(turma.getTurmaId());
		
		return turmaDTO;
	}
}

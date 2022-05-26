package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;

import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepository;

	public List<Instrutor> findAllInstrutor() {
		return instrutorRepository.findAll();
	}

	public Instrutor findInstrutorById(Integer id) {
		return instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get() : null;
	}

	public InstrutorDTO findInstrutorDTOById(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get()
				: null;

		InstrutorDTO instrutorDTO = new InstrutorDTO();
		if (null != instrutor) {
				instrutorDTO = convertEntityToDto(instrutor);
		}
		return instrutorDTO;
	}

	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public InstrutorDTO saveInstrutorDTO(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = convertDtoToEntity(instrutorDTO);
		 Instrutor instrutorNovo =instrutorRepository.save(instrutor);
		 
		 return convertEntitytoDto(instrutorNovo);
	}
	
	

	public Instrutor updateInstrutor(Instrutor instrutor) {
//		instrutor.setInstrutorId(id);
		return instrutorRepository.save(instrutor);
	}

	public void deleteInstrutor(Integer id) {
		Instrutor inst = instrutorRepository.findById(id).get();
		instrutorRepository.delete(inst);
	}

	public void deleteInstrutor(Instrutor instrutor) {
		instrutorRepository.delete(instrutor);
	}

	public InstrutorDTO convertEntityToDto(Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
		instrutorDTO.setInstrutorId(instrutor.getInstrutorId());
		instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
		instrutorDTO.setRg(instrutor.getRg());
		instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());

		List<TurmaDTO> listTurmaDTO = new ArrayList<>();

		for (Turma turma : instrutor.getTurmaList()) {
			TurmaDTO turmaDTO = new TurmaDTO();
			turmaDTO.setDataFim(turma.getDataFim());
			turmaDTO.setDataInicio(turma.getDataInicio());
			turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
			turmaDTO.setHorarioTurma(turma.getHorarioTurma());
			turmaDTO.setTurmaId(turma.getTurmaId());

			listTurmaDTO.add(turmaDTO);
		}
		instrutorDTO.setTurmaDTOList(listTurmaDTO);
		return instrutorDTO;
	}
	
	public Instrutor convertDtoToEntity(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = new Instrutor();
		instrutor.setDataNascimento(instrutorDTO.getDataNascimento());
		instrutor.setInstrutorId(instrutorDTO.getInstrutorId());
		instrutor.setRg(instrutorDTO.getRg());
		instrutor.setTitulacaoInstrutor(instrutorDTO.getTitulacaoInstrutor());
		instrutor.setNomeInstrutor(instrutorDTO.getNomeInstrutor());
		
		Instrutor instrutorNovo = instrutorRepository.save(instrutor);
		
		return  instrutorNovo;
	}
	
	private InstrutorDTO convertEntitytoDto (Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
		instrutorDTO.setInstrutorId(instrutor.getInstrutorId());
		instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
		instrutorDTO.setRg(instrutor.getRg());
		instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());
		
		return instrutorDTO;
	}
}

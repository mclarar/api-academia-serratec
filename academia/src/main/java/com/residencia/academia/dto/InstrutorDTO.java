package com.residencia.academia.dto;

import java.util.Date;
import java.util.List;

import com.residencia.academia.entity.Instrutor;

public class InstrutorDTO {

	private Integer instrutorId;
	private Integer rg;
	private String nomeInstrutor;
	private Date dataNascimento;
	private Integer titulacaoInstrutor;
	private List<TurmaDTO> turmaDTOList;
	
	

	
	public Integer getInstrutorId() {
		return instrutorId;
	}

	public void setInstrutorId(Integer instrutorId) {
		this.instrutorId = instrutorId;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTitulacaoInstrutor() {
		return titulacaoInstrutor;
	}

	public void setTitulacaoInstrutor(Integer titulacaoInstrutor) {
		this.titulacaoInstrutor = titulacaoInstrutor;
	}

	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}

	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}

	@Override
	public String toString() {
		return "InstrutorDTO [instrutorId=" + instrutorId + ", rg=" + rg + ", nomeInstrutor=" + nomeInstrutor
				+ ", dataNascimento=" + dataNascimento + ", titulacaoInstrutor=" + titulacaoInstrutor
				+ ", turmaDTOList=" + turmaDTOList + "]";
	}

	

}
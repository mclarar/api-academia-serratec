package com.residencia.academia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Integer atividadeId;
	
	@Column(name ="nome")
	private String nomeAtividade;

	@OneToMany(mappedBy = "atividade")
//	@JsonIgnore
	private List<Turma> TurmaList;

	public Integer getAtividadeId() {
		return atividadeId;
	}

	public void setAtividadeId(Integer atividadeId) {
		this.atividadeId = atividadeId;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public List<Turma> getTurmaList() {
		return TurmaList;
	}

	public void setTurmaList(List<Turma> turmaList) {
		TurmaList = turmaList;
	}

	
	
	
	
}

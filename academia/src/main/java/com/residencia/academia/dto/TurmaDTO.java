package com.residencia.academia.dto;

import java.util.Date;

public class TurmaDTO {

	private Integer turmaId;
	private Date horarioTurma;
	private Integer duracaoTurma;
	private Date dataInicio;
	private Date dataFim;
	private InstrutorDTO instrutorDTO;

	public Integer getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Integer turmaId) {
		this.turmaId = turmaId;
	}

	public Date getHorarioTurma() {
		return horarioTurma;
	}

	public void setHorarioTurma(Date horarioTurma) {
		this.horarioTurma = horarioTurma;
	}

	public Integer getDuracaoTurma() {
		return duracaoTurma;
	}

	public void setDuracaoTurma(Integer duracaoTurma) {
		this.duracaoTurma = duracaoTurma;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public InstrutorDTO getInstrutorDTO() {
		return instrutorDTO;
	}

	public void setInstrutorDTO(InstrutorDTO instrutorDTO) {
		this.instrutorDTO = instrutorDTO;
	}

	@Override
	public String toString() {
		return "TurmaDTO [turmaId=" + turmaId + ", horarioTurma=" + horarioTurma + ", duracaoTurma=" + duracaoTurma
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}

}

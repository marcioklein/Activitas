package br.net.oi.activitas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Demanda {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String demanda;
	@Column
	@Enumerated(EnumType.STRING)
	private StatusDemanda status;
	@Column
	private String descricao;
	@Column
	private Sistema sistema;
	@Column
	private Usuario solicitante;
	@Column
	private Usuario aprovador;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEncerramento;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataRequerida;
	@Column
	private Grupo grupo;
	@Column
	private Departamento departamento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDemanda() {
		return demanda;
	}
	public void setDemanda(String demanda) {
		this.demanda = demanda;
	}
	public StatusDemanda getStatus() {
		return status;
	}
	public void setStatus(StatusDemanda status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	public Usuario getAprovador() {
		return aprovador;
	}
	public void setAprovador(Usuario aprovador) {
		this.aprovador = aprovador;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public Date getDataRequerida() {
		return dataRequerida;
	}
	public void setDataRequerida(Date dataRequerida) {
		this.dataRequerida = dataRequerida;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}

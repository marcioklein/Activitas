package br.net.oi.activitas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Demanda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -988280061108278333L;

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
	@ManyToOne
	@JoinColumn(name="id")
	private Sistema sistema;
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario solicitante;
	@ManyToOne
	@JoinColumn(name="id")
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
	@ManyToOne
	@JoinColumn(name="id")
	private Grupo grupo;
	@ManyToOne
	@JoinColumn(name="id")
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aprovador == null) ? 0 : aprovador.hashCode());
		result = prime * result
				+ ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime
				* result
				+ ((dataEncerramento == null) ? 0 : dataEncerramento.hashCode());
		result = prime * result
				+ ((dataRequerida == null) ? 0 : dataRequerida.hashCode());
		result = prime * result + ((demanda == null) ? 0 : demanda.hashCode());
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sistema == null) ? 0 : sistema.hashCode());
		result = prime * result
				+ ((solicitante == null) ? 0 : solicitante.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demanda other = (Demanda) obj;
		if (aprovador == null) {
			if (other.aprovador != null)
				return false;
		} else if (!aprovador.equals(other.aprovador))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataEncerramento == null) {
			if (other.dataEncerramento != null)
				return false;
		} else if (!dataEncerramento.equals(other.dataEncerramento))
			return false;
		if (dataRequerida == null) {
			if (other.dataRequerida != null)
				return false;
		} else if (!dataRequerida.equals(other.dataRequerida))
			return false;
		if (demanda == null) {
			if (other.demanda != null)
				return false;
		} else if (!demanda.equals(other.demanda))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sistema == null) {
			if (other.sistema != null)
				return false;
		} else if (!sistema.equals(other.sistema))
			return false;
		if (solicitante == null) {
			if (other.solicitante != null)
				return false;
		} else if (!solicitante.equals(other.solicitante))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}

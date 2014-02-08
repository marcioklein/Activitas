package br.net.oi.activitas.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Grupo;
import br.net.oi.activitas.regras.GrupoRN;
import br.net.oi.activitas.util.ContextoUtil;



@ManagedBean(name="grupoBean")
@RequestScoped
public class GrupoBean {
	private Grupo grupo = new Grupo();
	private List<Grupo> lista = null;
	private List<Grupo> listaPorDepartamento = null;

	public List<Grupo> getLista() {
		if(this.lista==null){
			GrupoRN grupoRN = new GrupoRN();
			this.lista = grupoRN.listar();
		}
		return this.lista;
	}
	


	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}



	public List<Grupo> getListaPorDepartamento() {
		if(this.listaPorDepartamento==null){
			GrupoRN grupoRN = new GrupoRN();
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			this.listaPorDepartamento = grupoRN.listarPorDepartamento(contextoBean.getDepartamento());
		}
		return this.listaPorDepartamento;
	}



}

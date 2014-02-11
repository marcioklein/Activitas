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
		//GrupoRN grupoRN = new GrupoRN();
		//ContextoBean contextoBean = ContextoUtil.getContextoBean();
		//Departamento departamento;
		//departamento = contextoBean.getDepartamento();
		//System.out.println("xxx27");
		//this.listaPorDepartamento = grupoRN.listarPorDepartamento(contextoBean.getDepartamento());
		if(this.lista==null){
			GrupoRN grupoRN = new GrupoRN();
			this.lista = grupoRN.listar();
		}
		System.out.println("xxx");
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
			if(contextoBean!=null){
				this.listaPorDepartamento = grupoRN.listarPorDepartamento(contextoBean.getDepartamento());
			}else{
				System.out.println("falha ao capturar contexto");
			}
		}
		return this.listaPorDepartamento;
	}



}

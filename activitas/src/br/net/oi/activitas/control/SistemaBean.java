package br.net.oi.activitas.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Sistema;
import br.net.oi.activitas.regras.SistemaRN;
import br.net.oi.activitas.util.ContextoUtil;

@ManagedBean(name="sistemaBean")
@RequestScoped
public class SistemaBean {
	private Sistema sistema = new Sistema();
	private List<Sistema> lista = null;
	private List<Sistema> listaPorDepartamento = null;
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public List<Sistema> getLista() {
		if(this.lista==null){
			SistemaRN sistemaRN = new SistemaRN();
			this.lista = sistemaRN.listar();
		}
		return lista;
	}
	public List<Sistema> getListaPorDepartamento() {
		if(this.listaPorDepartamento==null){
			SistemaRN sistemaRN = new SistemaRN();
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Departamento departamento = null;
			if(contextoBean!=null){
				departamento = contextoBean.getDepartamento();
				this.listaPorDepartamento = sistemaRN.listarPorDepartamento(departamento);
			}
			
		}
		return this.listaPorDepartamento;
	}
	
}

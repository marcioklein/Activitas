package br.net.oi.activitas.control;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Sistema;
import br.net.oi.activitas.model.Usuario;
import br.net.oi.activitas.regras.DemandaRN;
import br.net.oi.activitas.regras.SistemaRN;
import br.net.oi.activitas.util.ContextoUtil;

@ManagedBean(name="demandaBean")
@RequestScoped
public class DemandaBean {
	private Demanda demanda = new Demanda();
	private List<Demanda> lista = null;
	private List<Demanda> listaPorUsuario = null;
	private Sistema selectedSistema;
	
	public void salvar(){
		DemandaRN demandaRN = new DemandaRN();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		demandaRN.salvar(this.demanda,contextoBean.getDepartamento(),contextoBean.getUsuarioLogado());
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Demanda salva com sucesso!");
		context.addMessage(null, facesMessage);
		this.listaPorUsuario = null;
	}
	public void editar(){
		
	}
	public void excluir(){
		
	}
	public String novo(){
		this.demanda = new Demanda();
		return "demanda";
	}
	public List<Demanda> getLista() {
		return lista;
	}
	public void setLista(List<Demanda> lista) {
		this.lista = lista;
	}
	public Demanda getDemanda() {
		return demanda;
	}
	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}
	public Sistema getSelectedSistema() {
		return selectedSistema;
	}
	public void setSelectedSistema(Sistema selectedSistema) {
		this.selectedSistema = selectedSistema;
	}
	public List<Demanda> getListaPorUsuario() {
		if(this.listaPorUsuario==null){
			DemandaRN demandaRN = new DemandaRN();
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Departamento departamento = null;
			Usuario usuario = null;
			if(contextoBean!=null){
				departamento = contextoBean.getDepartamento();
				usuario = contextoBean.getUsuarioLogado();
				this.listaPorUsuario = demandaRN.listarPorUsuario(departamento,usuario);
			}
			
		}
		return this.listaPorUsuario;
	}
	public void setListaPorUsuario(List<Demanda> listaPorUsuario) {
		this.listaPorUsuario = listaPorUsuario;
	}
}

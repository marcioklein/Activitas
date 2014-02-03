package br.net.oi.activitas.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.net.oi.activitas.model.Demanda;

@ManagedBean(name="demandaBean")
@RequestScoped
public class DemandaBean {
	private Demanda demanda = new Demanda();
	private List<Demanda> lista = null;
	
	public void salvar(){
		
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
}

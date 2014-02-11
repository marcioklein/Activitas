package br.net.oi.activitas.regras;

import java.util.List;

import br.net.oi.activitas.dao.DemandaDao;
import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.StatusDemanda;
import br.net.oi.activitas.model.Usuario;
import br.net.oi.activitas.util.DaoFactory;


public class DemandaRN {
	private DemandaDao demandaDao;
	public DemandaRN(){
		this.demandaDao = DaoFactory.criarDemandaDao();
	}
	public Demanda carregar(Integer id){
		return this.demandaDao.carregar(id);
	}
	public void salvar(Demanda demanda,Departamento departamento,Usuario solicitante){
		Integer id = demanda.getId();
		if(id==null || id==0){
			java.util.Date today = new java.util.Date();
			demanda.setDataAbertura(new java.sql.Date(today.getTime()));
			demanda.setStatus(StatusDemanda.NOVA);
			demanda.setDepartamento(departamento);
			demanda.setSolicitante(solicitante);
			this.demandaDao.salvar(demanda);
		}else{
			this.demandaDao.atualizar(demanda);
		}
	}
	public void excluir(Demanda demanda){
		this.demandaDao.excluir(demanda);
	}
	public List<Demanda> listar(){
		return this.demandaDao.listar();
	}
	public List<Demanda> listarPorUsuario(Departamento departamento,Usuario usuario){
		return this.demandaDao.listarPorUsuario(departamento,usuario);
	}
}

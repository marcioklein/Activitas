package br.net.oi.activitas.regras;

import java.util.List;

import br.net.oi.activitas.dao.DemandaDao;
import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.StatusDemanda;
import br.net.oi.activitas.util.DaoFactory;


public class DemandaRN {
	private DemandaDao demandaDao;
	public DemandaRN(){
		this.demandaDao = DaoFactory.criarDemandaDao();
	}
	public Demanda carregar(Integer id){
		return this.demandaDao.carregar(id);
	}
	public void salvar(Demanda demanda){
		Integer id = demanda.getId();
		if(id==null || id==0){
			demanda.setStatus(StatusDemanda.NOVA);
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
}

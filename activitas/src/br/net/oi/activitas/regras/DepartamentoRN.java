package br.net.oi.activitas.regras;

import java.util.List;

import br.net.oi.activitas.dao.DemandaDao;
import br.net.oi.activitas.dao.DepartamentoDao;
import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.StatusDemanda;
import br.net.oi.activitas.util.DaoFactory;


public class DepartamentoRN {
	private DepartamentoDao departamentoDao;
	public DepartamentoRN(){
		this.departamentoDao = DaoFactory.criarDepartamentoDao();
	}
	public Departamento carregar(Integer id){
		return this.departamentoDao.carregar(id);
	}
	public void salvar(Departamento departamento){
		Integer id = departamento.getId();
		if(id==null || id==0){
			this.departamentoDao.salvar(departamento);
		}else{
			this.departamentoDao.atualizar(departamento);
		}
	}
	public void excluir(Departamento departamento){
		this.departamentoDao.excluir(departamento);
	}
	public List<Departamento> listar(){
		return this.departamentoDao.listar();
	}
}

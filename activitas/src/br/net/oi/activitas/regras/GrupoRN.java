package br.net.oi.activitas.regras;

import java.util.List;

import br.net.oi.activitas.dao.GrupoDao;
import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Grupo;
import br.net.oi.activitas.util.DaoFactory;

public class GrupoRN {
	private GrupoDao grupoDao;
	public GrupoRN(){
		this.grupoDao = DaoFactory.criarGrupoDao();
	}
	public Grupo carregar(Integer id){
		return this.grupoDao.carregar(id);
	}
	public void salvar(Grupo grupo){
		this.grupoDao.salvar(grupo);
	}
	public void excluir(Grupo grupo){
		this.grupoDao.excluir(grupo);
	}
	public List<Grupo> listar(){
		return this.grupoDao.listar();
	}
	public List<Grupo> listarPorDepartamento(Departamento departamento){
		return this.grupoDao.listarPorDepartamento(departamento);
	}
}

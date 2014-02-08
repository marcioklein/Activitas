package br.net.oi.activitas.regras;

import java.util.List;

import br.net.oi.activitas.dao.SistemaDao;
import br.net.oi.activitas.model.Sistema;
import br.net.oi.activitas.util.DaoFactory;

public class SistemaRN {
	private SistemaDao sistemaDao;
	public SistemaRN(){
		this.sistemaDao = DaoFactory.criarSistemaDao();
	}
	public Sistema carregar(Integer id){
		return this.sistemaDao.carregar(id);
	}
	public void salvar(Sistema sistema){
		this.sistemaDao.salvar(sistema);
	}
	public void excluir(Sistema sistema){
		this.sistemaDao.excluir(sistema);
	}
	public List<Sistema> listar(){
		return this.sistemaDao.listar();
	}
}

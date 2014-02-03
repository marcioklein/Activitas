package br.net.oi.activitas.dao;

import java.util.List;

import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.Departamento;



public interface DepartamentoDao {
	public void salvar(Departamento departamento);
	public void atualizar(Departamento departamento);
	public void excluir(Departamento departamento);
	public Departamento carregar(Integer id);
	public List<Departamento> listar();
}

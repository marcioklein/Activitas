package br.net.oi.activitas.dao;

import java.util.List;

import br.net.oi.activitas.model.Demanda;



public interface DemandaDao {
	public void salvar(Demanda demanda);
	public void atualizar(Demanda demanda);
	public void excluir(Demanda demanda);
	public Demanda carregar(Integer id);
	public List<Demanda> listar();
}

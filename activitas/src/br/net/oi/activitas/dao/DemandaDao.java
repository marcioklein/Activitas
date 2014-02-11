package br.net.oi.activitas.dao;

import java.util.List;

import br.net.oi.activitas.model.Demanda;
import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Usuario;



public interface DemandaDao {
	public void salvar(Demanda demanda);
	public void atualizar(Demanda demanda);
	public void excluir(Demanda demanda);
	public Demanda carregar(Integer id);
	public List<Demanda> listar();
	public List<Demanda> listarPorUsuario(Departamento departamento , Usuario usuario);
}

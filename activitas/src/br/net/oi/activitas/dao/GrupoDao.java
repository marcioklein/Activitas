package br.net.oi.activitas.dao;

import java.util.List;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Grupo;

public interface GrupoDao {
	public void salvar(Grupo grupo);
	public void excluir(Grupo grupo);
	public Grupo carregar(Integer id);
	public List<Grupo> listar();
	public List<Grupo> listarPorDepartamento(Departamento departamento);
}

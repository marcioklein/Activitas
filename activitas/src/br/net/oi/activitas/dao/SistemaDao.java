package br.net.oi.activitas.dao;

import java.util.List;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Sistema;

public interface SistemaDao {
	public void salvar(Sistema sistema);
	public void excluir(Sistema sistema);
	public Sistema carregar(Integer id);
	public List<Sistema> listar();
	public List<Sistema> listarPorDepartamento(Departamento departamento);
}

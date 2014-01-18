package br.net.oi.activitas.dao;

import java.util.List;

import br.net.oi.activitas.model.Usuario;

public interface UsuarioDao {
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario carregar(Integer id);
	public Usuario buscarPorLogin(String login);
	public List<Usuario> listar();
}

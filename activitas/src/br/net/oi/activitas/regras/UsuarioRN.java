package br.net.oi.activitas.regras;

import java.util.List;

import br.net.oi.activitas.dao.UsuarioDao;
import br.net.oi.activitas.model.Usuario;
import br.net.oi.activitas.util.DaoFactory;

public class UsuarioRN {
	private UsuarioDao usuarioDao;
	public UsuarioRN(){
		this.usuarioDao =DaoFactory.criarUsuarioDao();
	}
	public Usuario carregar(Integer id){
		return this.usuarioDao.carregar(id);
	}
	public Usuario buscarPorLogin(String login){
		return this.usuarioDao.buscarPorLogin(login);
	}
	public void salvar(Usuario usuario,Usuario usuarioLogado){
		usuario.setDepartamento(usuarioLogado.getDepartamento());
		this.salvar(usuario);
	}
	public void salvar(Usuario usuario){
		Integer id = usuario.getId();
		if(id==null || id==0){
			//todo usuario novo deve ser criado ativo
			usuario.getPermissao().add("ROLE_SOLICITANTE");
			usuario.setAtivo(true);
			this.usuarioDao.salvar(usuario);
		}else{
			this.usuarioDao.atualizar(usuario);
		}
	}
	public void excluir(Usuario usuario){
		this.usuarioDao.excluir(usuario);
	}
	public List<Usuario> listar(){
		return this.usuarioDao.listar();
	}
}

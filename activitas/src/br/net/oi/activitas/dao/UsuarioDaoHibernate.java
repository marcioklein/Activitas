package br.net.oi.activitas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.net.oi.activitas.model.Usuario;

public class UsuarioDaoHibernate implements UsuarioDao {
	private Session session;
	public void setSession(Session session){
		this.session = session;
	}
	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);

	}

	@Override
	public void atualizar(Usuario usuario) {
		this.session.update(usuario);

	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);

	}

	@Override
	public Usuario carregar(Integer id) {
		return (Usuario)this.session.get(Usuario.class, id);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario)consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Usuario.class).list();
	}

}

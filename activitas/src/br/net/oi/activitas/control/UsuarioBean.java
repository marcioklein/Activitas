package br.net.oi.activitas.control;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.util.DigestUtils;

import br.net.oi.activitas.model.Usuario;
import br.net.oi.activitas.regras.UsuarioRN;
@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String senhaCriptografada;
	private String confirmarSenha;
	private List<Usuario> lista;
	public List<Usuario> getLista() {
		if(this.lista==null){
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return lista;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	public String novo(){
		this.usuario = new Usuario();
		return "usuario";
	}
	public String salvar(){
		Integer id = this.usuario.getId();
		if(id==null || id==0){
			//obtem o dep do usuario logado
			UsuarioRN usuarioRN = new UsuarioRN();
			Usuario usuarioLogado = usuarioRN.carregar(1);
			this.usuario.setDepartamento(usuarioLogado.getDepartamento());
		}
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (senha != null &&
	            senha.trim().length() > 0  &&
	            !senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha n‹o foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		if (senha != null && senha.trim().length() == 0) {
			this.usuario.setSenha(this.senhaCriptografada);
		} else {
			String senhaCripto = DigestUtils.md5DigestAsHex(senha.getBytes());
			this.usuario.setSenha(senhaCripto);
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		FacesMessage facesMessage = new FacesMessage("Usu‡rio "+this.usuario.getLogin()+" salvo com sucesso!");
		context.addMessage(null, facesMessage);
		return "usuarioSucesso";
	}
	public String editar(){
		//this.confirmarSenha = this.usuario.getSenha();
		this.senhaCriptografada = this.usuario.getSenha();
		return "usuario";
	}
	public String excluir(){
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		//this.getLista();
		//a lista nao esta atualizando
		return null;
	}
	public String atribuiPermissao(Usuario usuario,String permissao){
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if(permissoes.contains(permissao)){
			permissoes.remove(permissao);
		}else{
			permissoes.add(permissao);
		}
		return null;
	}
	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}
	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}
}

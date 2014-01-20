package br.net.oi.activitas.control;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.net.oi.activitas.model.Usuario;
import br.net.oi.activitas.regras.UsuarioRN;
@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
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
		if(!senha.equals(this.confirmarSenha)){
			FacesMessage facesMessage = new FacesMessage("A senha n‹o foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		//aqui vai o usuario logado
		//temporariamente ser‡ o usuario 1
		usuarioRN.salvar(this.usuario);
		FacesMessage facesMessage = new FacesMessage("Usu‡rio "+this.usuario.getLogin()+" salvo com sucesso!");
		context.addMessage(null, facesMessage);
		return "usuarioSucesso";
	}
}

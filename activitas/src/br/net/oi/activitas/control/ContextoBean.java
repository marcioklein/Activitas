package br.net.oi.activitas.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Usuario;
import br.net.oi.activitas.regras.DepartamentoRN;
import br.net.oi.activitas.regras.UsuarioRN;

@ManagedBean(name="contextoBean")
@SessionScoped
public class ContextoBean {
	private Usuario usuarioLogado = null;
	private Departamento departamento = null;
	
	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if(this.usuarioLogado==null || !login.equals(this.usuarioLogado.getLogin())){
			if(login != null){
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public Departamento getDepartamento() {
		System.out.println("xxx35");
		if(this.departamento==null){
			Usuario usuario = this.getUsuarioLogado();
			DepartamentoRN departamentoRN = new DepartamentoRN();
			this.departamento = usuario.getDepartamento();
		}
		return this.departamento;
	}

	

}

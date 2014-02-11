package br.net.oi.activitas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.net.oi.activitas.model.Departamento;
import br.net.oi.activitas.model.Grupo;
import br.net.oi.activitas.model.Sistema;
import br.net.oi.activitas.regras.DepartamentoRN;
import br.net.oi.activitas.regras.GrupoRN;
import br.net.oi.activitas.regras.SistemaRN;

@FacesConverter(value = "grupoConverter")
public class GrupoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length()>0){
			Integer codigo = Integer.valueOf(value);
			try{
				GrupoRN grupoRN = new GrupoRN();
				return grupoRN.carregar(codigo);
			}catch(Exception e){
				throw new ConverterException("N‹o foi poss’vel encontrar o Grupo");
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null){
			Grupo grupo = (Grupo)object;
			return grupo.getId().toString();
		}
		return null;
	}

}

package br.net.oi.activitas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.net.oi.activitas.model.Sistema;
import br.net.oi.activitas.regras.SistemaRN;

@FacesConverter(value = "sistemaConverter")
public class SistemaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value.equals("Selecione..."))return null;
		if(value != null && value.trim().length()>0){
			Integer codigo = Integer.valueOf(value);
			try{
				SistemaRN sistemaRN = new SistemaRN();
				return sistemaRN.carregar(codigo);
			}catch(Exception e){
				throw new ConverterException("N‹o foi poss’vel encontrar o Sistema");
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if(object != null &&(object instanceof Sistema)){
			Sistema sistema = (Sistema)object;
			return sistema.getId().toString();
		}
		return null;
	}

}

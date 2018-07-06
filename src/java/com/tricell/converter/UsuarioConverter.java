/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.converter;

import com.tricell.model.Usuario;
import com.tricell.repository.OrcamentoController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Eu
 */
@FacesConverter(value = "UsuarioConverter")
public class UsuarioConverter implements Converter {

    OrcamentoController controller = new OrcamentoController();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            return controller.findUsuario(Long.parseLong(string));
        } catch (Exception e) {
            System.out.println("\n\ndado nao encontrado\t" + string + "\n\n");
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        try {
            return String.valueOf(((Usuario) o).getIdUsuario());
        } catch (Exception e) {
            return "";
        }
    }

}

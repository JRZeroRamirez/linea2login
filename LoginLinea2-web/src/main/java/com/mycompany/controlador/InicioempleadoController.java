/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOUsuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author JR
 */
@Named
@SessionScoped
public class InicioempleadoController implements Serializable{

    private DTOUsuario user;
    /**
     * Creates a new instance of InicioTrabajadorController
     */
    public InicioempleadoController() {
    }
    
    public void validarSesion() {
        try {
            FacesContext faces = FacesContext.getCurrentInstance();
            DTOUsuario usuario = (DTOUsuario) faces.getExternalContext().getSessionMap().get("usuario");
            if (usuario == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Está tratando de ingresar .");
                faces.addMessage(null, msg);
                faces.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect("./../login.xhtml");
            }
            else if(!usuario.getRol().equals("Trabajador")){
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No tiene permisos para ingresar a esta sección del sitio.");
                faces.addMessage(null, msg);
                context.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect(usuario.getRol().toLowerCase()+"/Index.xhtml");
            }
            user=usuario;
        } catch (Exception e) {

        }
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
    
    public DTOUsuario getUser() {
        return user;
    }

    public void setUser(DTOUsuario user) {
        this.user = user;
    }
}
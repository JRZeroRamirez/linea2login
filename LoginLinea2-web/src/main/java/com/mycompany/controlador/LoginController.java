/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.IloginSesion;
import com.mycompany.interfaces.IUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author JR
 */
@Named
@RequestScoped
public class LoginController implements Serializable{

    private List<DTOUsuario> listaUsuarios;
    private String usuario;
    private String contrasena;
    
    @EJB
    IloginSesion ejb;
    
    @EJB
    IUsuario ejbUsuario;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        listaUsuarios = new ArrayList();
    }
    
    public String iniciarSesion(){
        DTOUsuario user = ejbUsuario.login(usuario, contrasena);
        if(user!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
            return user.getRol().toLowerCase()+"/Index.xhtml?faces-redirect=true";
        }else{
            return "login.xhtml?faces-redirect=true";
        }
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
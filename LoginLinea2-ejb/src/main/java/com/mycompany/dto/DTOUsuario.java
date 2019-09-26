/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 *
 * @author JR
 */

    public class DTOUsuario implements Serializable{
    
    private int id;
    private String Nombre;
    private String rol;
    private String usuario;
    private String contrasena;

    public DTOUsuario(String Nombre, String rol, String usuario, String contrasena) {
        this.Nombre = Nombre;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public DTOUsuario(int id, String Nombre, String rol, String usuario, String contrasena) {
        this.id = id;
        this.Nombre = Nombre;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

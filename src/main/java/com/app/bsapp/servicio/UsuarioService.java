/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.bsapp.servicio;

/**
 *
 * @author MARLON FIGUEROA
 */
public interface UsuarioService {

    public boolean checkHash(String usr, String pwd);
    public String getPasswordByUsr(String usr);

}

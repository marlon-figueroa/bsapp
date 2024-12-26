/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bsapp.servicio.impl;

import com.app.bsapp.servicio.UsuarioService;
import com.app.bsapp.util.SHA256Hashing;
import com.app.core.ConnectDB;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARLON FIGUEROA
 */
public class UsuarioServiceImpl implements UsuarioService {

    public UsuarioServiceImpl() {
        super();
    }

    @Override
    public boolean checkHash(String usr, String pwd) {
        boolean iguales = false;
        try {
            String output = this.getPasswordByUsr(usr);
            String hash = SHA256Hashing.HashWithBouncyCastle(pwd);
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.INFO, "checkHash()::{0}", hash);
            iguales = Objects.equals(hash, output);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iguales;
    }

    @Override
    public String getPasswordByUsr(String usr) {
        String pwd = "";
        try (PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT password FROM usuario WHERE username=?")) {
            ps.setString(1, usr);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pwd = rs.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pwd;
    }

}

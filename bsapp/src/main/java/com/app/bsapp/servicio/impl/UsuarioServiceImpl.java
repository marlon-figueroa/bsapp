/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bsapp.servicio.impl;

import com.app.bsapp.servicio.UsuarioService;
import com.app.bsapp.util.SHA256Hashing;
import com.app.core.dao.UsuarioRepository;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARLON FIGUEROA
 */
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository = null;

    public UsuarioServiceImpl() {
        super();
        this.repository = new UsuarioRepository();
    }

    @Override
    public boolean checkHash(String usr, String pwd) {
        boolean iguales = false;
        try {
            String output = repository.findByUsername(usr).getPassword();
            String hash = SHA256Hashing.HashWithBouncyCastle(pwd);
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.INFO, "checkHash()::{0}", hash);
            iguales = Objects.equals(hash, output);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iguales;
    }

}

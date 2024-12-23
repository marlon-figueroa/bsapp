/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bsapp.servicio.impl;

import com.app.bsapp.servicio.UsuarioService;
import com.app.bsapp.util.SHA256Hashing;
import java.security.NoSuchAlgorithmException;
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
    public boolean checkHash(String input) {
        boolean iguales = false;
        try {
            String output = ""; // TODO Obtener de base de datos
            String hash = SHA256Hashing.HashWithBouncyCastle(input);
            System.out.println("com.app.bsapp.servicio.impl.UsuarioServiceImpl.checkHash()::" + hash);
            iguales = Objects.equals(hash, output);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iguales;
    }

}

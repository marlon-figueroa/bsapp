/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.core.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author MARLON FIGUEROA
 */
@Data
@Builder
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByIntentos", query = "SELECT u FROM Usuario u WHERE u.intentos = :intentos"),
    @NamedQuery(name = "Usuario.findByFechaBloqueo", query = "SELECT u FROM Usuario u WHERE u.fechaBloqueo = :fechaBloqueo"),
    @NamedQuery(name = "Usuario.findByBloqueado", query = "SELECT u FROM Usuario u WHERE u.bloqueado = :bloqueado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "intentos")
    private int intentos;
    
    @Column(name = "fechaBloqueo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBloqueo;
    @Basic(optional = false)
    
    @Column(name = "bloqueado")
    private boolean bloqueado;

}

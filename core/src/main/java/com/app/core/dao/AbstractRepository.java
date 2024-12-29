/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.core.dao;

import com.core.util.Constantes;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MARLON FIGUEROA
 * @param <T>
 */
public abstract class AbstractRepository<T> implements Serializable {

    private EntityManagerFactory emf = null;

    public AbstractRepository() {
        this.emf = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);
    }

    public abstract EntityManager getEntityManager();

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.service.repositories;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andre
 */
public abstract class BasicRepository {
    
    private final EntityManager entityManager;
    public BasicRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager(){
        return getEntityManager();
    }

    /**
     *
     * @param <T>
     * @param classToCast
     * @param query
     * @param values
     * @return
     */
    protected <T> List<T> getPureList(Class<T> classToCast, String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    
    protected <T> T getPurePojo(Class<T> classToCast, String query, Object... value){
        Query qr = createQuery(query, value);
        return (T) qr.getSingleResult();
    }

    protected int executeCommand(String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }

    private Query createQuery(String query, Object... values) {
        Query qr = getEntityManager().createQuery(query);
        for (int i = 0; i < values.length; i++) {
            qr.setParameter(i, values[i]);
        }
        return qr;
    }

}

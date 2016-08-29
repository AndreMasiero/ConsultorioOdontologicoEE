package br.com.devmedia.consultorioee.service.repositories;

import java.io.Serializable;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Andre
 */
public abstract class BasicRepository {
    
    private static final long serialVersionUID = 1L;

    private final EntityManager entityManager;

    public BasicRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {
        return getEntityManager();
    }

    protected <T> T addEntity(Class<T> classToCast, Object entity) {
        getEntityManager().persist(entity);
        return (T) entity;
    }

    protected <T> T getEntity(Class<T> classToCast, Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }

    protected <T> T setEntity(Class<T> classToCast, Object entity) {
        Object updatedObj = getEntityManager().merge(entity);
        return (T) updatedObj;
    }
    
    protected void removeEntity(Object entity) {
        Object updateObj = getEntityManager().merge(entity);
        getEntityManager().remove(updateObj);
    }

    protected <T> List<T> getPureList(Class<T> classToCast, String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }

    protected <T> T getPurePojo(Class<T> classToCast, String query, Object... value) {
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

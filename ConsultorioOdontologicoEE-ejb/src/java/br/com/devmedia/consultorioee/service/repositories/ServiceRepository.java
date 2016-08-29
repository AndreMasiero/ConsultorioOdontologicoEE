
package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.enteties.Service;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author P9917236
 */
public class ServiceRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public ServiceRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Service addService(Service service) {
        return addEntity(Service.class, service);
    }

    public void removeService(Service service) {
        removeEntity(service);
    }

    public Service getService(int idOfSerice) {
        return getEntity(Service.class, idOfSerice);
    }

    public Service setService(Service service) {
        return setEntity(Service.class, service);
    }

    public List<Service> getServices() {
        return getPureList(Service.class, "select srv from Service srv");
    }

    public List<Service> getServicesByName(String name) {
        return getPureList(Service.class, "select srv from Service srv where srv.srvName like ?1", name + "%");
    }

}

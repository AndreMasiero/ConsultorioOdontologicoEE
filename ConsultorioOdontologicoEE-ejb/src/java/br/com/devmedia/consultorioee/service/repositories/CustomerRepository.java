
package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.enteties.Customer;
import javax.persistence.EntityManager;

/**
 *
 * @author Andre
 */
public class CustomerRepository extends BasicRepository{
    
    private static final long serialVersionUID = 1L;
    
    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Customer addCustomer(Customer customer){
        return addEntity(Customer.class, customer);
    }
    
    public Customer setCustomer(Customer customer){
        return setEntity(Customer.class, customer);
    }
    
    public void removeCustomer(Customer customer){
        removeEntity(customer);
    }
    
    public Customer getCustomer(Customer customer){
        return getEntity(Customer.class, customer);
    }
    
}

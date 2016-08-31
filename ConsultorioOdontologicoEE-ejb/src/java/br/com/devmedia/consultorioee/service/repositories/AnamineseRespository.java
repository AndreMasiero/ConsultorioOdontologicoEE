package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.enteties.Anaminese;
import br.com.devmedia.consultorioee.enteties.Customer;
import br.com.devmedia.consultorioee.enteties.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Masiero, André
 * @sinze 2016-08-31
 */
public class AnamineseRespository extends BasicRepository {

    public AnamineseRespository(EntityManager entityManager) {
        super(entityManager);
    }

    public Anaminese getAnaminese(int idOfAnaminese) {
        return getEntity(Anaminese.class, idOfAnaminese);
    }

    public Anaminese setAnaminese(Anaminese anaminese) {
        return setEntity(Anaminese.class, anaminese);
    }

    public Anaminese addAnaminese(Anaminese anaminese) {
        return addEntity(Anaminese.class, anaminese);
    }

    public void removeAnaminese(Anaminese anaminese) {
        removeEntity(Anaminese.class);
    }

    public List<Anaminese> getAnamineseByCustomer(Customer customer) {
        return getPureList(Anaminese.class, "select anan Anaminese anan where anan.ansCustomer.cusId = ?1", customer.getCusId());
    }

    public List<Anaminese> getAnamineseByOrcamento(Orcamento orc) {
        return getPureList(Anaminese.class, "select anan Anaminese anan where ana.ansOrcamento.orcId = ?1", orc.getOrcId());
    }
    

}

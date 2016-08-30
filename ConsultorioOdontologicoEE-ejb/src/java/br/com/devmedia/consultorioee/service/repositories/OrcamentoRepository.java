package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.enteties.Orcamento;
import br.com.devmedia.consultorioee.enteties.OrcamentoItem;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Masiero, André
 * @sinze 2016-08-30
 */
public class OrcamentoRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public OrcamentoRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Orcamento getOrcamento(int idOfOrcamento) {
        return getEntity(Orcamento.class, idOfOrcamento);
    }    

    public Orcamento setOrcamento(Orcamento orc) {
        return setEntity(Orcamento.class, orc);
    }
    
    public Orcamento addOrcamento(Orcamento orc) {
        return addEntity(Orcamento.class, orc);
    }

    public void removeOrcamento(Orcamento orc) {
        removeEntity(orc);
    }

    public void removeItem(OrcamentoItem ori) {
        removeEntity(ori);
    }

    public OrcamentoItem addItem(OrcamentoItem ori) {
        return addEntity(OrcamentoItem.class, ori);
    }

    public OrcamentoItem setItem(OrcamentoItem ori) {
        return setEntity(OrcamentoItem.class, ori);
    }

    public OrcamentoItem getItem(int idofOri) {
        return getEntity(OrcamentoItem.class, idofOri);
    }

    public List<Orcamento> getOrcamentos(int idOfCustomer) {
        return getPureList(Orcamento.class, "select orc from Orcamento orc where orc.orcCustomer.cusId = ?1", idOfCustomer);
    }

    public List<OrcamentoItem> getItens(int idOrcamento) {
        return getPureList(OrcamentoItem.class, "select ori from Orcamentoitem ori where ori.oriOrcamento.orcId = ?1", idOrcamento);
    }

}

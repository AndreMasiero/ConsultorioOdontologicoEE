package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.enteties.Parcela;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author P9917236
 */
public class FinanceRepository extends BasicRepository {

    private static final long serialVersionUID = 1L;

    public FinanceRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Parcela getParcela(int idParcela) {
        return getEntity(Parcela.class, idParcela);
    }

    public Parcela setParcela(Parcela par) {
        return setEntity(Parcela.class, par);
    }

    public Parcela addParcela(Parcela par) {
        return addEntity(Parcela.class, par);
    }

    public void removeParcela(Parcela par) {
        removeEntity(par);
    }

    public List<Parcela> getParcelasOfOrcamento(int idOfParcela) {
        return getPureList(Parcela.class, "select par Parcela par where par.parOrcamento.orcId = ?1", idOfParcela);
    }

    public List<Parcela> getParcelaEmAberto(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = 2?", idOfOrcamento, Boolean.FALSE);
    }

    public List<Parcela> getParcelaPagas(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = 2?", idOfOrcamento, Boolean.TRUE);
    }

    public List<Parcela> getParcelasOfCustomer(int idOfCustomer) {
        return getPureList(Parcela.class, "select par Parcela par where par.parOrcamento.orcCustomer = ?1", idOfCustomer);
    }

    public List<Parcela> getparcelasOfCustomerEmAberto(int idOfCustomer) {
        return getPureList(Parcela.class, "select par from Parcela par where par..parOrcamento.orcCustomer = ?1 and par.parPago = ?2", idOfCustomer, Boolean.FALSE);
    }

    public List<Parcela> getParcelasOfCustomerPagas(int idOfCustomer) {
        return getPureList(Parcela.class, "select par from Parcela par where par..parOrcamento.orcCustomer = ?1 and par.parPago = ?2", idOfCustomer, Boolean.TRUE);
    }

    public Parcela setPagamentoParcela(int idOfParcela) {
        Parcela par = getParcela(idOfParcela);
        par.setParPago(true);
        par = setParcela(par);
        return par;
    }

}

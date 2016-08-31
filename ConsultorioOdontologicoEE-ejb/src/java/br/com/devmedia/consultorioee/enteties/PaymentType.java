package br.com.devmedia.consultorioee.enteties;

/**
 *
 * @author P9917236
 */
public enum PaymentType {

    DINHEIRO("Dinheiro"), CREDITO("Credito"), DEBITO("Debito");

    private final String description;

    private PaymentType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

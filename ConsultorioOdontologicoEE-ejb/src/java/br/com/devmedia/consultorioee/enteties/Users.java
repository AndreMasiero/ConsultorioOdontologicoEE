/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.consultorioee.enteties;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andre
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "usu_id", nullable = false)
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_name", nullable = false, length = 255)
    private String usuName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_login", nullable = false, length = 255)
    private String usuLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "usu_password", nullable = false, length = 32)
    private String usuPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_administrator", nullable = false)
    private boolean usuAdministrator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_dentist", nullable = false)
    private boolean usuDentist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcDentist")
    private Collection<Orcamento> orcamentoCollection;

    public Users() {
    }

    public Users(Integer usuId) {
        this.usuId = usuId;
    }

    public Users(Integer usuId, String usuName, String usuLogin, String usuPassword, boolean usuAdministrator, boolean usuDentist) {
        this.usuId = usuId;
        this.usuName = usuName;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
        this.usuAdministrator = usuAdministrator;
        this.usuDentist = usuDentist;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuName() {
        return usuName;
    }

    public void setUsuName(String usuName) {
        this.usuName = usuName;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public boolean getUsuAdministrator() {
        return usuAdministrator;
    }

    public void setUsuAdministrator(boolean usuAdministrator) {
        this.usuAdministrator = usuAdministrator;
    }

    public boolean getUsuDentist() {
        return usuDentist;
    }

    public void setUsuDentist(boolean usuDentist) {
        this.usuDentist = usuDentist;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        //Aviso - este método não funciona no caso dos campos de ID não estão definidas
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.devmedia.consultorioee.enteties.Users[ usuId=" + usuId + " ]";
    }

}

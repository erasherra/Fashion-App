/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joona Ikonen
 */
@Entity
@Table(name = "budgetForm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetForm.findAll", query = "SELECT b FROM BudgetForm b")
    , @NamedQuery(name = "BudgetForm.findById", query = "SELECT b FROM BudgetForm b WHERE b.id = :id")
    , @NamedQuery(name = "BudgetForm.findByAmount", query = "SELECT b FROM BudgetForm b WHERE b.amount = :amount")})
public class BudgetForm implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    
    @JsonBackReference
    @OneToMany(mappedBy = "budgetformID")
    private Collection<Project> projectCollection;

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;*/
    @JsonManagedReference
    @JoinColumn(name = "themeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Themes themeID;
    
    @JsonManagedReference
    @JoinColumn(name = "formID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Form formID;
    
    
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bformID")
    private Collection<Cards> cardsCollection;

    public BudgetForm() {
    }

    public BudgetForm(Integer id) {
        this.id = id;
    }

    public BudgetForm(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Themes getThemeID() {
        return themeID;
    }

    public void setThemeID(Themes themeID) {
        this.themeID = themeID;
    }

    public Form getFormID() {
        return formID;
    }

    public void setFormID(Form formID) {
        this.formID = formID;
    }

    @XmlTransient
    public Collection<Cards> getCardsCollection() {
        return cardsCollection;
    }

    public void setCardsCollection(Collection<Cards> cardsCollection) {
        this.cardsCollection = cardsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetForm)) {
            return false;
        }
        BudgetForm other = (BudgetForm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BudgetForm[ id=" + id + " ]";
    }

    /* public BudgetForm(Integer id) {
        this.id = id;
    }

    public BudgetForm(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    /*  @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetForm)) {
            return false;
        }
        BudgetForm other = (BudgetForm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BudgetForm[ id=" + id + " ]";
    }
     */
}

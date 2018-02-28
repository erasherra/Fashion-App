/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Amir Ingher
 */
@Entity
@Table(name = "form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f")
    , @NamedQuery(name = "Form.findById", query = "SELECT f FROM Form f WHERE f.id = :id")
    , @NamedQuery(name = "Form.findByProduct", query = "SELECT f FROM Form f WHERE f.product = :product")
    , @NamedQuery(name = "Form.findByAmountStyles", query = "SELECT f FROM Form f WHERE f.amountStyles = :amountStyles")
    , @NamedQuery(name = "Form.findByAPrice", query = "SELECT f FROM Form f WHERE f.aPrice = :aPrice")
    , @NamedQuery(name = "Form.findByAAmountStyles", query = "SELECT f FROM Form f WHERE f.aAmountStyles = :aAmountStyles")
    , @NamedQuery(name = "Form.findByTSales", query = "SELECT f FROM Form f WHERE f.tSales = :tSales")
    , @NamedQuery(name = "Form.findByACover", query = "SELECT f FROM Form f WHERE f.aCover = :aCover")})
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "product")
    private String product;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amountStyles")
    private int amountStyles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aPrice")
    private int aPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aAmountStyles")
    private int aAmountStyles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tSales")
    private int tSales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aCover")
    private int aCover;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formID")
    private Collection<BudgetForm> budgetFormCollection;

    public Form() {
    }

    public Form(Integer id) {
        this.id = id;
    }

    public Form(Integer id, String product, int amountStyles, int aPrice, int aAmountStyles, int tSales, int aCover) {
        this.id = id;
        this.product = product;
        this.amountStyles = amountStyles;
        this.aPrice = aPrice;
        this.aAmountStyles = aAmountStyles;
        this.tSales = tSales;
        this.aCover = aCover;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmountStyles() {
        return amountStyles;
    }

    public void setAmountStyles(int amountStyles) {
        this.amountStyles = amountStyles;
    }

    public int getAPrice() {
        return aPrice;
    }

    public void setAPrice(int aPrice) {
        this.aPrice = aPrice;
    }

    public int getAAmountStyles() {
        return aAmountStyles;
    }

    public void setAAmountStyles(int aAmountStyles) {
        this.aAmountStyles = aAmountStyles;
    }

    public int getTSales() {
        return tSales;
    }

    public void setTSales(int tSales) {
        this.tSales = tSales;
    }

    public int getACover() {
        return aCover;
    }

    public void setACover(int aCover) {
        this.aCover = aCover;
    }

    @XmlTransient
    public Collection<BudgetForm> getBudgetFormCollection() {
        return budgetFormCollection;
    }

    public void setBudgetFormCollection(Collection<BudgetForm> budgetFormCollection) {
        this.budgetFormCollection = budgetFormCollection;
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
        if (!(object instanceof Form)) {
            return false;
        }
        Form other = (Form) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Form[ id=" + id + " ]";
    }
    
}

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
 * @author Joona Ikonen
 */
@Entity
@Table(name = "form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f")
    , @NamedQuery(name = "Form.findById", query = "SELECT f FROM Form f WHERE f.id = :id")
    , @NamedQuery(name = "Form.findByProduct", query = "SELECT f FROM Form f WHERE f.product = :product")
    , @NamedQuery(name = "Form.findByAmountStyles", query = "SELECT f FROM Form f WHERE f.amountStyles = :amountStyles")
    , @NamedQuery(name = "Form.findByAAmountStyles", query = "SELECT f FROM Form f WHERE f.aAmountStyles = :aAmountStyles")
    , @NamedQuery(name = "Form.findByAvgPrice", query = "SELECT f FROM Form f WHERE f.avgPrice = :avgPrice")
    , @NamedQuery(name = "Form.findByTotalSales", query = "SELECT f FROM Form f WHERE f.totalSales = :totalSales")
    , @NamedQuery(name = "Form.findByTotalCover", query = "SELECT f FROM Form f WHERE f.totalCover = :totalCover")})
public class Form implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "product")
    private String product;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amountStyles")
    private int amountStyles;
    @Column(name = "aAmountStyles")
    private Integer aAmountStyles;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avgPrice")
    private Float avgPrice;
    @Column(name = "totalSales")
    private Float totalSales;
    @Column(name = "totalCover")
    private Float totalCover;

    
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formID")
    private Collection<BudgetForm> budgetFormCollection;

    public Form() {
    }

    public Form(Integer id) {
        this.id = id;
    }

    public Form(Integer id, String product, int amountStyles, int aAmountStyles) {
        this.id = id;
        this.product = product;
        this.amountStyles = amountStyles;
        this.aAmountStyles = aAmountStyles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Float getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Float totalSales) {
        this.totalSales = totalSales;
    }

    public Float getTotalCover() {
        return totalCover;
    }

    public void setTotalCover(Float totalCover) {
        this.totalCover = totalCover;
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

    public Integer getAAmountStyles() {
        return aAmountStyles;
    }

    public void setAAmountStyles(Integer aAmountStyles) {
        this.aAmountStyles = aAmountStyles;
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

}

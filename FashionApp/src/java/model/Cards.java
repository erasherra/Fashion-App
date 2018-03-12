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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saritakhanal
 */
@Entity
@Table(name = "cards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cards.findAll", query = "SELECT c FROM Cards c")
    , @NamedQuery(name = "Cards.findById", query = "SELECT c FROM Cards c WHERE c.id = :id")
    , @NamedQuery(name = "Cards.findByComments", query = "SELECT c FROM Cards c WHERE c.comments = :comments")
    , @NamedQuery(name = "Cards.findByMaterialTotCost", query = "SELECT c FROM Cards c WHERE c.materialTotCost = :materialTotCost")
    , @NamedQuery(name = "Cards.findByExtFabCost", query = "SELECT c FROM Cards c WHERE c.extFabCost = :extFabCost")
    , @NamedQuery(name = "Cards.findBySubTotalCost", query = "SELECT c FROM Cards c WHERE c.subTotalCost = :subTotalCost")
    , @NamedQuery(name = "Cards.findByPurchasePrice", query = "SELECT c FROM Cards c WHERE c.purchasePrice = :purchasePrice")
    , @NamedQuery(name = "Cards.findBySellPrice", query = "SELECT c FROM Cards c WHERE c.sellPrice = :sellPrice")
    , @NamedQuery(name = "Cards.findByConsumerPrice", query = "SELECT c FROM Cards c WHERE c.consumerPrice = :consumerPrice")
    , @NamedQuery(name = "Cards.findByCoverPercent", query = "SELECT c FROM Cards c WHERE c.coverPercent = :coverPercent")})
public class Cards implements Serializable {

    @Size(max = 100)
    @Column(name = "Comments")
    private String comments;
    
     @JsonBackReference(value = "card-project")
    @OneToMany(mappedBy = "cardID")
    private Collection<Project> projectCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "materialTotCost")
    private Float materialTotCost;
    @Column(name = "extFabCost")
    private Float extFabCost;
    @Column(name = "subTotalCost")
    private Float subTotalCost;
    @Column(name = "purchasePrice")
    private Float purchasePrice;
    @Column(name = "sellPrice")
    private Float sellPrice;
    @Column(name = "consumerPrice")
    private Float consumerPrice;
    @Column(name = "coverPercent")
    private Float coverPercent;
    
    //@JsonManagedReference(value = "materialcost-card")
    @ManyToMany(mappedBy = "cardsCollection")
    private Collection<MaterialCost> materialCostCollection;
    
    //@JsonManagedReference(value = "subcost-card")//@JsonBackReference
    @ManyToMany(mappedBy = "cardsCollection")
    private Collection<Subcost> subcostCollection;
    
    //@JsonManagedReference(value = "budget-card")
    @JoinColumn(name = "bformID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BudgetForm bformID;

    public Cards() {
    }

    public Cards(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Float getMaterialTotCost() {
        return materialTotCost;
    }

    public void setMaterialTotCost(Float materialTotCost) {
        this.materialTotCost = materialTotCost;
    }

    public Float getExtFabCost() {
        return extFabCost;
    }

    public void setExtFabCost(Float extFabCost) {
        this.extFabCost = extFabCost;
    }

    public Float getSubTotalCost() {
        return subTotalCost;
    }

    public void setSubTotalCost(Float subTotalCost) {
        this.subTotalCost = subTotalCost;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Float getConsumerPrice() {
        return consumerPrice;
    }

    public void setConsumerPrice(Float consumerPrice) {
        this.consumerPrice = consumerPrice;
    }

    public Float getCoverPercent() {
        return coverPercent;
    }

    public void setCoverPercent(Float coverPercent) {
        this.coverPercent = coverPercent;
    }

    @XmlTransient
    public Collection<MaterialCost> getMaterialCostCollection() {
        return materialCostCollection;
    }

    public void setMaterialCostCollection(Collection<MaterialCost> materialCostCollection) {
        this.materialCostCollection = materialCostCollection;
    }

    @XmlTransient
    public Collection<Subcost> getSubcostCollection() {
        return subcostCollection;
    }

    public void setSubcostCollection(Collection<Subcost> subcostCollection) {
        this.subcostCollection = subcostCollection;
    }

    public BudgetForm getBformID() {
        return bformID;
    }

    public void setBformID(BudgetForm bformID) {
        this.bformID = bformID;
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
        if (!(object instanceof Cards)) {
            return false;
        }
        Cards other = (Cards) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cards[ id=" + id + " ]";
    }


    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
}

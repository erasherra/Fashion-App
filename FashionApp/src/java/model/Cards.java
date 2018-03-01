/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "cards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cards.findAll", query = "SELECT c FROM Cards c")
    , @NamedQuery(name = "Cards.findById", query = "SELECT c FROM Cards c WHERE c.id = :id")
    , @NamedQuery(name = "Cards.findByMTotCost", query = "SELECT c FROM Cards c WHERE c.mTotCost = :mTotCost")
    , @NamedQuery(name = "Cards.findByExtraFCost", query = "SELECT c FROM Cards c WHERE c.extraFCost = :extraFCost")
    , @NamedQuery(name = "Cards.findBySubTotCost", query = "SELECT c FROM Cards c WHERE c.subTotCost = :subTotCost")
    , @NamedQuery(name = "Cards.findByPTotCost", query = "SELECT c FROM Cards c WHERE c.pTotCost = :pTotCost")
    , @NamedQuery(name = "Cards.findBySTotPrice", query = "SELECT c FROM Cards c WHERE c.sTotPrice = :sTotPrice")
    , @NamedQuery(name = "Cards.findByCTotPrice", query = "SELECT c FROM Cards c WHERE c.cTotPrice = :cTotPrice")
    , @NamedQuery(name = "Cards.findByComments", query = "SELECT c FROM Cards c WHERE c.comments = :comments")})
public class Cards implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "mTotCost")
    private int mTotCost;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "extraFCost")
    private int extraFCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subTotCost")
    private int subTotCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pTotCost")
    private int pTotCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sTotPrice")
    private int sTotPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cTotPrice")
    private int cTotPrice;
    @Size(max = 100)
    @Column(name = "Comments")
    private String comments;
    @ManyToMany(mappedBy = "cardsCollection")
    private Collection<MaterialCost> materialCostCollection;
    @ManyToMany(mappedBy = "cardsCollection")
    private Collection<Subcost> subcostCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "bformID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BudgetForm bformID;

    public Cards() {
    }

    public Cards(Integer id) {
        this.id = id;
    }

    public Cards(Integer id, int mTotCost, int extraFCost, int subTotCost, int pTotCost, int sTotPrice, int cTotPrice) {
        this.id = id;
        this.mTotCost = mTotCost;
        this.extraFCost = extraFCost;
        this.subTotCost = subTotCost;
        this.pTotCost = pTotCost;
        this.sTotPrice = sTotPrice;
        this.cTotPrice = cTotPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getMTotCost() {
        return mTotCost;
    }

    public void setMTotCost(int mTotCost) {
        this.mTotCost = mTotCost;
    }

    public int getExtraFCost() {
        return extraFCost;
    }

    public void setExtraFCost(int extraFCost) {
        this.extraFCost = extraFCost;
    }

    public int getSubTotCost() {
        return subTotCost;
    }

    public void setSubTotCost(int subTotCost) {
        this.subTotCost = subTotCost;
    }

    public int getPTotCost() {
        return pTotCost;
    }

    public void setPTotCost(int pTotCost) {
        this.pTotCost = pTotCost;
    }

    public int getSTotPrice() {
        return sTotPrice;
    }

    public void setSTotPrice(int sTotPrice) {
        this.sTotPrice = sTotPrice;
    }

    public int getCTotPrice() {
        return cTotPrice;
    }

    public void setCTotPrice(int cTotPrice) {
        this.cTotPrice = cTotPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
}

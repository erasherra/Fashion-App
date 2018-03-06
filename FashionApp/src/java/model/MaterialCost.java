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
import javax.persistence.JoinTable;
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
 * @author Joona Ikonen
 */
@Entity
@Table(name = "materialCost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialCost.findAll", query = "SELECT m FROM MaterialCost m")
    , @NamedQuery(name = "MaterialCost.findById", query = "SELECT m FROM MaterialCost m WHERE m.id = :id")
    , @NamedQuery(name = "MaterialCost.findByArticle", query = "SELECT m FROM MaterialCost m WHERE m.article = :article")
    , @NamedQuery(name = "MaterialCost.findByCMeter", query = "SELECT m FROM MaterialCost m WHERE m.cMeter = :cMeter")
    , @NamedQuery(name = "MaterialCost.findByUPrice", query = "SELECT m FROM MaterialCost m WHERE m.uPrice = :uPrice")
    , @NamedQuery(name = "MaterialCost.findByTCosts", query = "SELECT m FROM MaterialCost m WHERE m.tCosts = :tCosts")
    , @NamedQuery(name = "MaterialCost.findByFreight", query = "SELECT m FROM MaterialCost m WHERE m.freight = :freight")})
public class MaterialCost implements Serializable {

    @Size(max = 100)
    @Column(name = "article")
    private String article;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cMeter")
    private float cMeter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uPrice")
    private float uPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tCosts")
    private float tCosts;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "freight")
    private Float freight;
    @JoinTable(name = "materialHolder", joinColumns = {
        @JoinColumn(name = "mCostID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "cardID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Cards> cardsCollection;
    @JoinColumn(name = "materialID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Materials materialID;

    public MaterialCost() {
    }

    public MaterialCost(Integer id) {
        this.id = id;
    }

    public MaterialCost(Integer id, float cMeter, float uPrice, float tCosts) {
        this.id = id;
        this.cMeter = cMeter;
        this.uPrice = uPrice;
        this.tCosts = tCosts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    @XmlTransient
    public Collection<Cards> getCardsCollection() {
        return cardsCollection;
    }

    public void setCardsCollection(Collection<Cards> cardsCollection) {
        this.cardsCollection = cardsCollection;
    }

    public Materials getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Materials materialID) {
        this.materialID = materialID;
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
        if (!(object instanceof MaterialCost)) {
            return false;
        }
        MaterialCost other = (MaterialCost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MaterialCost[ id=" + id + " ]";
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public float getCMeter() {
        return cMeter;
    }

    public void setCMeter(float cMeter) {
        this.cMeter = cMeter;
    }

    public float getUPrice() {
        return uPrice;
    }

    public void setUPrice(float uPrice) {
        this.uPrice = uPrice;
    }

    public float getTCosts() {
        return tCosts;
    }

    public void setTCosts(float tCosts) {
        this.tCosts = tCosts;
    }
    
}

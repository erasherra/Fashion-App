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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saritakhanal
 */
@Entity
@Table(name = "subcost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcost.findAll", query = "SELECT s FROM Subcost s")
    , @NamedQuery(name = "Subcost.findById", query = "SELECT s FROM Subcost s WHERE s.id = :id")
    , @NamedQuery(name = "Subcost.findByUnitCost", query = "SELECT s FROM Subcost s WHERE s.unitCost = :unitCost")})
public class Subcost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitCost")
    private float unitCost;
    @JoinTable(name = "subholder", joinColumns = {
        @JoinColumn(name = "subCostID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "cardID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Cards> cardsCollection;
    @JoinColumn(name = "typeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SubConCostTypes typeID;

    public Subcost() {
    }

    public Subcost(Integer id) {
        this.id = id;
    }

    public Subcost(Integer id, float unitCost) {
        this.id = id;
        this.unitCost = unitCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    @XmlTransient
    public Collection<Cards> getCardsCollection() {
        return cardsCollection;
    }

    public void setCardsCollection(Collection<Cards> cardsCollection) {
        this.cardsCollection = cardsCollection;
    }

    public SubConCostTypes getTypeID() {
        return typeID;
    }

    public void setTypeID(SubConCostTypes typeID) {
        this.typeID = typeID;
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
        if (!(object instanceof Subcost)) {
            return false;
        }
        Subcost other = (Subcost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Subcost[ id=" + id + " ]";
    }
    
}

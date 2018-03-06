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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saritakhanal
 */
@Entity
@Table(name = "subConCostTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubConCostTypes.findAll", query = "SELECT s FROM SubConCostTypes s")
    , @NamedQuery(name = "SubConCostTypes.findById", query = "SELECT s FROM SubConCostTypes s WHERE s.id = :id")
    , @NamedQuery(name = "SubConCostTypes.findByName", query = "SELECT s FROM SubConCostTypes s WHERE s.name = :name")})
public class SubConCostTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
    private Collection<Subcost> subcostCollection;

    public SubConCostTypes() {
    }

    public SubConCostTypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Subcost> getSubcostCollection() {
        return subcostCollection;
    }

    public void setSubcostCollection(Collection<Subcost> subcostCollection) {
        this.subcostCollection = subcostCollection;
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
        if (!(object instanceof SubConCostTypes)) {
            return false;
        }
        SubConCostTypes other = (SubConCostTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SubConCostTypes[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amir Ingher
 */
@Entity
@Table(name = "collectionholder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collectionholder.findAll", query = "SELECT c FROM Collectionholder c")
    , @NamedQuery(name = "Collectionholder.findById", query = "SELECT c FROM Collectionholder c WHERE c.id = :id")
    , @NamedQuery(name = "Collectionholder.findByCollectionID", query = "SELECT c FROM Collectionholder c WHERE c.collectionID = :collectionID")})
public class Collectionholder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "collectionID", referencedColumnName = "id")
    @ManyToOne
    @JsonBackReference(value = "collection-holder")
    private Collection collectionID;
    //@JsonBackReference(value = "collection-holder")
    //@JsonManagedReference(value = "collection-holder")
    @JoinColumn(name = "projectID", referencedColumnName = "ID")
    @ManyToOne
    private Project projectID;

    public Collectionholder() {
    }

    public Collectionholder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Collection collectionID) {
        this.collectionID = collectionID;
    }

    public Project getProjectID() {
        return projectID;
    }

    public void setProjectID(Project projectID) {
        this.projectID = projectID;
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
        if (!(object instanceof Collectionholder)) {
            return false;
        }
        Collectionholder other = (Collectionholder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Collectionholder[ id=" + id + " ]";
    }
    
}

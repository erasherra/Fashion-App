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
import javax.persistence.Lob;
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
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id")
    , @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name")})
public class Project implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @JsonBackReference(value = "collection-holder")
    @OneToMany(mappedBy = "projectID")
    private Collection<Collectionholder> collectionholderCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    //@JsonManagedReference(value = "card-project")
    @JoinColumn(name = "cardID", referencedColumnName = "ID")
    @ManyToOne
    private Cards cardID;
    //@JsonManagedReference(value = "color-project")
    @JoinColumn(name = "colorId", referencedColumnName = "colorID")
    @ManyToOne
    private ColorDB colorId;
    //@JsonManagedReference(value = "budget-project")
    @JoinColumn(name = "BudgetformID", referencedColumnName = "ID")
    @ManyToOne
    private BudgetForm budgetformID;

    public Project() {
    }

    public Project(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cards getCardID() {
        return cardID;
    }

    public void setCardID(Cards cardID) {
        this.cardID = cardID;
    }

    public ColorDB getColorId() {
        return colorId;
    }

    public void setColorId(ColorDB colorId) {
        this.colorId = colorId;
    }

    public BudgetForm getBudgetformID() {
        return budgetformID;
    }

    public void setBudgetformID(BudgetForm budgetformID) {
        this.budgetformID = budgetformID;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Project[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Collectionholder> getCollectionholderCollection() {
        return collectionholderCollection;
    }

    public void setCollectionholderCollection(Collection<Collectionholder> collectionholderCollection) {
        this.collectionholderCollection = collectionholderCollection;
    }

}

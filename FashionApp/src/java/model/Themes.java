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
import javax.persistence.ManyToMany;
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
@Table(name = "themes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Themes.findAll", query = "SELECT t FROM Themes t")
    , @NamedQuery(name = "Themes.findById", query = "SELECT t FROM Themes t WHERE t.id = :id")
    , @NamedQuery(name = "Themes.findByTheme", query = "SELECT t FROM Themes t WHERE t.theme = :theme")})
public class Themes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "theme")
    private String theme;
    @ManyToMany(mappedBy = "themesCollection")
    private Collection<ColorDB> colorDBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "themeID")
    private Collection<BudgetForm> budgetFormCollection;

    public Themes() {
    }

    public Themes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @XmlTransient
    public Collection<ColorDB> getColorDBCollection() {
        return colorDBCollection;
    }

    public void setColorDBCollection(Collection<ColorDB> colorDBCollection) {
        this.colorDBCollection = colorDBCollection;
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
        if (!(object instanceof Themes)) {
            return false;
        }
        Themes other = (Themes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Themes[ id=" + id + " ]";
    }
    
}

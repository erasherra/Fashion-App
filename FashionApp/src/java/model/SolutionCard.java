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
 * @author Joel Vornanen
 */
@Entity
@Table(name = "solutionCard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolutionCard.findAll", query = "SELECT s FROM SolutionCard s")
    , @NamedQuery(name = "SolutionCard.findById", query = "SELECT s FROM SolutionCard s WHERE s.id = :id")
    , @NamedQuery(name = "SolutionCard.findByName", query = "SELECT s FROM SolutionCard s WHERE s.name = :name")
    , @NamedQuery(name = "SolutionCard.findByComment", query = "SELECT s FROM SolutionCard s WHERE s.comment = :comment")
    , @NamedQuery(name = "SolutionCard.findByArticlecode", query = "SELECT s FROM SolutionCard s WHERE s.articlecode = :articlecode")
    , @NamedQuery(name = "SolutionCard.findByAmount", query = "SELECT s FROM SolutionCard s WHERE s.amount = :amount")
    , @NamedQuery(name = "SolutionCard.findByPprice", query = "SELECT s FROM SolutionCard s WHERE s.pprice = :pprice")
    , @NamedQuery(name = "SolutionCard.findBySprice", query = "SELECT s FROM SolutionCard s WHERE s.sprice = :sprice")
    , @NamedQuery(name = "SolutionCard.findByConprice", query = "SELECT s FROM SolutionCard s WHERE s.conprice = :conprice")
    , @NamedQuery(name = "SolutionCard.findByMaterials", query = "SELECT s FROM SolutionCard s WHERE s.materials = :materials")
    , @NamedQuery(name = "SolutionCard.findBySizes", query = "SELECT s FROM SolutionCard s WHERE s.sizes = :sizes")
    , @NamedQuery(name = "SolutionCard.findByImg", query = "SELECT s FROM SolutionCard s WHERE s.img = :img")})
public class SolutionCard implements Serializable {

    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 1000)
    @Column(name = "comment")
    private String comment;
    @Size(max = 50)
    @Column(name = "articlecode")
    private String articlecode;
    @Size(max = 100)
    @Column(name = "materials")
    private String materials;
    @Size(max = 30)
    @Column(name = "sizes")
    private String sizes;
    @Size(max = 50)
    @Column(name = "img")
    private String img;
    @Size(max = 50)
    @Column(name = "colors")
    private String colors;
    @OneToMany(mappedBy = "solutioncardID")
    private Collection<Solutioncardholder> solutioncardholderCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @Column(name = "amount")
    private Integer amount;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pprice")
    private Float pprice;
    
    @Column(name = "sprice")
    private Float sprice;
    
    @Column(name = "conprice")
    private Float conprice;
    
    

    public SolutionCard() {
    }

    public SolutionCard(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPprice() {
        return pprice;
    }

    public void setPprice(Float pprice) {
        this.pprice = pprice;
    }

    public Float getSprice() {
        return sprice;
    }

    public void setSprice(Float sprice) {
        this.sprice = sprice;
    }

    public Float getConprice() {
        return conprice;
    }

    public void setConprice(Float conprice) {
        this.conprice = conprice;
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
        if (!(object instanceof SolutionCard)) {
            return false;
        }
        SolutionCard other = (SolutionCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SolutionCard[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getArticlecode() {
        return articlecode;
    }

    public void setArticlecode(String articlecode) {
        this.articlecode = articlecode;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    @XmlTransient
    public Collection<Solutioncardholder> getSolutioncardholderCollection() {
        return solutioncardholderCollection;
    }

    public void setSolutioncardholderCollection(Collection<Solutioncardholder> solutioncardholderCollection) {
        this.solutioncardholderCollection = solutioncardholderCollection;
    }
    
}

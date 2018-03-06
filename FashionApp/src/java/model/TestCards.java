/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel Vornanen
 */
@Entity
@Table(name = "testCards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestCards.findAll", query = "SELECT t FROM TestCards t")
    , @NamedQuery(name = "TestCards.findById", query = "SELECT t FROM TestCards t WHERE t.id = :id")
    , @NamedQuery(name = "TestCards.findByAmount", query = "SELECT t FROM TestCards t WHERE t.amount = :amount")
    , @NamedQuery(name = "TestCards.findByPPrice", query = "SELECT t FROM TestCards t WHERE t.pPrice = :pPrice")
    , @NamedQuery(name = "TestCards.findBySPrice", query = "SELECT t FROM TestCards t WHERE t.sPrice = :sPrice")
    , @NamedQuery(name = "TestCards.findByConPrice", query = "SELECT t FROM TestCards t WHERE t.conPrice = :conPrice")
    , @NamedQuery(name = "TestCards.findByCovPrice", query = "SELECT t FROM TestCards t WHERE t.covPrice = :covPrice")})
public class TestCards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Lob
    @Size(max = 65535)
    @Column(name = "articleCode")
    private String articleCode;
    @Column(name = "amount")
    private Integer amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pPrice")
    private Float pPrice;
    @Column(name = "sPrice")
    private Float sPrice;
    @Column(name = "conPrice")
    private Float conPrice;
    @Column(name = "covPrice")
    private Float covPrice;
    @Lob
    @Size(max = 65535)
    @Column(name = "materials")
    private String materials;
    @Lob
    @Size(max = 65535)
    @Column(name = "sizes")
    private String sizes;
    @Lob
    @Size(max = 65535)
    @Column(name = "img")
    private String img;

    public TestCards() {
    }

    public TestCards(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPPrice() {
        return pPrice;
    }

    public void setPPrice(Float pPrice) {
        this.pPrice = pPrice;
    }

    public Float getSPrice() {
        return sPrice;
    }

    public void setSPrice(Float sPrice) {
        this.sPrice = sPrice;
    }

    public Float getConPrice() {
        return conPrice;
    }

    public void setConPrice(Float conPrice) {
        this.conPrice = conPrice;
    }

    public Float getCovPrice() {
        return covPrice;
    }

    public void setCovPrice(Float covPrice) {
        this.covPrice = covPrice;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestCards)) {
            return false;
        }
        TestCards other = (TestCards) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TestCards[ id=" + id + " ]";
    }
    
}

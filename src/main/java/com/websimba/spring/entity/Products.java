package com.websimba.spring.entity;

import org.hibernate.type.TextType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products", schema = "websimba")
public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "alias")
    private String alias;
    @Basic
    @Column(name = "parent")
    private int parent;
    @Basic
    @Column(name = "discription")
    private String discription;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "descriptions")
    private String descriptions;
    @Basic
    @Column(name = "keywords")
    private String keywords;
    @Basic
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "hosts")
    private Integer hosts;
    @Basic
    @Column(name = "views")
    private Integer views;
    @Transient
    private String strDate;

    public Products() {
    }

    public Products(int id, String title, String alias, int parent, String discription, String content, String img, int price, String descriptions, String keywords, Date date, Integer hosts, Integer views,String strDate) {
        super();
        this.id = id;
        this.title = title;
        this.alias = alias;
        this.parent = parent;
        this.discription = discription;
        this.content = content;
        this.img = img;
        this.price = price;
        this.descriptions = descriptions;
        this.keywords = keywords;
        this.date = date;
        this.hosts = hosts;
        this.views = views;
        this.strDate = strDate;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHosts() {
        return hosts;
    }
    public void setHosts(Integer hosts) {
        this.hosts = hosts;
    }

    public Integer getViews() {
        return views;
    }
    public void setViews(Integer views) {
        this.views = views;
    }

    public String getStrDate() {
        return strDate;
    }
    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }
}

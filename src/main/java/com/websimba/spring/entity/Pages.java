package com.websimba.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "pages", schema = "websimba")
public class Pages {
    @Id
    @Column(name = "page_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int pageId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "alias")
    private String alias;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "keywords")
    private String keywords;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "position")
    private int position;

    public Pages() {
    }
    public Pages(int pageId, String title, String alias, String description, String keywords, String content, String img, int position) {
        super();
        this.pageId = pageId;
        this.title = title;
        this.alias = alias;
        this.description = description;
        this.keywords = keywords;
        this.content = content;
        this.img = img;
        this.position = position;
    }


    public int getPageId() {
        return pageId;
    }
    public void setPageId(int pageId) {
        this.pageId = pageId;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

}

package cn.edu.bistu.cs.se.model;

import java.util.Date;

public class bookinfo {
    private Integer id;

    private String name;

    private String author;

    private String binfo;

    private String auinfo;

    private Integer collects;

    private Double rewards;

    private Byte publish;

    private Integer words;

    private Date update;

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
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getBinfo() {
        return binfo;
    }

    public void setBinfo(String binfo) {
        this.binfo = binfo == null ? null : binfo.trim();
    }

    public String getAuinfo() {
        return auinfo;
    }

    public void setAuinfo(String auinfo) {
        this.auinfo = auinfo == null ? null : auinfo.trim();
    }

    public Integer getCollects() {
        return collects;
    }

    public void setCollects(Integer collects) {
        this.collects = collects;
    }

    public Double getRewards() {
        return rewards;
    }

    public void setRewards(Double rewards) {
        this.rewards = rewards;
    }

    public Byte getPublish() {
        return publish;
    }

    public void setPublish(Byte publish) {
        this.publish = publish;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

	@Override
	public String toString() {
		return "bookinfo [id=" + id + ", name=" + name + ", author=" + author + ", binfo=" + binfo + ", auinfo="
				+ auinfo + ", collects=" + collects + ", rewards=" + rewards + ", publish=" + publish + ", words="
				+ words + ", update=" + update + "]";
	}
}
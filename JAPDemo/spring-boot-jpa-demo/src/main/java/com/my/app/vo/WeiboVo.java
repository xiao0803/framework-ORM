package com.my.app.vo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.stream.events.Comment;

public class WeiboVo {

    public WeiboVo() {
    }

    private long weiboId;
    private String weiboText;
    private Date createDate;

    public long getWeiboId() {
		return weiboId;
	}

	public void setWeiboId(long weiboId) {
		this.weiboId = weiboId;
	}

	public String getWeiboText() {
		return weiboText;
	}

	public void setWeiboText(String weiboText) {
		this.weiboText = weiboText;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "WeiboVo [weiboId=" + weiboId + ", weiboText=" + weiboText + ", createDate=" + createDate + "]";
	}

}
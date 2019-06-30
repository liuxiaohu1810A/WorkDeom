package com.example.week3.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class NewslistBean {
    /**
     * ctime : 2019-06-09
     * title : 137平的现代风四居室，用隐形门把卧室藏起来
     * description : 文艺家居控
     * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/wff5KeMnucZa7WdGia8IXjWibzrDyicLKo7iae34ngRCtARwwJ8wWZhIGEGWkUaIzvM7iaKNcHWCLAxlLiaQ2upDHDug/0?wx_fmt=jpeg
     * url : https://mp.weixin.qq.com/s?src=11&amp;timestamp=1560072608&amp;ver=1657&amp;signature=TZvpgjHYV-sAnN5exIB6QZMt2KPdPzB*vYz4ec56CFMP01fyKqmkQ1TpgTERKpmZdgBtdRyXBvn4jBuTNSvZTVq5GnkZJBQyYOm1tT*3GeLHbqujpAL-b0nuxUqtsmz1&amp;new=1
     */
    @Id
    @Property(nameInDb = "Iid")
    private Long id;
    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;
    @Generated(hash = 1402622097)
    public NewslistBean(Long id, String ctime, String title, String description, String picUrl, String url) {
        this.id = id;
        this.ctime = ctime;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }
    @Generated(hash = 923354944)
    public NewslistBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCtime() {
        return this.ctime;
    }
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPicUrl() {
        return this.picUrl;
    }
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


}

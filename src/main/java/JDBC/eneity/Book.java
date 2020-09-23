package JDBC.eneity;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */

public class Book {
    private int id;
    private String title;
    private String author;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date publicDate;
    private String publisher;
    private String isbn;
    private BigDecimal price;
    private String picture;
    private int cid;

    public Book(int id, String title, String author, Date publicDate, String publisher, String isbn, BigDecimal price, String picture, int cid) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicDate = publicDate;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
        this.picture = picture;
        this.cid = cid;
    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicDate=" + publicDate +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", cid=" + cid +
                '}';
    }
}

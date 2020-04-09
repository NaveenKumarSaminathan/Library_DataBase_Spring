package com.example.WebApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private int bid;
    private String bname;
    private String author;
    private String category;
    private String availability;

    public Book() {}
    public Book(int bid, String bname, String author, String category, String availability) {
        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.category = category;
        this.availability = availability;
    }


    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}

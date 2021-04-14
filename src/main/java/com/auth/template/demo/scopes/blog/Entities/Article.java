package com.auth.template.demo.scopes.blog.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private long id;

    @Column
    @NotBlank
    @NotEmpty
    @NotNull
    private String title;

    @Column
    @NotBlank
    @NotEmpty
    @NotNull
    private String subtitle;

    @Column
    @NotBlank
    @NotEmpty
    @NotNull
    private String image;

    @Column(length=10485760)
    @NotBlank
    @NotEmpty
    @NotNull
    private String text;

    @Column
    @NotBlank
    @NotEmpty
    @NotNull
    private String author;


    @Column
    @NotBlank
    @NotEmpty
    @NotNull
    private Long note;


    @Column
    @Fetch(FetchMode.JOIN)
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    private LocalDate date;

    @SuppressWarnings("unused")
    public Article() {
    }

    public Article(String title, String subtitle, String image,  String text , String author) {
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
        this.text = text;
        this.note = 0L;
        this.author = author;
        this.date = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getNote() {
        return note;
    }

    public void setNote(Long note) {
        this.note = note;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                ", note=" + note +
                ", author=" + author +
                ", date=" + date +
                '}';
    }
}

package com.tsswebapps.mylibrary.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 4, nullable = false)
    private String yearOfPublication;

    private int pages;

    private String image;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Library> libraries = new LinkedHashSet<>();

    public Book(){}

    public Book(UUID id, String name, String author, String yearOfPublication, int pages, String image, Set<Library> libraries) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
        this.image = image;
        this.libraries = libraries;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public int getPages() {
        return pages;
    }

    public String getImage() {
        return image;
    }

    public Set<Library> getLibraries() {
        return Collections.unmodifiableSet(libraries);
    }

    public void setLibrary(Library library){
        this.libraries.add(library);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author);
    }
}

package com.tsswebapps.mylibrary.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "library_")
    private Set<Book> books = new LinkedHashSet<>();

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(this.books);
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library(){}

    public Library(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

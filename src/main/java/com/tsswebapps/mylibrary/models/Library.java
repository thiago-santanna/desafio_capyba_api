package com.tsswebapps.mylibrary.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Library {
    @Id
    @GeneratedValue()
    private UUID id;

// Aqui seria uma realação unidirecional onde apenas a entendidade library poderia ter informações da relacao
//    @ManyToMany
//    @JoinTable(name="library_books", joinColumns=
//            {@JoinColumn(name="library_id")}, inverseJoinColumns=
//            {@JoinColumn(name="book_id")})
    @ManyToMany(mappedBy = "libraries", fetch = FetchType.EAGER)
    private Set<Book> books = new LinkedHashSet<>();

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(this.books);
    }

    public void setBook(Book book){
        this.books.add(book);
    }

    public Library(){}

    public Library(UUID id, Set<Book> books) {
        this.id = id;
        this.books = books;
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

package com.tsswebapps.mylibrary.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String token;

    public Token(UUID id, String token) {
        this.id = id;
        this.token = token;
    }

    public Token(){}

    public UUID getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return Objects.equals(id, token1.id) && Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token);
    }
}

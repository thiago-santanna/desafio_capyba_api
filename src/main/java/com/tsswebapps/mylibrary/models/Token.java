package com.tsswebapps.mylibrary.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Token {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String token;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Token(){}

    public Token(UUID id, String token, User user) {
        this.id = id;
        this.token = token;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
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

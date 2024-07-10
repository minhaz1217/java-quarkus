package com.minhazul;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;

import java.util.List;

public class Company extends ReactivePanacheMongoEntity {
    private String name;
    private List<String> emails;

    public Company() {

    }

    public Company(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "{" +
                "'name':'" + name + '\'' +
                ", 'emails':[" + String.join(",", emails.stream().map(email -> "'" + email + "'").toList()) + "]" +
                '}';
    }
}

package com.minhazul;


import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

import java.util.List;

public class Company extends ReactivePanacheMongoEntity {
    private String name;
    private Address address;

    public Company() {

    }

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}

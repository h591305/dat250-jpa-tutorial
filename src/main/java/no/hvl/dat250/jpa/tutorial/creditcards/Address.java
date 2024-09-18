package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;

    @ManyToMany
    private Set<Customer> owners = new HashSet<>();

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Customer> getOwners() {
       return owners;
    }

    public void setOwners(Set<Customer> owners) {
        this.owners = owners;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

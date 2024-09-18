package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany
    private List<CreditCard> creditCards = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}

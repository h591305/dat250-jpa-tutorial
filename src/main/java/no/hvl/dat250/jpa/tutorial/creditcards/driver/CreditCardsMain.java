package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {

     Customer customer = new Customer();
     Address address = new Address();
     CreditCard creditCard1 = new CreditCard();
     CreditCard creditCard2 = new CreditCard();
     Pincode pincode = new Pincode();
     Bank bank = new Bank();


     customer.setName("Max Mustermann");
     customer.setCreditCards(new ArrayList<>(Arrays.asList(creditCard1, creditCard2)));
     customer.setAddresses(new ArrayList<>(Arrays.asList(address)));

     address.setStreet("Inndalsveien");
     address.setNumber(28);
     address.setOwners(Set.of(customer));



     creditCard1.setNumber(12345);
     creditCard1.setBalance(-5000);
     creditCard1.setCreditLimit(-10000);
     creditCard1.setPincode(pincode);
     creditCard1.setOwningBank(bank);

     creditCard2.setNumber(123);
     creditCard2.setBalance(1);
     creditCard2.setCreditLimit(2000);
     creditCard2.setPincode(pincode);
     creditCard2.setOwningBank(bank);

     pincode.setPincode("123");
     pincode.setCount(1);


     bank.setName("Pengebank");
     bank.setOwnedCards(Set.of(creditCard1, creditCard2));

     em.persist(customer);
     em.persist(address);
     em.persist(creditCard1);
     em.persist(creditCard2);
     em.persist(pincode);
     em.persist(bank);





  }
}

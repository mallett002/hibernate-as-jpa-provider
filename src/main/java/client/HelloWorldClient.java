package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Message;

public class HelloWorldClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction txn = entityManager.getTransaction();

        try {
            txn.begin();

            Message msg = new Message("Hello World with Hiberante as JPA Provider");
            entityManager.persist(msg);

            txn.commit();
        } catch(Exception ex) {
            if (txn != null) txn.rollback();
            ex.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }
}

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

        // For our examples:
        txn.begin();

        Message message1 = entityManager.find(Message.class, 7L); // run sql query
        Message message2 = entityManager.find(Message.class, 7L); // Does not run sql query ( saved in cache )

        txn.commit();
        entityManager.close();

        // Use a try catch
//        try {
//            txn.begin();
//
//            Message msg = new Message("Hello World with Hiberante as JPA Provider");
//            entityManager.persist(msg);
//
//            txn.commit();
//        } catch(Exception ex) {
//            if (txn != null) txn.rollback();
//            ex.printStackTrace();
//        } finally {
//            if (entityManager != null) entityManager.close();
//        }
    }
}


package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityTester {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer customer1 = new Customer("Peter", "Wall");
        Customer customer2 = new Customer("Hans", "Jørgensen");
        Customer customer3 = new Customer("Kasper", "Lundsgård");
        try {
            em.getTransaction().begin();
            em.persist(customer1);
            em.persist(customer2);
            em.persist(customer3);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
            System.out.println(customer1.getId());
            System.out.println(customer2.getId());
            System.out.println(customer3.getId());

        } finally {
            em.close();
        }
    }
    
}

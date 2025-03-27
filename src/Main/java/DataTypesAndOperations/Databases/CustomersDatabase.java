package DataTypesAndOperations.Databases;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomersDatabase extends Database {

    public boolean isEmpty() {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        Query query = entityManager.createQuery("SELECT COUNT(c) FROM Customer c");
        return  super.isEmpty(entityManager, query);
    }

    public List<Customer> getData() {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Query query = entityManager.createQuery("SELECT c FROM Customer c");
        List<Customer> customerList = new ArrayList<>();
        try {
            transaction.begin();
            customerList = query.getResultList();
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("getData method of CustomerDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
        return customerList;
    }

    public void removeCustomer (Customer customer)  {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String stringQuery = "DELETE FROM Customer c WHERE c.name = :name";
        Query query = entityManager.createQuery(stringQuery);
        query.setParameter("name", customer.getName());
        try {
            transaction.begin();
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("removeCustomer method of CustomerDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }

    public void addCustomer(Customer customer) {
        super.addEntity(customer);
    }

}

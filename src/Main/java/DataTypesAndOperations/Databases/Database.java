package DataTypesAndOperations.Databases;

import MainPackage.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

abstract class Database {

   boolean isEmpty (EntityManager entityManager, Query query) {
       try {
           Long result = (Long) query.getSingleResult();
           return result == 0;
       }
       catch (Exception e) {
           System.out.println("isEmpty method of Database class caught exception!");
           e.printStackTrace();
       }
       finally {
           entityManager.close();
       }
       return true;
    }

    abstract List<?> getData();

    public <T> void addEntity(T entity) {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("addEntity method of Database class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

}

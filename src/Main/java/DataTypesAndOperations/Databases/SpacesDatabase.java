package DataTypesAndOperations.Databases;

import DataTypesAndOperations.DataTypes.Space;
import DataTypesAndOperations.DataTypes.TypeOfSpace;
import MainPackage.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SpacesDatabase extends Database {


    public boolean isEmpty() {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        Query query = entityManager.createQuery("SELECT COUNT(s) FROM Space s");
        return  super.isEmpty(entityManager, query);
    }


    public List<Space> getData() {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Query query = entityManager.createQuery("SELECT s FROM Space s");
        List<Space> spacesList = new ArrayList<>();
        try {
            transaction.begin();
            spacesList = query.getResultList();
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("getData method of SpacesDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
        return spacesList;
    }

    public void addSpace (Space space) {
        super.addEntity(space);
    }

    public void removeSpace (Space space) {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String stringQuery = "DELETE FROM Space s WHERE s.name = :name";
        Query query = entityManager.createQuery(stringQuery);
        query.setParameter("name", space.getName());
        try {
            transaction.begin();
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("removeCustomer method of SpacesDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

    public void updateSpaceName(int spaceId, String newName) {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Space existingSpace = entityManager.find (Space.class, spaceId);
            existingSpace.setName(newName);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("updateSpaceName method of SpaceDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }

    public void updateSpacePrice(int spaceId, int newPrice) {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Space existingSpace = entityManager.find(Space.class, spaceId);
            existingSpace.setPrice(newPrice);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("updateSpacePrice method of SpaceDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }

    public void updateSpaceType(int spaceId, TypeOfSpace typeOfSpace) {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Space existingSpace = entityManager.find (Space.class, spaceId);
            existingSpace.setType(typeOfSpace);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("updateSpaceType method of SpaceDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }

}

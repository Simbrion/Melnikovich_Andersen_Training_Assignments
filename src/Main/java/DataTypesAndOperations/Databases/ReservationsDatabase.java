package DataTypesAndOperations.Databases;

import DataTypesAndOperations.DataTypes.Reservation;
import MainPackage.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class ReservationsDatabase extends Database {


    public boolean isEmpty() {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        Query query = entityManager.createQuery("SELECT COUNT(r) FROM Reservation r");
        return  super.isEmpty(entityManager, query);
    }

    public List<Reservation> getData() {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Query query = entityManager.createQuery("SELECT r FROM Reservation r");
        List<Reservation> reservationsList = new ArrayList<>();
        try {
            transaction.begin();
            reservationsList = query.getResultList();
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("getData method of ReservationsDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
        return reservationsList;
    }

    public void removeReservation (Reservation reservation)  {
        EntityManager entityManager = Main.EM_FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String stringQuery = "DELETE FROM Reservation r WHERE r.id = :id";
        Query query = entityManager.createQuery(stringQuery);
        query.setParameter("id", reservation.getId());
        try {
            transaction.begin();
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("removeCustomer method of ReservationsDatabase class caught exception!");
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

    public void addReservation(Reservation reservation) {
        super.addEntity(reservation);
    }


}

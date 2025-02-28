

import java.time.LocalDateTime;

public class TimeOverlapChecker {

    public boolean startTimeOverlaps(LocalDateTime startOfNewReservation, Reservation newReservation) {
        if (Main.reservationsList.isEmpty()) return false;
        for (Reservation existingReservation : Main.reservationsList) {
            if (!(existingReservation.getSpace().equals(newReservation.getSpace()))) continue;
            LocalDateTime startOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getStartTime());
            LocalDateTime endOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getEndTime());
            if (startOfNewReservation.isAfter(startOfExistingReservation) && startOfNewReservation.isBefore(endOfExistingReservation)) return true;
            if (startOfNewReservation.isEqual(startOfExistingReservation) || startOfNewReservation.isEqual(endOfExistingReservation)) return true;
        }
        return false;
    }

    public boolean endTimeOverlaps(LocalDateTime endOfNewReservation, Reservation newReservation) {
        if (Main.reservationsList.isEmpty()) return false;
        for (Reservation existingReservation : Main.reservationsList) {
            if (!(existingReservation.getSpace().equals(newReservation.getSpace()))) continue;
            LocalDateTime startOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getStartTime());
            LocalDateTime endOfExistingReservation = LocalDateTime.of(existingReservation.getDate(), existingReservation.getEndTime());
            LocalDateTime startOfNewReservation = LocalDateTime.of(newReservation.getDate(), newReservation.getStartTime());
            if ((startOfNewReservation.isBefore(endOfExistingReservation)) && endOfNewReservation.isAfter(startOfExistingReservation)) return true;
            if ((endOfNewReservation.isEqual(startOfExistingReservation)) || (endOfNewReservation).isEqual(endOfExistingReservation)) return true;
        }
        return false;

    }
}

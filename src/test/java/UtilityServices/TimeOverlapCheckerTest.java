package UtilityServices;

import DataTypesAndOperations.DataTypes.Reservation;
import DataTypesAndOperations.DataTypes.Space;
import MainPackage.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
class TimeOverlapCheckerTest {

    @Mock
    Reservation mockExistingReservationOne;

    @Mock
    Reservation mockExistingReservationTwo;

    @Mock
    Reservation mockNewReservation;

    @Mock
    Space mockSpaceOne;

    @Mock
    Space mockSpaceTwo;

    @InjectMocks
    TimeOverlapChecker testTimeOverlapChecker;

    @BeforeEach
    void testSetup(){
        Main.RESERVATIONS.clear();
        Main.RESERVATIONS.add(mockExistingReservationOne);
        Main.RESERVATIONS.add(mockExistingReservationTwo);
    }

    @Nested
    class startTimeOverlapsTests {

        @Test
        void whenOverlaps_thenReturnTrue() {
            //Arrange

            Mockito.doReturn(LocalDate.of(2025, 3, 20)).when(mockExistingReservationOne).getDate();
            Mockito.doReturn(LocalTime.of(12, 0)).when(mockExistingReservationOne).getStartTime();
            Mockito.doReturn(LocalTime.of(12, 30)).when(mockExistingReservationOne).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationOne).getSpace();

            Mockito.doReturn(LocalDate.of(2023, 12, 12)).when(mockExistingReservationTwo).getDate();
            Mockito.doReturn(LocalTime.of(13, 0)).when(mockExistingReservationTwo).getStartTime();
            Mockito.doReturn(LocalTime.of(14, 30)).when(mockExistingReservationTwo).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationTwo).getSpace();

            Mockito.doReturn(mockSpaceOne).when(mockNewReservation).getSpace();
            LocalDateTime startOfNewReservation = LocalDateTime.of(2023, 12, 12, 13, 15);

            //Act
            assertTrue(testTimeOverlapChecker.startTimeOverlaps(startOfNewReservation, mockNewReservation));

            //Verify
            Mockito.verify(mockExistingReservationOne, times(2)).getDate();
            Mockito.verify(mockExistingReservationOne, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationOne, times(1)).getEndTime();
            Mockito.verify(mockExistingReservationTwo, times(2)).getDate();
            Mockito.verify(mockExistingReservationTwo, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationTwo, times(1)).getEndTime();

        }

        @Test
        void whenDoesNotOverlap_thenReturnFalse() {
            //Arrange

            Mockito.doReturn(LocalDate.of(2025, 3, 20)).when(mockExistingReservationOne).getDate();
            Mockito.doReturn(LocalTime.of(12, 0)).when(mockExistingReservationOne).getStartTime();
            Mockito.doReturn(LocalTime.of(12, 30)).when(mockExistingReservationOne).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationOne).getSpace();

            Mockito.doReturn(LocalDate.of(2023, 12, 12)).when(mockExistingReservationTwo).getDate();
            Mockito.doReturn(LocalTime.of(13, 0)).when(mockExistingReservationTwo).getStartTime();
            Mockito.doReturn(LocalTime.of(14, 30)).when(mockExistingReservationTwo).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationTwo).getSpace();

            Mockito.doReturn(mockSpaceOne).when(mockNewReservation).getSpace();
            LocalDateTime startOfNewReservation = LocalDateTime.of(2022, 1, 12, 13, 15);

            //Act
            assertFalse(testTimeOverlapChecker.startTimeOverlaps(startOfNewReservation, mockNewReservation));

            //Verify
            Mockito.verify(mockExistingReservationOne, times(2)).getDate();
            Mockito.verify(mockExistingReservationOne, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationOne, times(1)).getEndTime();
            Mockito.verify(mockExistingReservationTwo, times(2)).getDate();
            Mockito.verify(mockExistingReservationTwo, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationTwo, times(1)).getEndTime();

        }

        @Test
        void whenDifferentSpace_thenReturnFalse() {

            //Arrange
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationOne).getSpace();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationTwo).getSpace();
            Mockito.doReturn(mockSpaceTwo).when(mockNewReservation).getSpace();
            LocalDateTime startOfNewReservation = LocalDateTime.of(2023, 12, 12, 13, 15);

            //Act
            assertFalse(testTimeOverlapChecker.startTimeOverlaps(startOfNewReservation, mockNewReservation));

            //Verify
            Mockito.verify(mockExistingReservationOne, times(0)).getDate();
            Mockito.verify(mockExistingReservationOne, times(0)).getStartTime();
            Mockito.verify(mockExistingReservationOne, times(0)).getEndTime();
            Mockito.verify(mockExistingReservationTwo, times(0)).getDate();
            Mockito.verify(mockExistingReservationTwo, times(0)).getStartTime();
            Mockito.verify(mockExistingReservationTwo, times(0)).getEndTime();

        }

    }

    @Nested
    class endTimeOverlapsTests {

        @Test
        void whenOverlaps_thenReturnTrue() {
            //Arrange

            Mockito.doReturn(LocalDate.of(2025, 3, 20)).when(mockExistingReservationOne).getDate();
            Mockito.doReturn(LocalTime.of(12, 0)).when(mockExistingReservationOne).getStartTime();
            Mockito.doReturn(LocalTime.of(12, 30)).when(mockExistingReservationOne).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationOne).getSpace();

            Mockito.doReturn(LocalDate.of(2023, 12, 12)).when(mockExistingReservationTwo).getDate();
            Mockito.doReturn(LocalTime.of(13, 0)).when(mockExistingReservationTwo).getStartTime();
            Mockito.doReturn(LocalTime.of(14, 30)).when(mockExistingReservationTwo).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationTwo).getSpace();

            LocalDate dateOfNewReservation = LocalDate.of(2023, 12, 12);
            LocalDateTime endDateTimeOfNewReservation = LocalDateTime.of(dateOfNewReservation, LocalTime.of(15, 30));
            LocalTime startTimeOfNewReservation = LocalTime.of(13, 15);
            Mockito.doReturn(mockSpaceOne).when(mockNewReservation).getSpace();
            Mockito.doReturn(startTimeOfNewReservation).when(mockNewReservation).getStartTime();
            Mockito.doReturn(dateOfNewReservation).when(mockNewReservation).getDate();

            //Act
            assertTrue(testTimeOverlapChecker.endTimeOverlaps(endDateTimeOfNewReservation, mockNewReservation));

            //Verify
            Mockito.verify(mockExistingReservationOne, times(2)).getDate();
            Mockito.verify(mockExistingReservationOne, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationOne, times(1)).getEndTime();
            Mockito.verify(mockExistingReservationTwo, times(2)).getDate();
            Mockito.verify(mockExistingReservationTwo, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationTwo, times(1)).getEndTime();

        }

        @Test
        void whenDoesNotOverlap_thenReturnFalse() {

            //Arrange
            Mockito.doReturn(LocalDate.of(2025, 3, 20)).when(mockExistingReservationOne).getDate();
            Mockito.doReturn(LocalTime.of(12, 0)).when(mockExistingReservationOne).getStartTime();
            Mockito.doReturn(LocalTime.of(12, 30)).when(mockExistingReservationOne).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationOne).getSpace();

            Mockito.doReturn(LocalDate.of(2023, 12, 12)).when(mockExistingReservationTwo).getDate();
            Mockito.doReturn(LocalTime.of(13, 0)).when(mockExistingReservationTwo).getStartTime();
            Mockito.doReturn(LocalTime.of(14, 30)).when(mockExistingReservationTwo).getEndTime();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationTwo).getSpace();

            LocalDate dateOfNewReservation = LocalDate.of(2023, 12, 12);
            LocalDateTime endDateTimeOfNewReservation = LocalDateTime.of(dateOfNewReservation, LocalTime.of(12, 30));
            LocalTime startTimeOfNewReservation = LocalTime.of(12, 0);
            Mockito.doReturn(mockSpaceOne).when(mockNewReservation).getSpace();
            Mockito.doReturn(startTimeOfNewReservation).when(mockNewReservation).getStartTime();
            Mockito.doReturn(dateOfNewReservation).when(mockNewReservation).getDate();

            //Act
            assertFalse(testTimeOverlapChecker.endTimeOverlaps(endDateTimeOfNewReservation, mockNewReservation));

            //Verify
            Mockito.verify(mockExistingReservationOne, times(2)).getDate();
            Mockito.verify(mockExistingReservationOne, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationOne, times(1)).getEndTime();
            Mockito.verify(mockExistingReservationTwo, times(2)).getDate();
            Mockito.verify(mockExistingReservationTwo, times(1)).getStartTime();
            Mockito.verify(mockExistingReservationTwo, times(1)).getEndTime();

        }

        @Test
        void whenDifferentSpace_thenReturnFalse() {

            //Arrange
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationOne).getSpace();
            Mockito.doReturn(mockSpaceOne).when(mockExistingReservationTwo).getSpace();
            Mockito.doReturn(mockSpaceTwo).when(mockNewReservation).getSpace();
            LocalDate dateOfNewReservation = LocalDate.of(2023, 12, 12);
            LocalDateTime endDateTimeOfNewReservation = LocalDateTime.of(dateOfNewReservation, LocalTime.of(12, 30));

            //Act
            assertFalse(testTimeOverlapChecker.endTimeOverlaps(endDateTimeOfNewReservation, mockNewReservation));

            //Verify
            Mockito.verify(mockExistingReservationOne, times(0)).getDate();
            Mockito.verify(mockExistingReservationOne, times(0)).getStartTime();
            Mockito.verify(mockExistingReservationOne, times(0)).getEndTime();
            Mockito.verify(mockExistingReservationTwo, times(0)).getDate();
            Mockito.verify(mockExistingReservationTwo, times(0)).getStartTime();
            Mockito.verify(mockExistingReservationTwo, times(0)).getEndTime();

        }

    }

}

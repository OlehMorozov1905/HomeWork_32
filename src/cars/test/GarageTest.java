package cars.test;
import cars.dao.Garage;
import cars.dao.GarageImpl;
import cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTest {

    private Garage garage;
    private Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(6);
        cars = new Car[5];
        cars[0] = new Car("ABC123", "Camry", "Toyota", 2.0, "Blue");
        cars[1] = new Car("XYZ789", "Mustang", "Ford", 3.5, "Red");
        cars[2] = new Car("DEF456", "Civic", "Honda", 1.5, "Silver");
        cars[3] = new Car("GHI789", "Patrol", "Nissan", 2.2, "White");
        cars[4] = new Car("JKL123", "Camaro", "Chevrolet", 2.4, "Black");

        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void testAddCar() {
        Car car = new Car("MNO645", "Rubicon", "Jeep", 4.0, "Green");
        assertTrue(garage.addCar(car));
        assertEquals(6, garage.quantity());
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[0]));
    }

    @Test
    void testRemoveCar() {
        Car removedCar = garage.removeCar("XYZ789");
        assertNotNull(removedCar);
        assertEquals("XYZ789", removedCar.getRegistrationNumber());
        assertNull(garage.removeCar("PQR789"));
    }

    @Test
    void testFindCarByRegistrationNumber() {
        Car foundCar = garage.findCarByRegistrationNumber("DEF456");
        assertNotNull(foundCar);
        assertEquals("DEF456", foundCar.getRegistrationNumber());
        assertNull(garage.findCarByRegistrationNumber("ZYX321"));
    }

    @Test
    void testFindCarsByModel() {
        Car[] model = garage.findCarsByModel("Camry");
        assertEquals(1, model.length);
    }

    @Test
    void testfindCarsByCompany() {
        Car[] company = garage.findCarsByCompany("Toyota");
        assertEquals(1, company.length);
    }

    @Test
    void testFindCarsByEngine() {
        Car[] carsByEngine = garage.findCarsByEngine(2.0, 2.5);
        assertEquals(3, carsByEngine.length);
    }

    @Test
    void testFindCarsByColor() {
        Car[] blackCars = garage.findCarsByColor("Black");
        assertEquals(1, blackCars.length);
    }

    @Test
    void testQuantity() {
        assertEquals(5, garage.quantity());
    }

    @org.junit.jupiter.api.Test
    void printCars() {
        garage.printCars();
    }
}

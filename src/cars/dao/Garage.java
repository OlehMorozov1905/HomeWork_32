package cars.dao;

import cars.model.Car;

public interface Garage {
    public static final String COUNTRY = "Ukraine, Mezhyhirya";
    boolean addCar(Car car);

    Car removeCar(String registrationNumber);

    Car findCarByRegistrationNumber(String registrationNumber);

    Car[] findCarsByModel(String model);

    Car[] findCarsByCompany(String company);

    Car[] findCarsByEngine(double min, double max);

    Car[] findCarsByColor(String color);

    int quantity();
    void printCars();
}

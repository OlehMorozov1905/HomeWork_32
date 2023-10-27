package cars.dao;

import cars.model.Car;

import java.util.Arrays;
import java.util.function.Predicate;

public class GarageImpl implements Garage {
    private Car[] cars;
    private int size;

    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (size < cars.length) {
            cars[size++] = car;
            return true;
        }
        return false;
    }

    @Override
    public Car removeCar(String registrationNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getRegistrationNumber().equals(registrationNumber)) {
                Car removedCar = cars[i];
                cars[i] = null;
                for (int j = i; j < size - 1; j++) {
                    cars[j] = cars[j + 1];
                }
                size--;
                return removedCar;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getRegistrationNumber().equals(registrationNumber)) {
                return cars[i];
            }
        }
        return null;
    }

//====================== HOME WORK ==========================//
    private Car[] filterCars(Predicate<Car> predicate) {
        Car[] result = new Car[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                result[count] = cars[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }
    //====================== END ==========================//
    @Override
    public Car[] findCarsByModel(String model) {
        Predicate<Car> byModel = car -> car != null && car.getModel().equals(model);
        return filterCars(byModel);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        Predicate<Car> byCompany = car -> car != null && car.getCompany().equals(company);
        return filterCars(byCompany);
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        Predicate<Car> byEngine = car -> car != null && car.getEngine() >= min && car.getEngine() <= max;
        return filterCars(byEngine);
    }


    @Override
    public Car[] findCarsByColor(String color) {
        Predicate<Car> byColor = car -> car != null && car.getColor().equals(color);
        return filterCars(byColor);
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printCars() {
        System.out.println(COUNTRY);
        for (int i = 0; i < size; i++) {
            System.out.println(cars[i]);
        }
    }
}

package cars.dao;

import cars.dao.Garage;
import cars.model.Car;

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

    @Override
    public Car[] findCarsByModel(String model) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getModel().equals(model)) {
                count++;
            }
        }
        Car[] result = new Car[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getModel().equals(model)) {
                result[j++] = cars[i];
            }
        }
        return result;
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getCompany().equals(company)) {
                count++;
            }
        }
        Car[] result = new Car[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getCompany().equals(company)) {
                result[j++] = cars[i];
            }
        }
        return result;
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getEngine() >= min && cars[i].getEngine() <= max) {
                count++;
            }
        }
        Car[] result = new Car[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getEngine() >= min && cars[i].getEngine() <= max) {
                result[j++] = cars[i];
            }
        }
        return result;
    }

    @Override
    public Car[] findCarsByColor(String color) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getColor().equals(color)) {
                count++;
            }
        }
        Car[] result = new Car[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (cars[i] != null && cars[i].getColor().equals(color)) {
                result[j++] = cars[i];
            }
        }
        return result;
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

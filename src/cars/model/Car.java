package cars.model;

public class Car {
    private String registrationNumber;
    private String model;
    private String company;
    private double engine;
    private String color;

    public Car(String registrationNumber, String model, String company, double engine, String color) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.company = company;
        this.engine = engine;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public double getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Car car = (Car) object;

        return registrationNumber.equals(car.registrationNumber);
    }

    @Override
    public int hashCode() {
        return registrationNumber.hashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car: ");
        sb.append(" registrationNumber = '").append(registrationNumber).append('\'');
        sb.append(", model = '").append(model).append('\'');
        sb.append(", company = '").append(company).append('\'');
        sb.append(", engine = ").append(engine);
        sb.append(", color = '").append(color).append('\'');
        return sb.toString();
    }
}

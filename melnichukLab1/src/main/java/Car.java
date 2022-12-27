

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.Set;


public class Car implements Comparable<Car> {

    @NotNull(message = "Must be not null")
    private String brand;

    @NotNull(message = "Must be not null")
    private String model;

    //   @Digits(integer = 4, fraction = 0, message = "Must be less than 4")
    @Size(min = 4, max = 5, message = "Must include 4 char")
    private String numberCar;

    @NotNull(message = "Must be not null")
    private String carType;

    @NotNull(message = "Must be not null")
    private float engineType;

    @NotNull(message = "Must be not null")
    private String fuelType;

    @NotNull(message = "Must be not null")
    private String transmission;

    @Min(value = 1, message = "Mileage must be more than 0")
    private int mileageCar;

    @NotNull
    @Min(value = 1, message = "Price must be more than 0")
    private double price;


    public Car(String brand, String model, String numberCar, String carType, float engineType, String fuelType, String transmission, int mileageCar, double price) {
        this.brand = brand;
        this.model = model;
        this.numberCar = numberCar;
        this.carType = carType;
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.mileageCar = mileageCar;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public float getEngineType() {
        return engineType;
    }

    public void setEngineType(float engineType) {
        this.engineType = engineType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getMileageCar() {
        return mileageCar;
    }

    public void setMileageCar(int mileageCar) {
        this.mileageCar = mileageCar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", numberCar=" + numberCar +
                ", carType=" + carType +
                ", engineType=" + engineType +
                ", fuelType=" + fuelType +
                ", transmission=" + transmission +
                ", mileageCar=" + mileageCar + " km " +
                ", pricePerHour=" + price + "$" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberCar == car.numberCar && Float.compare(car.engineType, engineType) == 0 && mileageCar == car.mileageCar && Double.compare(car.price, price) == 0 && brand.equals(car.brand) && model.equals(car.model) && carType == car.carType && fuelType == car.fuelType && transmission == car.transmission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, numberCar, carType, engineType, fuelType, transmission, mileageCar, price);
    }


    public int compareTo(Car car) {
        return Double.compare(this.price,car.price);
//        if (this.pricePerHour == car.pricePerHour) {
//            return 0;
//        } else if (this.pricePerHour < car.pricePerHour) {
//            return -1;
//        } else {
//            return 1;
//        }
    }



    public static class CarBuilder {

        private String brand;
        private String model;
        private String numberCar;
        private String carType;
        private float engineType;
        private String fuelType;
        private String transmission;
        private int mileageCar;
        private double price;

        public Car.CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Car.CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public Car.CarBuilder numberCar(String numberCar) {
            this.numberCar = numberCar;
            return this;
        }

        public Car.CarBuilder carType(String carType) {
            this.carType = carType;
            return this;
        }

        public Car.CarBuilder engineType(float engineType) {
            this.engineType = engineType;
            return this;
        }

        public Car.CarBuilder fuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public Car.CarBuilder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Car.CarBuilder mileageCar(int mileageCar) {
            this.mileageCar = mileageCar;
            return this;
        }

        public Car.CarBuilder price(double pricer) {
            this.price = price;
            return this;
        }

        public Car build() throws ValidationException {
            Car car = new Car(brand, model, numberCar, carType, engineType, fuelType, transmission, mileageCar, price);
           // validateCar(car);
            return car;

        }

        public Car validateCar(Car car) {

            System.out.println("Validation!!_____________________________________________________-");
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                System.out.println(fieldName + " " + constraintViolation.getMessage());
            }
            return car;


        }
    }
}

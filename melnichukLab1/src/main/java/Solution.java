
import javax.validation.ValidationException;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Solution implements Serializable {

    public static List<Car> sortByStreamPrice(List<Car> car) {
        return car.stream().sorted((c1, c2) -> (int) c1.getPrice() - (int) c2.getPrice()).collect(Collectors.toList());

    }

    // Car with mileage < 15000;
    public static List<Car> filterMileageCar(List<Car> car) {
        return car.stream().filter(car1 -> car1.getMileageCar() < 15000).collect(Collectors.toList());
    }

    // Customer  who are 18 years old

    public static List<Customer> filterAdultsCustomer(List<Customer> customers) {
        LocalDate date = LocalDate.now();

        return customers.stream().filter(customer -> ChronoUnit.DAYS.between(date, customer.getBirth()) * (-1) > 6570 && customer.isDriverLicense()==true)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ValidationException {


        Car bmwM8 = new Car.CarBuilder()
                .brand("BMW")
                .model("M8")
                .numberCar("7777")
                .carType("Sedan")
                .engineType((float) 4.4)
                .fuelType("Gasoline")
                .transmission("Automatic")
                .mileageCar(10)
                .price(100000)
                .build();

        Car zafira = new Car.CarBuilder()
                .brand("Opel")
                .model("Zafira")
                .numberCar("0546")
                .carType("MINIVAN")
                .engineType((float) 1.9)
                .fuelType("Diesel")
                .transmission("Mechanic")
                .mileageCar(240540)
                .price(4000)
                .build();

        TreeSet<Car> carsSortForPrice = new TreeSet<Car>();
        carsSortForPrice.add(bmwM8);
        carsSortForPrice.add(zafira);

        System.out.println("List of cars sorted by price ");
        carsSortForPrice.forEach(System.out::println);
        System.out.println("\n");

        ArrayList<Car> carsSortFotMileage = new ArrayList<>();

        carsSortFotMileage.add(bmwM8);
        carsSortFotMileage.add(zafira);

        System.out.println("List of cars sorted by Mileage ");
        carsSortFotMileage.forEach(System.out::println);
        System.out.println("\n");


        System.out.println("Sort by stream  Mileage");
        List<Car> carsList = new ArrayList<>();
        carsList.add(bmwM8);
        carsList.add(zafira);

        System.out.println("\n Car with Mileage < 15000");
        filterMileageCar(carsList).forEach(System.out::println);


        Customer MaksMelnichuk = new Customer.CustomerBuilder()
                .name("Maks")
                .surname("Melnichuk")
                .email("maksimko1610@gmail.com")
                .telephoneNumber("+38095767666")
                .birth(LocalDate.of(2002, 10, 16))
                .driverLicense(true)
                .build();


        Customer SerhiyDvoryannikov = new Customer.CustomerBuilder()
                .name("Serhiy")
                .surname("Dvoryannikov")
                .email("promasterSerhiy0103@gmail.com")
                .telephoneNumber("+38095535462")
                .birth(LocalDate.of(2003, 6, 30))
                .driverLicense(false)
                .build();


        System.out.println("Filter by  adults and driver License");
        List<Customer> customers = new ArrayList<>();
        customers.add(MaksMelnichuk);
        customers.add(SerhiyDvoryannikov);
        filterAdultsCustomer(customers).forEach(System.out::println);
        System.out.println("\n Order");
        Order order = new Order.OrderBuilder().car(zafira).customer(MaksMelnichuk).build();
        System.out.println(order.toString());




    }


}

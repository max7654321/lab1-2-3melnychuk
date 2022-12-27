
import java.util.Objects;
import java.util.UUID;


public class Order {
    private String id = UUID.randomUUID().toString();
    private Car car;
    private Customer customer;

    public Order(Car car, Customer customer) {
        this.car = car;
        this.customer = customer;

    }

    public Car getCar() {
        return car;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return   id.equals(order.id) && car.equals(order.car) && customer.equals(order.customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id:'" + id + '\'' +
                "\n Car: " + car.getBrand() +
                "," + car.getModel() +

                "\n Customer: " + customer.getSurname() +
                " " + customer.getName() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, customer);
    }



    public static class OrderBuilder{

        private String id = UUID.randomUUID().toString();
        private Car car;
        private Customer customer;
        private double cost;
        private int hour;
        private boolean permission;

        public Order.OrderBuilder car(Car car){
            this.car=car;
            return this;
        }
        public Order.OrderBuilder customer(Customer customer){
                  this.customer=customer;
                  return this;
        }


        public Order build(){
            return new Order(car,customer);
        }

    }
}

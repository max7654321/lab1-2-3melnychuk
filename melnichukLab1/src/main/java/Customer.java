import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Customer {

    @NotNull(message = "Must be not null")
    private String surname;

    @NotNull(message = "Must be not null")
    private String name;

    @NotNull(message = "Must be not null")
    @Size(min = 13, max = 13 , message = "Phone Number must include 13 char")
    private String telephoneNumber;

    @NotNull(message = "Must be not null")
    @Email
    private String email;

    @NotNull(message = "Must be not null")
    private LocalDate birth;

    @NotNull(message = "Must be not null")
    private boolean driverLicense;


    public Customer(String surname, String name, String telephoneNumber, String email, LocalDate birth, boolean driverLicense) {
        this.surname = surname;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.birth = birth;
        this.driverLicense = driverLicense;
    }

    public boolean isDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(boolean driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }


    public static class CustomerBuilder{
        private String surname;
        private String name;
        private String telephoneNumber;
        private String email;
        private LocalDate birth;
        private boolean driverLicense;
        public CustomerBuilder surname(String surname){
              this.surname=surname;
              return this;
        }
        public CustomerBuilder name(String name){
            this.name=name;
            return this;
        }
        public CustomerBuilder telephoneNumber(String telephoneNumber){
            this.telephoneNumber=telephoneNumber;
            return this;
        }
        public CustomerBuilder email(String email){
            this.email=email;
            return this;
        }
        public CustomerBuilder birth(LocalDate birth){
            this.birth=birth;
            return this;
        }

        public CustomerBuilder driverLicense(boolean license){
            this.driverLicense=license;
            return this;
        }

        public Customer validateCustomer(Customer customer) throws ValidationException {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                System.out.println(fieldName + " " + constraintViolation.getMessage());
            }
            return customer;
        }
        public Customer build(){
             Customer customer = new Customer(surname,name,telephoneNumber,email,birth,driverLicense);
             validateCustomer(customer);
             return customer ;
        }
    }
}

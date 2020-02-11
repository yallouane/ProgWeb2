package fr.univparis8.iut.dut.employee;

import fr.univparis8.iut.dut.salary.Salary;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private final Long id ;
    private final String firstName ;
    private final String lastName ;
    private final Address address ;
    private List<Salary> salaries;

    public Employee(Long id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address =address;
        this.salaries = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public Employee mergeWith(Employee other) {

        return EmployeeBuilder.create()
                .withId(id)
                .withLastName((other.lastName != null ) ? other.lastName : "lastName" )
                .withFirstName((other.firstName != null ) ? other.firstName : "firstName" )
                .build();
    }

    public static final class EmployeeBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Address ad;
        private List<Salary> list;

        private EmployeeBuilder() {
           this.list = new ArrayList<>();
        }

        public static EmployeeBuilder create() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withAddress(Address a) {
            this.ad = a;
            return this;
        }

       public EmployeeBuilder withSalaries (List<Salary> list) {
            this.list = list;
            return this;
        }

        public Employee build() {
            return new Employee(id, firstName, lastName, ad);
        }
    }
}

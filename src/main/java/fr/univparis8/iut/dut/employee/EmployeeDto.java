package fr.univparis8.iut.dut.employee;
import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.salary.SalaryDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Address address;

    private List<SalaryDto> salaries;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salaries = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SalaryDto> getSalaries() {
        return salaries;
    }

    public static final class EmployeeDtoBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Address address;
        private List<SalaryDto> salaryList;

        private EmployeeDtoBuilder() {
            salaryList = new ArrayList<>();
        }

        public static EmployeeDtoBuilder create() {
            return new EmployeeDtoBuilder();
        }

        public EmployeeDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDtoBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public EmployeeDtoBuilder withSalaryDto (List<SalaryDto> list) {
            this.salaryList = list;
            return this;
        }



        public EmployeeDto build() {
            return new EmployeeDto(id, firstName, lastName, address);
        }
    }
}
































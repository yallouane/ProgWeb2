package fr.univparis8.iut.dut.employee;
import fr.univparis8.iut.dut.salary.Salary;
import fr.univparis8.iut.dut.salary.SalaryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        List<SalaryDto> e ;
        if ( employee.getSalaries() == null ) {
            e = new ArrayList<>();
        } else {
            e = employee.getSalaries().stream()
                    .map(x -> SalaryDto.SalaryDtoBuilder.create()
                            .withId(x.getId())
                            .withDate(x.getDate())
                            .withMontant(x.getMontant())
                            .withNbJours(x.getNbJours())
                            .withEmployeeDto(toEmployeeDto(employee))
                            .build())
                    .collect(Collectors.toList());
        }

        return EmployeeDto.EmployeeDtoBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withAddress(employee.getAddress())
                .withSalaryDto(e)
                .build();
    }

    public static Employee toEmployee(EmployeeDto employee) {

        return Employee.EmployeeBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withAddress(employee.getAddress())
                .build();
    }

    public static Employee toEmployee(EmployeeEntity employee) {

        Address address = new Address(employee.getNumero(), employee.getRue(), employee.getVille(), employee.getCodePostal(), employee.getPays());
        List<Salary> e = new ArrayList<>();

            return Employee.EmployeeBuilder.create()
                    .withId(employee.getId())
                    .withFirstName(employee.getFirstName())
                    .withLastName(employee.getLastName())
                    .withAddress(address)
                    .withSalaries(e)
                    .build();

    }

    public static EmployeeEntity toEmployee (Employee employee) {

        Address address = new Address(employee.getAddress().getNumero(),
                employee.getAddress().getRue(),
                employee.getAddress().getVille(),
                employee.getAddress().getCodePostal(),
                employee.getAddress().getPays());

        return EmployeeEntity.EmployeeEntityBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .withNumero(address.getNumero())
                .withRue(address.getRue())
                .withVille(address.getVille())
                .withCodePostal(address.getCodePostal())
                .withPays(address.getPays())
                .build();
    }

    public static List<Employee> toEmployeesList(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<EmployeeDto> toEmployeesDtoList(List<Employee> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployeeDto)
                .collect(Collectors.toList());
    }

    public static List<EmployeeEntity> fromEmployeListToEntityList( List<Employee> listEmployee ){
        return listEmployee.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<Employee> fromDtoListToEmployeesList(List<EmployeeDto> listEmployeeDto) {
        return listEmployeeDto.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }
}




































package fr.univparis8.iut.dut.salary;
import fr.univparis8.iut.dut.employee.EmployeeEntity;
import fr.univparis8.iut.dut.employee.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class SalaryMapper {

    public static SalaryDto toSalaryDto ( Salary salary ) {
        return SalaryDto.SalaryDtoBuilder.create()
                .withId(salary.getId())
                .withMontant(salary.getMontant())
                .withNbJours(salary.getNbJours())
                .withDate(salary.getDate())
                .withMoisAnnee(salary.getMoisAnnee())
                .withEmployeeDto(EmployeeMapper.toEmployeeDto(salary.getEmployee()))
                .build();
    }

    public static Salary toSalary ( SalaryDto salary ) {
        return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withMontant(salary.getMontant())
                .withNbJours(salary.getNbJours())
                .withDate(salary.getDate())
                .withMoisAnnee(salary.getMoisAnnee())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployeeDto()))
                .build();
    }

    public static Salary toSalary ( SalaryEntity salary ) {
        return Salary.SalaryBuilder.create()
                .withId(salary.getId())
                .withMontant(salary.getMontant())
                .withNbJours(salary.getNbJours())
                .withDate(salary.getDate())
                .withMoisAnnee(salary.getMoisAnnee())
                .withEmployee(EmployeeMapper.toEmployee(salary.getEmployeeEntity()))
                .build();
    }

    public static SalaryEntity toSalary  ( Salary salary ) {
        EmployeeEntity e = new EmployeeEntity(salary.getEmployee().getId());
        return SalaryEntity.SalaryEntityBuilder.create()
                .withId(salary.getId())
                .withMontant(salary.getMontant())
                .withNbJours(salary.getNbJours())
                .withDate(salary.getDate())
                .withMoisAnnee(salary.getMoisAnnee())
                .withEmployeeEntity(e)
                .build();
    }

    public static List<Salary> toSalarysList(List<SalaryEntity> salaryEntities) {
        return salaryEntities.stream()
                .map(SalaryMapper::toSalary)
                .collect(Collectors.toList());
    }

    public static List<SalaryDto> toSalariesDtoList(List<Salary> salary) {
        return salary.stream()
                .map(SalaryMapper::toSalaryDto)
                .collect(Collectors.toList());
    }

    public static List<SalaryEntity> fromSalaryListToEntityList( List<Salary> listSalary ){
        return listSalary.stream()
                .map(SalaryMapper::toSalary)
                .collect(Collectors.toList());
    }

    public static List<Salary> fromDtoListToSalarysList(List<SalaryDto> listSalaryDto) {
        return listSalaryDto.stream()
                .map(SalaryMapper::toSalary)
                .collect(Collectors.toList());
    }

}

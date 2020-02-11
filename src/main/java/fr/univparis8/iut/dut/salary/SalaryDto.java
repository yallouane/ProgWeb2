package fr.univparis8.iut.dut.salary;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.univparis8.iut.dut.employee.EmployeeDto;

import java.time.LocalDate;
public class SalaryDto {

    private Long id;
    private double montant;
    private int nbJours;
    private LocalDate date;
    private String moisAnnee;
    @JsonProperty(value = "employee")
    private EmployeeDto employeeDto;

    public SalaryDto(Long id, double montant, int nbJours, LocalDate date, String moisAnnee, EmployeeDto empdto) {

        this.id=id;
        this.montant=montant;
        this.nbJours=nbJours;
        this.date=date;
        this.moisAnnee = moisAnnee;
        this.employeeDto = empdto;

    }

    public SalaryDto() {}

    public String getMoisAnnee() {
        return moisAnnee;
    }

    public void setMoisAnnee(String moisAnnee) {
        this.moisAnnee = moisAnnee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public static final class SalaryDtoBuilder {
        private Long id;
        private double montant;
        private int nbJours;
        private LocalDate date;
        private String moisAnnee;
        private EmployeeDto employeeDto;


        private SalaryDtoBuilder() {

        }

        public static SalaryDtoBuilder create() {
            return new SalaryDtoBuilder();
        }

        public SalaryDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryDtoBuilder withMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public SalaryDtoBuilder withNbJours(int nbJours) {
            this.nbJours = nbJours;
            return this;
        }

        public SalaryDtoBuilder withDate(LocalDate date) {
            this.date = date;
          //  int y = date.getYear(),m=date.getMonthValue();
           // this.date= LocalDate.of(y,m,1);
            return this;
        }

        public SalaryDtoBuilder withEmployeeDto(EmployeeDto employeeDto) {
            this.employeeDto = employeeDto;
            return this;
        }

        public SalaryDtoBuilder withMoisAnnee(String moisAnnee) {
            this.moisAnnee = moisAnnee;
            return this;
        }

        public SalaryDto build() {
            return new SalaryDto(id, montant, nbJours, date, moisAnnee, employeeDto);
        }
    }

















}


















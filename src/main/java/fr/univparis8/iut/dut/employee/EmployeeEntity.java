package fr.univparis8.iut.dut.employee;
import fr.univparis8.iut.dut.salary.SalaryEntity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "numero")
    private String numero;

    @Column(name = "rue")
    private String rue;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codePostal")
    private String codePostal;

    @Column(name = "pays")
    private String pays;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",  targetEntity = SalaryEntity.class)
    private List<SalaryEntity> salaries;

    public EmployeeEntity() {
        this.salaries = new ArrayList<>();
    }

    public EmployeeEntity(Long id) {
        this.id = id;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<SalaryEntity> getSalaries() {
        return this.salaries;
    }

    public void setSalaries(List<SalaryEntity> s) {
        this.salaries = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity)) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public static final class EmployeeEntityBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String numero;
        private String rue;
        private String ville;
        private String codePostal;
        private String pays;
        private List<SalaryEntity> list;

        private EmployeeEntityBuilder() {
        }

        public static EmployeeEntityBuilder create() {
            return new EmployeeEntityBuilder();
        }

        public EmployeeEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeEntityBuilder withNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public EmployeeEntityBuilder withRue(String rue) {
            this.rue = rue;
            return this;
        }

        public EmployeeEntityBuilder withVille(String ville) {
            this.ville = ville;
            return this;
        }

        public EmployeeEntityBuilder withCodePostal(String codePostal) {
            this.codePostal = codePostal;
            return this;
        }

        public EmployeeEntityBuilder withPays(String pays) {
            this.pays = pays;
            return this;
        }

        public EmployeeEntityBuilder withSalaryList(List<SalaryEntity> s) {
            this.list = s;
            return this;
        }

        public EmployeeEntity build() {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(id);
            employeeEntity.setFirstName(firstName);
            employeeEntity.setLastName(lastName);
            employeeEntity.setCodePostal(codePostal);
            employeeEntity.setNumero(numero);
            employeeEntity.setPays(pays);
            employeeEntity.setRue(rue);
            employeeEntity.setVille(ville);
            employeeEntity.setSalaries(list);
            return employeeEntity;
        }
    }
}

package fr.univparis8.iut.dut.vacation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacation")
public class VacationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "jour")
    private LocalDate jour;


    public VacationEntity() {

    }

    public VacationEntity(Long id, LocalDate jour) {
        this.id = id;
        this.jour = jour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }


    public static final class vacationEntityBuilder {


    private  LocalDate jour;

    private  Long id;



    public vacationEntityBuilder() {



    }

    public static VacationEntity create() {
        return new VacationEntity();
    }
    public  vacationEntityBuilder withJour (LocalDate j) {
        this.jour =j;
        return this;
    }

    public   vacationEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public VacationEntity build() {
        return new VacationEntity(id, jour);
    }




    }


}
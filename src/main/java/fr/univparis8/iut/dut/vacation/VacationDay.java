package fr.univparis8.iut.dut.vacation;

import java.time.LocalDate;

public class VacationDay {

    private LocalDate jour;
    private long id;
    public VacationDay(LocalDate j, long id) {
        this.jour = j;
        this.id = id;
    }

    public VacationDay() {

    }

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


public  static final class VacationDayBuilder {

    private LocalDate jour;
    private long id;

    private VacationDayBuilder(){

    }


        public VacationDayBuilder withJour(LocalDate j) {
        this.jour= j;
        return this;
        }

        public VacationDayBuilder withId(long id) {
        this.id = id;
        return this;
        }




    public static VacationDayBuilder create() {
        return new VacationDayBuilder();
    }

}




    public VacationDay build() {
        return new VacationDay(jour,id);
    }
}

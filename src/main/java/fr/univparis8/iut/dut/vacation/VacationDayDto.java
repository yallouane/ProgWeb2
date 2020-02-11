package fr.univparis8.iut.dut.vacation;

import java.time.LocalDate;

public class VacationDayDto {

    private LocalDate jour;
    private long id;

    public VacationDayDto(){

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

    public VacationDayDto(LocalDate j, long id) {
    this.jour = j;
    this.id = id;
}
    public static final class vacationDayDtoBuilder {
        private LocalDate jour;
        private long id;

        private vacationDayDtoBuilder() {

        }

        public static vacationDayDtoBuilder create() {
            return new vacationDayDtoBuilder();
        }

        public vacationDayDtoBuilder  withJour (LocalDate j) {
            this.jour = j;
            return this;
        }
        public vacationDayDtoBuilder withId (Long id) {
            this.id = id;
            return this;
        }



    }
    public VacationDayDto build() {
        return new VacationDayDto(jour,id);
    }


}
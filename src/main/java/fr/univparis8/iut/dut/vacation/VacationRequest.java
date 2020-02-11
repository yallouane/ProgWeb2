package fr.univparis8.iut.dut.vacation;

import java.time.LocalDate;

public class VacationRequest {
   private final LocalDate debut;
   private final LocalDate fin;
   private final long id;


   public VacationRequest(LocalDate d, LocalDate f, long id) {

       this.debut = d;
       this.fin = f;
       this.id = id;

   }

    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public long getId() {
        return id;
    }

    private static final class VacationRequestBuilder {
    private  LocalDate debut;
    private  LocalDate fin;
    private  long id;

    private VacationRequestBuilder() {

    }

    public static VacationRequestBuilder create() {
        return new VacationRequestBuilder();
        }

        public VacationRequestBuilder withDebut (LocalDate d) {
        this.debut = d;
        return this;
        }


        public VacationRequestBuilder withFin (LocalDate f) {
            this.debut = f;
            return this;
        }

        public VacationRequestBuilder withId (long id) {
            this.id = id;
            return this;
        }

        public VacationRequest build() {
        return new VacationRequest(this.debut,this.fin,this.id);
        }

}

}
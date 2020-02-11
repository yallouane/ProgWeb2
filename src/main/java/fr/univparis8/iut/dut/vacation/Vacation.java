package fr.univparis8.iut.dut.vacation;

import java.time.LocalDate;

public class Vacation {

    private int id;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int idEmployee;

    public Vacation() {
    }

    public Vacation( int id, LocalDate deb, LocalDate fin, int idemp ) {

        this.id = id;
        this.dateStart = deb;
        this.dateEnd = fin;
        this.idEmployee = idemp ;

    }
}

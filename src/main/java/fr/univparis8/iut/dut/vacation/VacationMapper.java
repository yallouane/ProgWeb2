package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class VacationMapper {

    public static VacationDayDto vacationDaytoDto (VacationDay v) {
        VacationDayDto vac = new VacationDayDto();
        vac.build().setId(v.getId());
        vac.build().setJour(v.getJour());
        //v.setJour(v.getJour());
        return vac;
    }

    public static VacationEntity vacationDaytoEntity (VacationRequest v) {
        VacationEntity vac = new VacationEntity();
         vac.setId(v.getId());
        vac.setJour(v.getDebut());

return vac;
    }
    public static List<VacationDay> enListe (VacationRequest vac) {
        List<VacationDay> liste = new ArrayList<>();

        Employee e = Employee.EmployeeBuilder.create().withId(vac.getId()).build();

        for(LocalDate date = vac.getDebut(); date.isBefore(vac.getFin()); date.plusDays(1)) {
            VacationDay v = new VacationDay(date,e.getId());
            liste.add(v);
        }

        return liste;
    }

    public static VacationRequest toVacationRequest (VacationEntity v) {
        // on met une valeur fixe à la date de fin de vacation request.
        VacationRequest vac = new VacationRequest(v.getJour(),v.getJour().plusDays(5),v.getId());

        return vac;
    }

    public static VacationDayDto VacationDtoToRequest(VacationDayDto v) {
        VacationDayDto vac = new VacationDayDto();
        vac.setJour(v.getJour());
        vac.setId(v.getId());

        return vac;
    }
    public static VacationDayDto toVacationDayDto (VacationEntity v) {
        VacationDayDto vac = new VacationDayDto();
        vac.setId(v.getId());
        vac.setJour(v.getJour());

        return vac;
    }
    public static List<VacationDayDto> ListVacationEntitiesToDto (List<VacationEntity> l)  {
        return l.stream().map(VacationMapper::toVacationDayDto).collect(Collectors.toList());
    }


    public static VacationDay toVacationDay(VacationEntity v) {
        VacationDay vaca =  new VacationDay();
       vaca.setId(v.getId());
       vaca.setJour(v.getJour());
        return vaca;
        }

    public static VacationEntity toVacationEntity(VacationDay v) {
        VacationEntity vaca =  new VacationEntity();
      //  vaca.withId(v.getId());
        vaca.setJour(v.getJour());
        vaca.setId(v.getId());
      //  vaca.withJour(v.getJour());
        return vaca;
    }

    public static List<VacationEntity> VacationToVacationEntity(List<VacationDay> l ) {
        return l.stream().map(VacationMapper::toVacationEntity).collect(Collectors.toList());
    }
    public static List<VacationDay> VacationEntityToVacationDay (List<VacationEntity> l ) {
        return l.stream().map(VacationMapper::toVacationDay).collect(Collectors.toList());

    }

    public static List<VacationDayDto> VacationEntityToDto (List<VacationEntity> l) {
        return l.stream().map(VacationMapper::toVacationDayDto).collect(Collectors.toList());

    }

    /*public static VacationRequest toVacationRequest (VacationEntity v) {
        VacationRequest vac = new VacationRequest();
        VacationRequest

        return vac;
    }*/
    public static List<VacationRequest> VacationEntitesToRequest (List<VacationEntity> l) {
        return l.stream().map(VacationMapper::toVacationRequest).collect(Collectors.toList());
    }
  /*  public VacationDay tovacationDay(VacationEntity va) {
        VacationDay v = v.build();

    return v;
    }*/
  /*  public static List<VacationDay> vacationDayEntityToDay(List<VacationEntity> l) {
        return l.stream().map(VacationEntity :: vacationDaytoEntity).collect(Collectors.toList());
        }
    }*/


}
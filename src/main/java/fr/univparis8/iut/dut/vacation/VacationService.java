package fr.univparis8.iut.dut.vacation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {

    private static final String NOT_FOUND_MESSAGE = "vacation with id  [ %s ] not found";

    private VacationRepository vacRepository;


    public VacationService() {

    }

    public VacationService(VacationRepository v) {
        this.vacRepository = v;
    }





/*    public List<VacationDay> create(List<VacationDay> e) {
        List<VacationEntity> listEntities = VacationMapper.VacationToVacationEntity(e);
        List<VacationEntity> vacationEntities = vacRepository.saveAll(listEntities);
        return VacationMapper.enListe( VacationMapper.VacationEntitesToRequest(vacationEntities));

    }
*/
   /* public List<VacationDay> getAll(List<VacationEntity> l) {
        return l.stream().map(VacationMapper::vacationDayEntityToDay).collect(Collectors.toList());
    }*/
}
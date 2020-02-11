package fr.univparis8.iut.dut.vacation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {

    private VacationService vacService;

  /*  @PostMapping("/batch")
    public List<VacationDay> create(VacationRequest v) {

        return this.vacService.create(VacationMapper.enListe(v));
    }*/

    /*@GetMapping
    public List<VacationDay> getAll() {
    }*/
}

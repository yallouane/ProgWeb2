package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.common.exception.IdMismatchException;
import fr.univparis8.iut.dut.employee.Employee;
import fr.univparis8.iut.dut.employee.EmployeeDto;
import fr.univparis8.iut.dut.employee.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public List<SalaryDto> getAllSalarys() {
        return salaryService.getAll();
    }

    @GetMapping("{id}")
    public SalaryDto getSalary(@PathVariable Long id) {
        return SalaryMapper.toSalaryDto(salaryService.get(id));
    }

    @PutMapping("{id}")
    public SalaryDto updateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDto) {
        if(salaryDto.getId() == null) {
            throw new IllegalArgumentException("Salary id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(salaryDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Salary updatedSalary = salaryService.update(SalaryMapper.toSalary(salaryDto));
        return SalaryMapper.toSalaryDto(updatedSalary);
    }
  /*  @PatchMapping("{id}")
    public SalaryDto partialUpdateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDto) {
        if(salaryDto.getId() == null) {
            throw new IllegalArgumentException("Salary id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(salaryDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        //Salary updatedSalary = salaryService.partialUpdate(SalaryMapper.toSalary(salaryDto));
     //   return SalaryMapper.toSalaryDto(updatedSalary);
    }*/

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto) throws URISyntaxException {

        if(salaryDto.getId() != null) {
            throw new IllegalArgumentException("Salary id should not be populated when creating and salary");
        }

        Salary newSalary = salaryService.create(SalaryMapper.toSalary(salaryDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newSalary.getId())
                .toUri().getPath()
        );
        return ResponseEntity.created(uri).body(SalaryMapper.toSalaryDto(newSalary));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<SalaryDto>> batchCreate (@RequestBody List<SalaryDto> list){
        List<Salary> list1 = SalaryMapper.fromDtoListToSalarysList(list);
        List<Salary> list2 = salaryService.create(list1);
        return ResponseEntity.ok(SalaryMapper.toSalariesDtoList(list2));
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id) {
        salaryService.delete(id);
    }

    @GetMapping("/ByDate")
    public List<SalaryDto> getAllByDate() {
        return salaryService.getAllByDate();
    }
}

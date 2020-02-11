package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.salary.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<VacationEntity, Long> {




}
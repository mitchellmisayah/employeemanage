package com.getarrays.employeemanager.repo;

import com.getarrays.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//passes in the employee object and ID(primary key)
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}

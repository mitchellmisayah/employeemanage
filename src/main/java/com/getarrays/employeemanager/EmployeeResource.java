package com.getarrays.employeemanager;

import com.getarrays.employeemanager.model.Employee;
import com.getarrays.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    // Injects the EmployeeService to delegate business logic
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieve a list of all employees in the system.
     *
     * @return HTTP 200 OK with a list of employees
     */
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Retrieve a specific employee by their unique ID.
     *
     * @param id the employee's unique identifier
     * @return HTTP 200 OK with the employee if found, or an error if not
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Create a new employee record.
     *
     * @param employee the employee data from the request body
     * @return HTTP 201 CREATED with the newly created employee
     */
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    /**
     * Update an existing employee.
     *
     * @param employee the updated employee data (must include valid ID)
     * @return HTTP 200 OK with the updated employee
     */
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    /**
     * Delete an employee by ID.
     *
     * @param id the ID of the employee to delete
     * @return HTTP 200 OK if deletion was successful
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

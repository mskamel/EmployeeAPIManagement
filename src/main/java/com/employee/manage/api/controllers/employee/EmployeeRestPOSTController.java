package com.employee.manage.api.controllers.employee;

import com.employee.manage.api.config.PasswordEncoder;
import com.employee.manage.api.entites.Employee;
import com.employee.manage.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
public class EmployeeRestPOSTController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody @Valid Employee employee)
    {
        employeeRepository.save(employee);
        return employee;
    }
}

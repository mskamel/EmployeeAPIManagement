package com.employee.manage.api.controllers.employee;

import com.employee.manage.api.entites.Employee;
import com.employee.manage.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
public class EmployeeRestDELETEController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id)
    {
        Employee employee = employeeRepository.getReferenceById(id);
        employeeRepository.delete(employee);
    }
}

package com.employee.manage.api.controllers.employee;

import com.employee.manage.api.entites.Employee;
import com.employee.manage.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;


@RestController
@Transactional
public class EmployeeRestPUTController
{
    @Autowired
    private EmployeeRepository employeeRepository;

   @PutMapping(value = "/employee")
    public ResponseEntity<Employee> saySomething(@RequestBody Employee employee)
   {
       try
       {
           employeeRepository.save(employee);
       }
       catch(RuntimeException exception)
       {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
       return new ResponseEntity<>(HttpStatus.OK);
   }
}

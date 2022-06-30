package com.employee.manage.api.controllers.employee;

import com.employee.manage.api.entites.Employee;
import com.employee.manage.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class EmployeeRestGETController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> all = null;
        try
        {
            all = employeeRepository.findAll();
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/employees/{fullName}")
    public ResponseEntity<List<Employee>> getEmployeesByFullName(@PathVariable("fullName") String fullName)
    {
        List<Employee> employeeList = null;
        try
        {
            employeeList = employeeRepository.getByFullName(fullName);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employees/company/{companyName}")
    public ResponseEntity<List<Employee>> getEmployeesByCurrentComapny(@PathVariable("companyName") String companyName)
    {
        List<Employee> employeeList = null;
        try
        {
            employeeList = employeeRepository.findByCompany(companyName);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employee/{contactMail}")
    public ResponseEntity<Employee> getEmployeeByContactMail(@PathVariable("contactMail") String contactMail)
    {
        Employee employee = null;
        try
        {
            employee = employeeRepository.findByContactMail(contactMail);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
package com.employee.manage.api.repository;

import java.util.List;
import com.employee.manage.api.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    @Query(value = "SELECT e FROM Employee e WHERE e.fullName = ?1")
    List<Employee> getByFullName(@Param("fullName") String fullName);

    @Query(value = "SELECT e FROM Employee e WHERE e.currentCompany = ?1")
    List<Employee> findByCompany(@Param("currentCompany") String companyName);

    @Query(value = "SELECT e FROM Employee e WHERE e.contactEmail = ?1")
    Employee findByContactMail(@Param("contactEmail") String contactEmail);
}
package com.employee.manage.api.repository;

import com.employee.manage.api.entites.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
    @Query(value = "SELECT a FROM Admin a WHERE a.email=:email")
    Admin retrieveByEmail(@Param("email") String email);
}
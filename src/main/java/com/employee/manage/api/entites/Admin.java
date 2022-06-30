package com.employee.manage.api.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Admin
{
    @Id
    @Column
    Integer id;

    @Email
    @Column
    @NotNull(message = "The email property cannont be null! Please insert a value")
    String email;

    @NotNull(message = "The password property cannont be null! Please insert a value")
    String password;

    String role;
}

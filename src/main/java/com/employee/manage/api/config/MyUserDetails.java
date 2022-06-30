package com.employee.manage.api.config;

import com.employee.manage.api.entites.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails
{
    private Admin admin;
    MyUserDetails(Admin admin)
    {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(admin.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword()
    {
        return this.admin.getPassword();
    }

    @Override
    public String getUsername()
    {
        return this.admin.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

}

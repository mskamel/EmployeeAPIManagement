package com.employee.manage.api.config;

import com.employee.manage.api.entites.Admin;
import com.employee.manage.api.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Admin admin = adminRepository.retrieveByEmail(username);
        if (admin == null)
        {
            throw new UsernameNotFoundException("Couldn't find an admin using these login info");
        }
        return new MyUserDetails(admin);
    }
}

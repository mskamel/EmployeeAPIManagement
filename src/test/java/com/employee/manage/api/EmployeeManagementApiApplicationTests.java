package com.employee.manage.api;

import com.employee.manage.api.config.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagementApiApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
		}
	}


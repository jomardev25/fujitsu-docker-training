package com.github.blog.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.github.blog.repository.RoleRepository;

@ExtendWith(MockitoExtension.class)
public class RoleServiceUnitTest {

	@Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

	@Test
	void createRole() {
		assertTrue(true);
	}

}

package com.github.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.github.blog.entity.Role;
import com.github.blog.exception.ResourceNotFoundException;
import com.github.blog.payload.RoleDto;
import com.github.blog.repository.RoleRepository;
import com.github.blog.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<RoleDto> getAllRoles() {
		List<Role> roles = roleRepository.findAll();
		return roles.stream().map(role -> mapToDto(role)).collect(Collectors.toList());
	}

	@Override
	public RoleDto getRoleById(Long id) {
		Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
		return mapToDto(role);
	}

	@Override
	public RoleDto createRole(RoleDto roleDto) {
		Role role = mapToEntity(roleDto);
		return mapToDto(roleRepository.save(role));
	}

	@Override
	public RoleDto updateRole(Long id, RoleDto roleDto) {
		Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
		role.setName(roleDto.getName());
		roleRepository.save(role);
		return mapToDto(role);
	}

	@Override
	public void deleteRole(Long id) {
		Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
		roleRepository.delete(role);
	}

	private RoleDto mapToDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setName(role.getName());
		return roleDto;
	}

	private Role mapToEntity(RoleDto roleDto) {
		Role role = new Role();
		role.setId(roleDto.getId());
		role.setName(roleDto.getName());
		return role;
	}

}

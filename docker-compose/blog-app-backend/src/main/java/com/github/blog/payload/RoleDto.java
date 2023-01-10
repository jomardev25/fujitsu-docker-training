package com.github.blog.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RoleDto {

	private long id;

	@NotEmpty(message = "Name field must not be empty.")
	@Size(min = 2, message = "Name field must be greater than 2 characters.")
	private String name;

}

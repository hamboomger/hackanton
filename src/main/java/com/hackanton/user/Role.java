package com.hackanton.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ddorochov
 */
@Entity(name = "role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private int id;

	@NotEmpty
	@Column(name = "role_name")
	private String name;

	public Role(String name) {
		this.name = name;
	}

	protected Role() {}

	public int getId() {
		return id;
	}

	public Role setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Role setName(String name) {
		this.name = name;
		return this;
	}
}

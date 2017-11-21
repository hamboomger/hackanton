package com.hamboomger.model.common;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

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

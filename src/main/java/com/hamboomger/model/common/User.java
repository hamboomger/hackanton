package com.hamboomger.model.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hamboomger.model.search.EventsSearchConfiguration;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author ddorochov
 */
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private long id;

	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;

	@Length(min = 5, message = "Your password must have at least 5 characters")
	@NotEmpty
	@JsonIgnore
	private String password;

	@NotEmpty
	@Column(unique = true)
	private String username;

	@Column
	private boolean active = true;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_role")
	private List<Role> roles;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "search_config_id")
	private EventsSearchConfiguration searchConfiguration;

	public User(String email, String password, String username,
				boolean active, List<Role> roles, EventsSearchConfiguration searchConfiguration) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.active = active;
		this.roles = roles;
		this.searchConfiguration = searchConfiguration;
	}

	public User() {}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}


	public User encodePassword(PasswordEncoder encoder) {
		this.password = encoder.encode(password);
		return this;
	}

	public String getUsername() {
		return username;
	}

	public boolean isActive() {
		return active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setSearchConfiguration(EventsSearchConfiguration searchConfiguration) {
		this.searchConfiguration = searchConfiguration;
	}

	public EventsSearchConfiguration getSearchConfiguration() {
		return searchConfiguration;
	}
}

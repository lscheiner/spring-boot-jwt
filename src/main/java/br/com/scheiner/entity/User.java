package br.com.scheiner.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity(name = "user")
public class User extends BaseEntity implements UserDetails  , Serializable {

	private static final long serialVersionUID = 8233003400037329195L;

	@Column(name = "username", unique = true)
	@NotNull
	@Size(min = 2, max = 60)
	private String username;

	@Column(name = "password")
	@NotNull
	@Size(min = 0, max = 60)
	private String password;

	@Column(name = "name")
	@NotNull
	@Size(min = 2, max = 60)
	private String name;

	@Column(name = "email")
	@NotNull
	@Size(min = 2, max = 120)
	private String email;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(admin);
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

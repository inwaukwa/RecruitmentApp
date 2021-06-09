package cogent.recruitment.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cogent.recruitment.entities.Applicant;

public class ApplicantDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private int id;
	private String email;
	private String firstName;
	private String lastName;

	@JsonIgnore
	private String password;
	private String linkedIn;

	private Collection<? extends GrantedAuthority> authorities;

	public ApplicantDetailsImpl(int id, String email, String firstName, String lastName, String password,
			String linkedIn, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.linkedIn = linkedIn;
		this.authorities = authorities;
	}

	public static ApplicantDetailsImpl build(Applicant applicant) {
		List<GrantedAuthority> authorities = null;

		return new ApplicantDetailsImpl(applicant.getId(), applicant.getEmail(), applicant.getFirstName(), applicant.getLastName(), applicant.getPassword(), applicant.getLinkedIn(),authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getLinkedIn() {
		return linkedIn;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ApplicantDetailsImpl user = (ApplicantDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}

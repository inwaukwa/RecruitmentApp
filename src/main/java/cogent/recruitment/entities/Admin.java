package cogent.recruitment.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "admin", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(max = 45)
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@Size(max = 45)
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@Size(max = 100)
	@Column(name="email")
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 255)
	@Column(name="password")
	private String password;
	
	@NotBlank
	@Size(min = 10,max = 20)
	@Column(name="phone")
	private String phone; 
	
	@Size(max = 500)
	@Column(name="bio")
	private String bio;
	
	@NotBlank
	@Column(name="active")
	private Boolean active;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "admin_roles", joinColumns = @JoinColumn(name = "admin_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "recruiter")
	private Set<Application> applications;

	public Admin(int id, String firstName, String lastName,
			String email, String password, String phone, String bio, Boolean active,
			Set<Role> roles, Set<Application> applications) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.bio = bio;
		this.active = active;
		this.roles = roles;
		this.applications = applications;
	}

	public Admin() {}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", bio=" + bio + ", active=" + active + ", roles="
				+ roles + ", applications=" + applications + "]";
	}	
	
}

package cogent.recruitment.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "applicant", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Applicant implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(max = 45)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@Size(max = 45)
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank
	@Size(max = 100)
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Size(min = 10,max = 20)
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "linkedin")
	@Size(max = 100)
	private String linkedIn;
	
	@JsonBackReference
	@OneToMany(mappedBy = "applicant")
	private Set<Application> applications;
	
	public Applicant() {}
	
	public Applicant(String firstName, String lastName, String email, String password, String phone, String linkedIn, Set<Application> applications) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.linkedIn = linkedIn;
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNo=" + phone + ", linkedIn=" + linkedIn + "]";
	}

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
		Applicant other = (Applicant) obj;
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
	
	public void setPhone(String phoneNo) {
		this.phone = phoneNo;
	}
	
	public String getLinkedIn() {
		return linkedIn;
	}
	
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	public Set<Application> getApplications() {
		return applications;
	}
	
	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	
}

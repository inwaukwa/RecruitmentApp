package cogent.recruitment.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class ApplicantSignupRequest {
	
	@NotBlank
	@Size(max = 45)
	private String firstName;
	
	@NotBlank
	@Size(max = 45)
	private String lastName;
	
	@NotBlank
	@Size(max = 100)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 255)
	private String password;
	
	@NotBlank
	@Size(min = 10,max = 20)
	private String phone;
	
	@Size(max = 100)
	private String linkedIn;
  
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
	
}

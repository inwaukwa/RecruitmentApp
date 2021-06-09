package cogent.recruitment.payload.response;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String linkedIn;
	
	public JwtResponse(String token, String type, int id, String firstName, String lastName, String email,
			String linkedIn) {
		super();
		this.token = token;
		this.type = type;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.linkedIn = linkedIn;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

}

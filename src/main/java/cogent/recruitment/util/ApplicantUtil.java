package cogent.recruitment.util;

import org.springframework.stereotype.Component;

import cogent.recruitment.entities.Applicant;

@Component
public class ApplicantUtil {
	
	public void copyNonNullValues(Applicant req, Applicant db) {
		
		if(req.getFirstName() !=null) {
			db.setFirstName(req.getFirstName());
		}
		
		if(req.getLastName() !=null) {
			db.setLastName(req.getLastName());
		}
		
		if(req.getEmail() !=null) {
			db.setEmail(req.getEmail());
		}
		
		if(req.getPassword() !=null) {
			db.setPassword(req.getPassword());
		}
		
		if(req.getPhone() !=null) {
			db.setPhone(req.getPhone());
		}
		
		if(req.getFirstName() !=null) {
			db.setFirstName(req.getFirstName());
		}
		
		if(req.getLinkedIn() !=null) {
			db.setLinkedIn(req.getLinkedIn());
		}
	}

}

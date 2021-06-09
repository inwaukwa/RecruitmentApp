package cogent.recruitment.util;

import org.springframework.stereotype.Component;

import cogent.recruitment.entities.Admin;

@Component
public class AdminUtil {
	
	public void mergeAdmin(Admin newAdmin, Admin oldAdmin) {
		
		if(newAdmin.getFirstName() !=null) {
			oldAdmin.setFirstName(newAdmin.getFirstName());
		}
		
		if(newAdmin.getLastName() !=null) {
			oldAdmin.setLastName(newAdmin.getLastName());
		}
		
		if(newAdmin.getEmail() !=null) {
			oldAdmin.setEmail(newAdmin.getEmail());
		}
		
		if(newAdmin.getPassword() !=null) {
			oldAdmin.setPassword(newAdmin.getPassword());
		}
		
		if(newAdmin.getPhone() !=null) {
			oldAdmin.setPhone(newAdmin.getPhone());
		}
		
		if(newAdmin.getBio() !=null) {
			oldAdmin.setBio(newAdmin.getBio());
		}
		
		if(newAdmin.getActive() !=null) {
			oldAdmin.setActive(newAdmin.getActive());
		}
		
		if(newAdmin.getRoles() !=null) {
			oldAdmin.setRoles(newAdmin.getRoles());
		}
	}

}
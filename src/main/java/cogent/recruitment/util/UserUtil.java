package cogent.recruitment.util;

import org.springframework.stereotype.Component;

import cogent.recruitment.entities.User;

@Component
public class UserUtil {
	
	public void mergeUser(User newUser, User oldUser) {
		
		if(newUser.getFirstName() !=null) {
			oldUser.setFirstName(newUser.getFirstName());
		}
		
		if(newUser.getLastName() !=null) {
			oldUser.setLastName(newUser.getLastName());
		}
		
//Not allowing users to change their email		
//		if(newUser.getEmail() !=null) {
//			oldUser.setEmail(newUser.getEmail());
//		}
		
		if(newUser.getPassword() !=null) {
			oldUser.setPassword(newUser.getPassword());
		}
		
		if(newUser.getPhone() !=null) {
			oldUser.setPhone(newUser.getPhone());
		}
		
		if(newUser.getLinkedin() !=null) {
			oldUser.setLinkedin(newUser.getLinkedin());
		}
		
		if(newUser.getActive()) {
			oldUser.setActive(newUser.getActive());
		}
		
		if(!newUser.getActive()) {
			oldUser.setActive(false);
		}
		
		if(!newUser.getRoles().isEmpty()) {
			oldUser.setRoles(newUser.getRoles());
		}
	}

}
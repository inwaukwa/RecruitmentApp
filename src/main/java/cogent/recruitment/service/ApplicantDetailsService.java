package cogent.recruitment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.ApplicantDao;
import cogent.recruitment.entities.Applicant;

@Service
public class ApplicantDetailsService implements UserDetailsService {
	
	@Autowired
	ApplicantService aService;
	
	@Autowired
	ApplicantDao aDao;

	@Override
	public UserDetails loadUserByUsername(String email) {
		Applicant applicant = aService.getApplicantByEmail(email);

		return ApplicantDetailsImpl.build(applicant);
	}
	
}

package cogent.recruitment.service;

import java.util.List;
import cogent.recruitment.entities.Applicant;

public interface ApplicantService {
	
	List<Applicant> getAllApplicants();
	
	Applicant getApplicantById(Integer id);
	
	Applicant getApplicantByEmail(String email);
	
	List<Applicant> getApplicantsByNameContaining(String name);
	
	String saveApplicant(Applicant applicant);
	
	String updateApplicant(Applicant applicant);
	
	boolean doesApplicantExist(Integer id);

}

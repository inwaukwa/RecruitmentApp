package cogent.recruitment.service;

import java.util.List;

import cogent.recruitment.entities.Application;

public interface ApplicationService {

	List<Application> getAllApplications();

	Application getApplicationById(Integer id);

	List<Application> getApplicationsByApplicantId(Integer id);
	
	List<Application> getApplicationsByJobId(Integer id);
	
	List<Application> getApplicationsByRecruiterId(Integer id);

	String saveApplication(Application application);

	String updateApplication(Application application);

	boolean doesApplicationExist(Integer id);

}

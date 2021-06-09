package cogent.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.ApplicationDao;
import cogent.recruitment.entities.Application;
import cogent.recruitment.exception.ResourceNotFoundException;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	ApplicationDao applicationDao;

	@Override
	public List<Application> getAllApplications() {
		List<Application> applications = applicationDao.findAll();
		return applications;
	}

	@Override
	public Application getApplicationById(Integer id) {
		Application application = applicationDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Application with ID: " + id + " not found."));
		return application;
	}

	@Override
	public List<Application> getApplicationsByApplicantId(Integer id) {
		List<Application> applications = applicationDao.findByApplicantId(id)
				.orElseThrow(() -> new ResourceNotFoundException("No applications exist under the given applicant."));
		return applications;
	}

	@Override
	public List<Application> getApplicationsByJobId(Integer id) {
		List<Application> applications = applicationDao.findByJobId(id)
				.orElseThrow(() -> new ResourceNotFoundException("No applications exist under the given job."));
		return applications;
	}

	@Override
	public List<Application> getApplicationsByRecruiterId(Integer id) {
		List<Application> applications = applicationDao.findByRecruiterId(id)
				.orElseThrow(() -> new ResourceNotFoundException("No applications exist under the given recruiter."));
		return applications;
	}

	@Override
	public String saveApplication(Application application) {
		String applicationDetails = applicationDao.save(application).toString();
		return applicationDetails;
	}

	@Override
	public String updateApplication(Application application) {
		String applicationDetails = applicationDao.save(application).toString();
		return applicationDetails;
	}

	@Override
	public boolean doesApplicationExist(Integer id) {
		return applicationDao.existsById(id);
	}

}

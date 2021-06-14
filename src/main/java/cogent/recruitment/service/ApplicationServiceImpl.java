package cogent.recruitment.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.ApplicationDao;
import cogent.recruitment.entities.Application;
import cogent.recruitment.entities.MailMessage;
import cogent.recruitment.exception.ResourceNotFoundException;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	ApplicationDao applicationDao;
	
	@Autowired
	UserService service;
	
	@Autowired
	private MailService notificationService;
	
	@Autowired
	private MailMessage message;

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
	public Set<Application> getApplicationsByUserId(Integer id) {
		Set<Application> applications = service.getUserById(id).getApplications();
		return applications;
	}

	@Override
	public List<Application> getApplicationsByJobId(Integer id) {
		List<Application> applications = applicationDao.findByJobId(id)
				.orElseThrow(() -> new ResourceNotFoundException("No applications exist under the given job."));
		return applications;
	}

	@Override
	@Transactional
	public String saveApplication(Application application) {
		String applicationDetails = applicationDao.save(application).toString();
	
		message.setEmailAddress(service.getApplicantfromUsers(application.getUsers()).getEmail());
		message.setSubject("NEW APPLICATION: "+application.getJob().getName());
		message.setBodyText("Your application for "+application.getJob().getName()+" has been successfully submitted");
		try {
			notificationService.sendEmail(message);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		
		return applicationDetails;
	}

	@Override
	@Transactional
	public String updateApplication(Application application) {
		String applicationDetails = applicationDao.save(application).toString();
		
		message.setEmailAddress(service.getApplicantfromUsers(application.getUsers()).getEmail());
		message.setSubject("UPDATED APPLICATION: "+application.getJob().getName());
		message.setBodyText("Your application for "+application.getJob().getName()+" has been successfully updated");
		try {
			notificationService.sendEmail(message);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		
		return applicationDetails;
	}

	@Override
	public boolean doesApplicationExist(Integer id) {
		return applicationDao.existsById(id);
	}

}

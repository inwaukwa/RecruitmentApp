package cogent.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.ApplicationEvaluationDao;
import cogent.recruitment.entities.ApplicationEvaluation;
import cogent.recruitment.entities.MailMessage;
import cogent.recruitment.exception.ResourceNotFoundException;

@Service
public class ApplicationEvaluationImpl implements ApplicationEvaluationInterface{
	@Autowired
	ApplicationEvaluationDao applicationevaluationdao;
	
	@Autowired
	private MailService notificationService;
	
	@Autowired
	UserService uServ;
	
	@Autowired
	private MailMessage message;

	public void saveApplicationEvaluation(ApplicationEvaluation app)
	{
		applicationevaluationdao.save(app);
		ApplicationEvaluation appEval = applicationevaluationdao.getById(app.getId());
		message.setEmailAddress(uServ.getApplicantfromUsers(appEval.getApp().getUsers()).getEmail());
		message.setSubject(appEval.getAppStatus().getStat().name().toString().replace('_', ' '));
		message.setBodyText(appEval.getAppStatus().getStat().getMsgStatus());
		try {
			notificationService.sendEmail(message);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	}
	
	public ApplicationEvaluation getApplicationEvaluationById(int id)
	{
		return applicationevaluationdao.getById(id);
	}

	public List<ApplicationEvaluation> getAllApplicationEvaluation()
	{
		return applicationevaluationdao.findAll();
	}

	public List<ApplicationEvaluation> getApplicationEvaluationsById(int id)
	{
		List<ApplicationEvaluation> appList;
		appList = applicationevaluationdao.getEvalsByApplicationId(id)
				.orElseThrow(() -> new ResourceNotFoundException("No evaluations associated with this application."));
		return appList;
	}



}


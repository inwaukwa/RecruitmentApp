package cogent.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.AdminDao;
import cogent.recruitment.dao.ApplicationDao;
import cogent.recruitment.dao.ApplicationEvaluationDao;
import cogent.recruitment.dao.ApplicationStatusDao;
import cogent.recruitment.entities.Admin;
import cogent.recruitment.entities.Application;
import cogent.recruitment.entities.ApplicationEvaluation;
import cogent.recruitment.entities.ApplicationStatus;
import cogent.recruitment.exception.ResourceNotFoundException;

@Service
public class ApplicationEvaluationImpl implements ApplicationEvaluationInterface{
	@Autowired
	ApplicationEvaluationDao applicationevaluationdao;


	public void saveApplicationEvaluation(ApplicationEvaluation app)
	{
		applicationevaluationdao.save(app);
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
				.orElseThrow(() -> new ResourceNotFoundException("No applications exist under the given applicant."));
		return appList;
	}



}


package cogent.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.InterviewEvaluationDAO;
import cogent.recruitment.entities.InterviewEvaluation;

@Service
public class InterviewEvaluationService {

	@Autowired
	InterviewEvaluationDAO evalDao;
	
	//To get Evaluations by Evaluations ID
	public InterviewEvaluation getIntEvalById(int id) {
		return evalDao.findById(id).get();
	}
	
	//To find Evaluations by Interview ID
	public List<InterviewEvaluation> getIntEvalByIntId(int id) {
		return evalDao.findByInterviewId(id).get();
	}
	
	//To post a new Evaluation
	public InterviewEvaluation postInterviewEval(InterviewEvaluation intEval) {
		return evalDao.save(intEval);
	}

}

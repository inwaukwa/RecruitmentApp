package cogent.recruitment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cogent.recruitment.dao.InterviewEvaluationDAO;
import cogent.recruitment.entities.InterviewEvaluation;
import cogent.recruitment.exception.ResourceNotFoundException;
import cogent.recruitment.service.InterviewEvaluationService;
import cogent.recruitment.util.InterviewEvaluationUtil;

@RestController
@CrossOrigin()
@RequestMapping("/interviewEval")
public class InterviewEvaluationController {
	
	@Autowired
	InterviewEvaluationService intEvalService;
	
	@Autowired
	InterviewEvaluationDAO intEvalDao;
	
	@Autowired
	InterviewEvaluationUtil util;
	
	@GetMapping(value = "/eval/{id}")
	public ResponseEntity<?> getIntEvalById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(intEvalService.getIntEvalById(id));
	  
	  }
	
	@GetMapping(value = "/{id}") //List of Evaluations by Interview ID 
	public ResponseEntity<?> getIntEvalByIntId(@PathVariable int id){
		List<InterviewEvaluation> interviewEvals = intEvalService.getIntEvalByIntId(id);
		ResponseEntity<?> resp = new ResponseEntity<List<InterviewEvaluation>>(interviewEvals, HttpStatus.OK);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<?> saveEvaluation(@Valid @RequestBody InterviewEvaluation intEval)
	{
		return ResponseEntity.status(HttpStatus.OK).body(intEvalService.postInterviewEval(intEval));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateInterviewEval(@Valid @RequestBody InterviewEvaluation intEval, @PathVariable int id) {
		InterviewEvaluation eval = intEvalDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find specified interview"));
		
		InterviewEvaluation dbApplication = intEvalService.getIntEvalById(id);
		util.copyNonNullValues(intEval, dbApplication);
//		
//		eval.setNotes(intEval.getNotes());
//		eval.setPass(intEval.isPass());
		return ResponseEntity.ok(intEvalDao.save(eval));
	}
	
	
}
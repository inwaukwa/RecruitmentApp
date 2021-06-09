package cogent.recruitment.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cogent.recruitment.entities.Applicant;
import cogent.recruitment.service.ApplicantService;
import cogent.recruitment.util.ApplicantUtil;

@RestController
public class ApplicantController {

	@Autowired
	ApplicantService applicantService;

	@Autowired
	ApplicantUtil util;

	@GetMapping(value = "/applicants")
	public ResponseEntity<?> getAllApplicants() {

		List<Applicant> applicants = applicantService.getAllApplicants();
		ResponseEntity<?> resp = new ResponseEntity<List<Applicant>>(applicants, HttpStatus.OK);
		return resp;

	}

	@GetMapping(value = "/applicants/{id}")
	public ResponseEntity<?> getApplicantById(@PathVariable("id") @Min(1) int id) {

		Applicant applicant = applicantService.getApplicantById(id);
		ResponseEntity<?> resp = new ResponseEntity<Applicant>(applicant, HttpStatus.OK);
		return resp;

	}
	
	@GetMapping(value = "/applicants/email/{email}")
	public ResponseEntity<?> getApplicantByEmail(@PathVariable("email") String email) {
		
		Applicant applicant = applicantService.getApplicantByEmail(email);
		ResponseEntity<?> resp = new ResponseEntity<Applicant>(applicant, HttpStatus.OK);
		return resp;
	}

	@GetMapping(value = "/applicants/name/{name}")
	public ResponseEntity<?> getApplicantByNameContaining(@PathVariable("name") String name) {

		List<Applicant> applicants = applicantService.getApplicantsByNameContaining(name);
		ResponseEntity<?> resp = new ResponseEntity<List<Applicant>>(applicants, HttpStatus.OK);
		return resp;

	}

	@PostMapping(value = "/applicants")
	ResponseEntity<String> newApplicant(@Valid @RequestBody Applicant applicant) {

		String applicantDetails = applicantService.saveApplicant(applicant);
		ResponseEntity<String> resp = new ResponseEntity<String>("Inserted successfully " + applicantDetails, HttpStatus.CREATED);
		return resp;

	}
	
	

	@PutMapping(value = "/applicants/{id}")
	public ResponseEntity<String> updateApplicant(@PathVariable @Min(1) Integer id,
			@Valid @RequestBody Applicant reqApplicant) {

		Applicant dbApplicant = applicantService.getApplicantById(id);
		// copy non-null values from request to Database applicant
		util.copyNonNullValues(reqApplicant, dbApplicant);
		String applicantDetails = applicantService.updateApplicant(dbApplicant);
		ResponseEntity<String> resp = new ResponseEntity<String>(applicantDetails, HttpStatus.RESET_CONTENT);

		return resp;
	}

}

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

import cogent.recruitment.entities.Application;
import cogent.recruitment.service.ApplicationService;
import cogent.recruitment.util.ApplicationUtil;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;

	@Autowired
	ApplicationUtil util;

	@GetMapping(value = "/applications")
	public ResponseEntity<?> getAllApplications() {

		List<Application> applications = applicationService.getAllApplications();
		ResponseEntity<?> resp = new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		return resp;

	}

	@GetMapping(value = "/applications/{id}")
	public ResponseEntity<?> getApplicationById(@PathVariable("id") @Min(1) int id) {

		Application application = applicationService.getApplicationById(id);
		ResponseEntity<?> resp = new ResponseEntity<Application>(application, HttpStatus.OK);
		return resp;

	}

	@GetMapping(value = "/applications/applicant/{id}")
	public ResponseEntity<?> getApplicationByApplicantId(@PathVariable("id") @Min(1) int id) {

		List<Application> applications = applicationService.getApplicationsByApplicantId(id);
		ResponseEntity<?> resp = new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		return resp;

	}
	
	@GetMapping(value = "/applications/recruiter/{id}")
	public ResponseEntity<?> getApplicationByRecruiterId(@PathVariable("id") @Min(1) int id) {

		List<Application> applications = applicationService.getApplicationsByRecruiterId(id);
		ResponseEntity<?> resp = new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		return resp;

	}
	
	@GetMapping(value = "/applications/job/{id}")
	public ResponseEntity<?> getApplicationByJobId(@PathVariable("id") @Min(1) int id) {

		List<Application> applications = applicationService.getApplicationsByJobId(id);
		ResponseEntity<?> resp = new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		return resp;

	}

	@PostMapping(value = "/applications")
	public ResponseEntity<String> newApplication(@Valid @RequestBody Application application) {

		String applicationDetails = applicationService.saveApplication(application);
		ResponseEntity<String> resp = new ResponseEntity<String>("Inserted successfully " + applicationDetails, HttpStatus.CREATED);
		return resp;

	}

	@PutMapping(value = "/applications/{id}")
	public ResponseEntity<String> updateapplication(@PathVariable @Min(1) Integer id,
			@Valid @RequestBody Application reqApplication) {

		Application dbApplication = applicationService.getApplicationById(id);
		// copy non-null values from request to Database application
		util.copyNonNullValues(reqApplication, dbApplication);
		String applicationDetails = applicationService.updateApplication(dbApplication);
		ResponseEntity<String> resp = new ResponseEntity<String>(applicationDetails, HttpStatus.RESET_CONTENT);

		return resp;
	}

}

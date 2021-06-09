package cogent.recruitment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cogent.recruitment.entities.Admin;
import cogent.recruitment.service.AdminService;
import cogent.recruitment.util.AdminUtil;

@RestController
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@Autowired
	AdminUtil util;
	
	@GetMapping(value="/admins/{id}")
	public ResponseEntity<?> getAdminById(@PathVariable("id") int id) {
		Admin admin = service.getAdminById(id);
		ResponseEntity<?> resp = new ResponseEntity<Admin>(admin, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping(value="/admins/name/{name}")
	public ResponseEntity<?> getAdminByName(@PathVariable("name") String name) {
		List<Admin> admins = service.getAdminByName(name);
		ResponseEntity<?> resp = new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping(value="/admins")
	public ResponseEntity<?> getAdmins() {
		List<Admin> admins = service.getAdmins();
		ResponseEntity<?> resp = new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping(value="/recruiters")
	public ResponseEntity<?> getRecruiters() {
		List<Admin> admins = service.getRecruiters();
		ResponseEntity<?> resp = new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping(value="/managers")
	public ResponseEntity<?> getManagers() {
		List<Admin> admins = service.getManagers();
		ResponseEntity<?> resp = new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
		return resp;
	}
	
	@PostMapping(value="/admins")
	public ResponseEntity<String> saveAdmin(@Valid @RequestBody Admin admin) {
		String adminDets = "Created Admin: " + service.addAdmin(admin);
		ResponseEntity<String> resp = new ResponseEntity<String>(adminDets, HttpStatus.CREATED);
		return resp;
	}
	
	@PutMapping(value="/admins/{id}")
	public ResponseEntity<String> updateAdmin(@PathVariable int id, 
			@Valid @RequestBody Admin uAdmin) {
		
		Admin admin = service.getAdminById(id);
		util.mergeAdmin(uAdmin, admin);
		String adminDets = "Updated Admin: " + service.addAdmin(admin);
		ResponseEntity<String> resp = new ResponseEntity<String>(adminDets, HttpStatus.OK);
		
		return resp;
		
	}
	
	@PostMapping(value="admins/appRecruiter/{Application_Id}/{Recruiter_Id}")
	public ResponseEntity<String> assignRecruiter(@PathVariable("Application_Id") int appId,@PathVariable("Recruiter_Id") int recId) {
		String proc = service.assignRecruiter(appId, recId);
		ResponseEntity<String> resp = new ResponseEntity<String>(proc, HttpStatus.OK);
		return resp;
	}

}

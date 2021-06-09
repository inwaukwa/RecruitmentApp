package cogent.recruitment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cogent.recruitment.dao.ApplicantDao;
import cogent.recruitment.entities.Applicant;
import cogent.recruitment.exception.ResourceNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	ApplicantDao applicantDao;

	@Override
	public List<Applicant> getAllApplicants() {
		List<Applicant> applicantList = applicantDao.findAll();
		return applicantList;
	}

	@Override
	public Applicant getApplicantById(Integer id) {
		Applicant applicant = applicantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Applicant with ID: " + id + " not found."));
		return applicant;
	}

	@Override
	public List<Applicant> getApplicantsByNameContaining(String name) {
		List<Applicant> applicants = applicantDao.findByNameContaining(name).orElseThrow(
				() -> new ResourceNotFoundException("No applicants with name containing: " + name + " found."));
		return applicants;
	}

	@Override
	@Transactional
	public String saveApplicant(Applicant applicant) {
		applicant.setPassword(new BCryptPasswordEncoder().encode(applicant.getPassword()));
		String applicantDetails = applicantDao.save(applicant).toString();
		return applicantDetails;
	}

	@Override
	@Transactional
	public String updateApplicant(Applicant applicant) {
		String applicantDetails = applicantDao.save(applicant).toString();
		return applicantDetails;
	}

	@Override
	public boolean doesApplicantExist(Integer id) {
		return applicantDao.existsById(id);
	}

	@Override
	public Applicant getApplicantByEmail(String email) {
		Applicant applicant = applicantDao.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("No applicant with the specified email exists"));
		return applicant;
	}

}

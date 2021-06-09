package cogent.recruitment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import cogent.recruitment.entities.Application;

@CrossOrigin
public interface ApplicationDao extends JpaRepository<Application, Integer> {

	// find applications by applicant id
	@Query("select a from Application a where a.applicant.id = :id")
	Optional<List<Application>> findByApplicantId(Integer id);

	// find applications by job id
	@Query("select a from Application a where a.job.id = :id")
	Optional<List<Application>> findByJobId(Integer id);

	// find application by recruiter id
	@Query("select a from Application a where a.recruiter.id = :id")
	Optional<List<Application>> findByRecruiterId(Integer id);
	
}


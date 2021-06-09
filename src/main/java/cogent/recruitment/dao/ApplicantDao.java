package cogent.recruitment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import cogent.recruitment.entities.Applicant;

@CrossOrigin
public interface ApplicantDao extends JpaRepository<Applicant, Integer> {
	
	@Query("select a from Applicant a where a.firstName like %:name% OR  a.lastName like %:name%")
	Optional<List<Applicant>> findByNameContaining(String name);
	
	@Query("select a from Applicant a where a.email = :email")
	Optional<Applicant> findByEmail(String email);

}

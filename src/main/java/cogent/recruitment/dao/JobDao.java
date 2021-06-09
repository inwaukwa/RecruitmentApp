package cogent.recruitment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import cogent.recruitment.entities.Job;

@Repository
@CrossOrigin
public interface JobDao extends JpaRepository<Job, Integer> {

}

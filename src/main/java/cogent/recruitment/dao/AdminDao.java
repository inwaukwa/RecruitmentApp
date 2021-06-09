package cogent.recruitment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import cogent.recruitment.entities.Admin;

@CrossOrigin()
public interface AdminDao extends JpaRepository<Admin, Integer>{
	
	List<Admin> findByrolesId(int roleId);
	
	@Query(value = "from Admin a where a.firstName LIKE CONCAT('%',:text,'%') or a.lastName LIKE CONCAT('%',:text,'%') or CONCAT(a.firstName,' ',a.lastName) LIKE CONCAT('%',:text,'%')")
	public List<Admin> findByname(@Param("text") String name);
	
}

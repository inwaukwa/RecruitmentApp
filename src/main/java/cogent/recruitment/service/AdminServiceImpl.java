package cogent.recruitment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cogent.recruitment.dao.AdminDao;
import cogent.recruitment.dao.ApplicationDao;
import cogent.recruitment.dao.RoleDao;
import cogent.recruitment.entities.Admin;
import cogent.recruitment.entities.Application;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adDao;
	
	@Autowired
	ApplicationDao appDao;
	
	@Autowired
	RoleDao roleDao;

	@Override
	@Transactional
	public String addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adDao.save(admin);
		return admin.getFirstName() +" "+ admin.getLastName() +" "+ admin.getEmail();
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adDao.findAll();
	}

	@Override
	public List<Admin> getRecruiters() {
		// TODO Auto-generated method stub
		return adDao.findByrolesId(1);
	}

	@Override
	public List<Admin> getManagers() {
		// TODO Auto-generated method stub
		return adDao.findByrolesId(2);
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adDao.findById(id).get();
	}
	
	@Override
	public List<Admin> getAdminByName(String name) {
		// TODO Auto-generated method stub
		return adDao.findByname(name);
	}

	@Override
	@Transactional
	public String assignRecruiter(int applicationId, int recruiterId) {
		// TODO Auto-generated method stub
		Optional<Application> app = appDao.findById(applicationId);
		Optional<Admin> rec = adDao.findById(recruiterId);
		if (app.isPresent() && rec.isPresent()) {
			if(rec.get().getRoles().contains(roleDao.getById(1))) {
				app.get().setRecruiter(rec.get());
				appDao.save(app.get()); 
				return "Successfully assigned Recruiter to Application";
			} else {
				return "Admin is not a recruiter";
			}
		} else {
			return "Application Id or Recruiter Id is not valid";
		}
		
	}
	
	

}

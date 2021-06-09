package cogent.recruitment.service;

import java.util.List;

import cogent.recruitment.entities.Admin;
import cogent.recruitment.entities.Application;

public interface AdminService {
	
	public String addAdmin(Admin admin);
	
	public String assignRecruiter(int appId, int recId);
	
	public List<Admin> getAdmins();
	
	public List<Admin> getRecruiters();
	
	public List<Admin> getManagers();
	
	public Admin getAdminById(int id);

	List<Admin> getAdminByName(String name);
	
}

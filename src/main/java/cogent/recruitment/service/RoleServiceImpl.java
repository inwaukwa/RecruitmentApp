package cogent.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cogent.recruitment.dao.RoleDao;
import cogent.recruitment.entities.Role;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleDao dao;

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
	
}

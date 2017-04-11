package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.MaintananceDao;
import com.infor.models.InforRoles;
import com.infor.models.InforUser;
import com.infor.service.MaintenanceService;

@Service
public class MaintenanceIService implements MaintenanceService{
	
	@Autowired
	private MaintananceDao md;

	@Override
	public List<InforUser> getUser(InforUser user) {
		// TODO Auto-generated method stub
		return md.getUser(user);
	}

	@Override
	public void saveUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InforRoles> selectRoles() {
		// TODO Auto-generated method stub
		return md.selectRoles();
	}

}

package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.MaintananceDao;
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

}

package com.infor.service;

import java.util.List;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforRoles;
import com.infor.models.InforUser;

public interface MaintenanceService {
	public UserMaintenanceDTO getUser(InforUser user);
	public void saveUser(InforUser user);
	public void updateUser(InforUser user);
	public void removeUser(InforUser user);
	public void modifyuser(UserMaintenanceDTO dto);
	public List<InforRoles> selectRoles();
	
	public void saveRegistration(UserMaintenanceDTO dto);
	public boolean isUsernameExisting(UserMaintenanceDTO dto);
	
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto);
}	

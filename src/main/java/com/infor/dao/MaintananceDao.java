package com.infor.dao;

import java.util.List;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforRoles;
import com.infor.models.InforUser;

public interface MaintananceDao {
	public List<InforUser> getUser(InforUser user);
	public void saveUser(InforUser user);
	public void updateUser(InforUser user);
	public void removeUser(InforUser user);
	
	public List<InforRoles> selectRoles();
	public void saveRegistration(InforUser user);
	public void modifyUser(InforUser user);
	public boolean isUsernameExisting(InforUser user);
	
	public void deleteRole(UserMaintenanceDTO dto);
	public void saveRole(InforRoles roles);
}

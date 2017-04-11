package com.infor.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforUser;
import com.infor.service.MaintenanceService;

@RestController
public class MaintenanceEndpoint {

	@Autowired
	private MaintenanceService s;
	
	@GetMapping("/getuser")
	public List<InforUser> getUser(@RequestParam int id){
		InforUser u = new InforUser();
		u.setUserid(id);
		return s.getUser(u);
	}
	
	@GetMapping("/getroles")
	public UserMaintenanceDTO getRoles(){
		UserMaintenanceDTO dto = new UserMaintenanceDTO();
		dto.setInforRoles(s.selectRoles());
		return dto;
	}
}

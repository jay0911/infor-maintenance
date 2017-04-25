package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.AjaxResponseBody;
import com.infor.service.MaintenanceService;

@RestController
public class MaintenanceEndpoint {

	@Autowired
	private MaintenanceService s;
	
	@PostMapping("/registeruserservice")
	public AjaxResponseBody saveRegistration(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		if(s.isUsernameExisting(dto)){
			response.setMsg("user exist");
			response.setCode("400");
			return response;
		}
		
		s.saveRegistration(dto);	
		response.setMsg("success");
		response.setCode("200");
		return response;
	}
	
	@GetMapping("/getroles")
	public UserMaintenanceDTO getRoles(){
		UserMaintenanceDTO dto = new UserMaintenanceDTO();
		dto.setInforRoles(s.selectRoles());
		return dto;
	}
	
	@PostMapping("/checkcredentials")
	public UserMaintenanceDTO checkCredentials(@RequestBody UserMaintenanceDTO dto){
		return s.getUser(dto.getInforUser());
	}
	
	@PostMapping("/getuserinfo")
	public UserMaintenanceDTO currentuserinfo(@RequestBody UserMaintenanceDTO dto){
		return s.getuserloggedinInfo(dto);
	}
	
	@PostMapping("/modifyuser")
	public AjaxResponseBody modifyAccount(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		

		try{
			s.modifyuser(dto);	
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/deleterole")
	public AjaxResponseBody deleterole(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.deleteRole(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/saverole")
	public AjaxResponseBody saverole(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.saveRole(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/savecar")
	public AjaxResponseBody savecar(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.saveCar(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/editcar")
	public AjaxResponseBody editcar(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.editCar(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/deletecar")
	public AjaxResponseBody deletecar(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.deleteCar(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/selectcar")
	public UserMaintenanceDTO selectcar(@RequestBody UserMaintenanceDTO dto){
		UserMaintenanceDTO returndto = new UserMaintenanceDTO();
		returndto.setInforCars(s.selectCars(dto));
		return returndto;
	}
	
	
	@PostMapping("/selectparking")
	public UserMaintenanceDTO selectParking(@RequestBody UserMaintenanceDTO dto){
		UserMaintenanceDTO returndto = new UserMaintenanceDTO();
		returndto.setInforParkings(s.selectParking(dto));
		return returndto;
	}
}

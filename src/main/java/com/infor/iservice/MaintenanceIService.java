package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.MaintananceDao;
import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforCar;
import com.infor.models.InforRoles;
import com.infor.models.InforUser;
import com.infor.service.MaintenanceService;
/**
 * 
 * @author joliveros
 * @see InforUser
 * @since 1.0
 */
@Service
public class MaintenanceIService implements MaintenanceService{
	
	@Autowired
	private MaintananceDao md;

	@Override
	public UserMaintenanceDTO getUser(InforUser user) {
		// TODO Auto-generated method stub
		List<InforUser> users = md.getUser(user);
		UserMaintenanceDTO dto = new UserMaintenanceDTO();
		dto.setInforUser(users.get(0));
		return dto; 
	}

	@Override
	public void saveUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(InforUser user) {
		// TODO Auto-generated method stub
		md.updateUser(user);
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

	@Override
	public void saveRegistration(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforUser user = new InforUser();
		setUserFromDTO(dto,user);
		md.saveRegistration(user);
	}
	
	private void setUserFromDTO (UserMaintenanceDTO dto,InforUser user){
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setEmailaddress(dto.getEmailaddress());
		user.setInforaddress(dto.getAddress());
		user.setContactnumber(dto.getContactnumber());
		user.setPosition(dto.getPosition());
		user.setGender(dto.getGender());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
	}

	@Override
	public boolean isUsernameExisting(UserMaintenanceDTO dto) {
		InforUser u = new InforUser();
		this.setUserFromDTO(dto,u);
		return md.isUsernameExisting(u);
	}

	@Override
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforUser user = new InforUser();
		user.setUsername(dto.getUsername());
		return this.getUser(user);
	}

	@Override
	public void modifyuser(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforUser u = new InforUser();
		this.setUserFromDTO(dto,u);
		this.updateUser(u);
	}

	@Override
	public void deleteRole(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		md.deleteRole(dto);
	}

	@Override
	public void saveRole(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforRoles role = new InforRoles();
		role.setRole(dto.getPosition());
		md.saveRole(role);
	}

	@Override
	public void deleteCar(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		md.deleteCar(dto);
	}

	@Override
	public void saveCar(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforCar inforCar = new InforCar();
		InforUser user = new InforUser();
		user.setUserid(dto.getUserid());
		inforCar.setCarbrand(dto.getCarbrand());
		inforCar.setCarcolor(dto.getCarcolor());
		inforCar.setCarplatenumber(dto.getCarplatenumber());
		inforCar.setInforUser(user);
		
		md.saveCar(inforCar);
	}

	@Override
	public void editCar(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforCar inforCar = new InforCar();
		inforCar.setCarbrand(dto.getCarbrand());
		inforCar.setCarcolor(dto.getCarcolor());
		inforCar.setCarplatenumber(dto.getCarplatenumber());
		md.editCar(inforCar);
	}

	@Override
	public List<InforCar> selectCars() {
		// TODO Auto-generated method stub
		return md.selectCars();
	}

}

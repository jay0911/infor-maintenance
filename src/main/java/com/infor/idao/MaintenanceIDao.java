package com.infor.idao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.infor.dao.MaintananceDao;
import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforCar;
import com.infor.models.InforRoles;
import com.infor.models.InforUser;

@Repository
@Transactional
public class MaintenanceIDao extends HibernateDaoSupport implements MaintananceDao{

	private static final String USER_FETCH_HQL = "from InforUser where username=:username";
	private static final String ROLES_FETCH_HQL = "from InforRoles";
	private static final String ROLES_DELETE_HQL = "delete from InforRoles where role=:role";
	
	private static final String USER_MODIFY_HQL = "update InforUser set firstname=:firstname, lastname=:lastname,contactnumber=:contactnumber, emailaddress=:emailaddress, inforaddress=:inforaddress,position=:position,gender=:gender,username=:username,password=:password where username=:username";
	
	private static final String USERCAR_MODIFY_HQL = "update InforCar set carbrand=:carbrand, carcolor=:carcolor where carplatenumber=:carplatenumber";
	private static final String USERCAR_DELETE_HQL = "delete from InforCar where carplatenumber=:carplatenumber";
	
	private static final String CAR_FETCH_HQL = "from InforCar where userid=:userid";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InforUser> getUser(InforUser user) {
		// TODO Auto-generated method stub
		return customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
	}

	@Override
	public void saveUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(InforUser user) {
		// TODO Auto-generated method stub
		Query q= getSessionFactory().createQuery(USER_MODIFY_HQL);
		q.setParameter("firstname", user.getFirstname());
		q.setParameter("lastname", user.getLastname());
		q.setParameter("contactnumber", user.getContactnumber());
		q.setParameter("emailaddress", user.getEmailaddress());
		q.setParameter("inforaddress", user.getInforaddress());
		q.setParameter("position", user.getPosition());
		q.setParameter("gender", user.getGender());
		q.setParameter("username", user.getUsername());
		q.setParameter("password", user.getPassword());
		q.executeUpdate();
	}

	@Override
	public void removeUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforRoles> selectRoles() {
		// TODO Auto-generated method stub
		return customSelectQuery(ROLES_FETCH_HQL)
				.list();
	}

	@Override
	public void saveRegistration(InforUser user) {
		// TODO Auto-generated method stub
		getSessionFactory().save(user);
	}

	@Override
	public void modifyUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUsernameExisting(InforUser user) {
		List<InforUser> userlist = customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
		if(userlist.size() > 0){
			return true;
		}
		return false;
	}

	@Override
	public void deleteRole(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		Query query = getSessionFactory().createQuery(ROLES_DELETE_HQL);
	    query.setParameter("role", dto.getPosition());
	    int deleted = query.executeUpdate();
	    System.out.println("Deleted: " + deleted + " user(s)");
	}

	@Override
	public void saveRole(InforRoles roles) {
		// TODO Auto-generated method stub
		getSessionFactory().save(roles);
	}

	@Override
	public void deleteCar(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		Query query = getSessionFactory().createQuery(USERCAR_DELETE_HQL);
	    query.setParameter("carplatenumber", dto.getCarplatenumber());
	    int deleted = query.executeUpdate();
	    System.out.println("Deleted: " + deleted + " Cars(s)");
	}

	@Override
	public void saveCar(InforCar inforCar) {
		// TODO Auto-generated method stub
		getSessionFactory().save(inforCar);
	}

	@Override
	public void editCar(InforCar inforCar) {
		// TODO Auto-generated method stub
		Query q= getSessionFactory().createQuery(USERCAR_MODIFY_HQL);
		q.setParameter("carbrand", inforCar.getCarbrand());
		q.setParameter("carcolor", inforCar.getCarcolor());
		q.setParameter("carplatenumber", inforCar.getCarplatenumber());
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforCar> selectCars(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		return customSelectQuery(CAR_FETCH_HQL)
				.setParameter("userid", dto.getUserid())
				.list();
	}
}

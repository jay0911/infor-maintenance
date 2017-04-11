package com.infor.idao;

import java.util.List;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.infor.dao.MaintananceDao;
import com.infor.models.InforRoles;
import com.infor.models.InforUser;

@Repository
@Transactional
public class MaintenanceIDao extends HibernateDaoSupport implements MaintananceDao{

	private static final String USER_FETCH_HQL = "from InforUser where userid=:userid";
	private static final String ROLES_FETCH_HQL = "from InforRoles";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InforUser> getUser(InforUser user) {
		// TODO Auto-generated method stub
		return customSelectQuery(USER_FETCH_HQL)
				.setParameter("userid", user.getUserid())
				.list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<InforRoles> selectRoles() {
		// TODO Auto-generated method stub
		return customSelectQuery(ROLES_FETCH_HQL)
				.list();
	}
}

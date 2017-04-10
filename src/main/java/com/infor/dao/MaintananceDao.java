package com.infor.dao;

import java.util.List;

import com.infor.models.InforUser;

public interface MaintananceDao {
	public List<InforUser> getUser(InforUser user);
}

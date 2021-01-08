package com.hm.internal.idm.business.service;

import java.util.List;

import com.hm.internal.idm.web.model.RoleDto;
import com.hm.internal.idm.dataaccess.entity.Role;

public interface RoleService {

	
	public List<Role> getAllRoles();
	public Boolean createRole(Role roleObject);
	public Boolean deleteRole(int id);
	public Role findByDescription(String description);
	public Role findById(Long id);
	public boolean updateRoleByid(Long id , RoleDto roleObject);
	
	
}

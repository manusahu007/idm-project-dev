package com.hm.internal.idm.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.internal.idm.dataaccess.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByDescription(String Description );
	//List<Role> getAllRolesByPermissions();
}

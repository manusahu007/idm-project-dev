package com.hm.internal.idm.business.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.internal.idm.dataaccess.repository.PermissionRepository;
import com.hm.internal.idm.dataaccess.repository.RoleRepository;
import com.hm.internal.idm.dataaccess.repository.UserRepository;
import com.hm.internal.idm.dataaccess.entity.Permission;
import com.hm.internal.idm.dataaccess.entity.Role;
import com.hm.internal.idm.dataaccess.entity.User;
import com.hm.internal.idm.business.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	  Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	 Map<Object, Object> response ;
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PermissionRepository permissionRepo;
	
	@Override
	public Object getAllPermission() {
		logger.info("in side getAllPermission function");
      List<Role> roles =roleRepo.findAll();
      List<User> users = userRepo.findAll();
      
      response = new LinkedHashMap<>();
      response.put("users", users);
      response.put("roles", roles);
      return response;
	}

	
	@Override
	public Object getAllPermissionByFeature(String feature) {
		logger.info("in side getAllPermissionByFeature function");
	List<Permission> perm=	permissionRepo.findByFeature(feature);
	  response = new LinkedHashMap<>();
	  response.put("permissions", perm);
		return response;
	}

}

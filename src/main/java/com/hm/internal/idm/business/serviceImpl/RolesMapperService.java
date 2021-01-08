package com.hm.internal.idm.business.serviceImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.internal.idm.dataaccess.repository.PermissionRepository;
import com.hm.internal.idm.dataaccess.repository.RoleRepository;
import com.hm.internal.idm.web.model.RoleDto;
import com.hm.internal.idm.dataaccess.entity.Permission;
import com.hm.internal.idm.dataaccess.entity.Role;


@Service
public class RolesMapperService {
	@Autowired
	PermissionRepository permissionRepo;
	@Autowired
	RoleRepository roleRepository;
	Set<Permission> listp= new  LinkedHashSet<>();
	public Role getRoleObject(RoleDto dto){
		Role role =new Role();
		Long id= new Long(roleRepository.count()+1);
		role.setId(id);
		System.out.println("roleRepository.count()2---"+id);
		role.setDescription(dto.getDescription());
		role.setName(dto.getName());
		List<Integer> perm = dto.getPermissionIds();
        for (Integer inn : perm) {
        	Optional<Permission> opt=	permissionRepo.findById( (long) inn);
        	if(opt.isPresent()) {
        		 listp.add(opt.get());
        	}
	   
		} 
        role.setPermissions(listp);
        
		return role;
	}
}

package com.hm.internal.idm.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.internal.idm.dataaccess.repository.RoleRepository;
import com.hm.internal.idm.web.model.RoleDto;
import com.hm.internal.idm.dataaccess.entity.Role;
import com.hm.internal.idm.business.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleReo;


    @Autowired
    RolesMapperService rolesMapperService;

    @Override
    public List<Role> getAllRoles() {
        return roleReo.findAll();
    }

    @Override
    public Boolean createRole(Role roleObject) {
        Role role = roleReo.save(roleObject);
        if (role != null)
            return true;
        else
            return false;
    }

    @Override
    public Boolean deleteRole(int id) {
        roleReo.deleteById((long) id);
        return true;
    }

    @Override
    public Role findByDescription(String description) {
        //Role r = roleReo.findByDescription(description);
        return roleReo.findByDescription(description);
    }

    @Override
    public Role findById(Long id) {
        // TODO Auto-generated method
		System.out.println("Inside findBy Id");
        return roleReo.findById(id).get();
    }

    public boolean updateRoleByid(Long id, RoleDto roleObject) {
        boolean flag = false;
        Role obj = rolesMapperService.getRoleObject(roleObject);
        Role objj = findById(id);

//		 if(objj.isPresent()) {
//        Role obj2 = roleReo.findById((long) id).get();
        objj.setName(obj.getName());
        objj.setDescription(obj.getDescription());
        objj.setPermissions(obj.getPermissions());
        roleReo.save(objj);
        return true;
//		 }
//		return flag;

    }


}

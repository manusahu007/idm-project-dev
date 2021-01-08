package com.hm.internal.idm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.internal.idm.web.model.ResponseObject;
import com.hm.internal.idm.web.model.RoleDto;
import com.hm.internal.idm.dataaccess.entity.Role;
import com.hm.internal.idm.business.service.RoleService;
import com.hm.internal.idm.business.serviceImpl.RolesMapperService;

@RequestMapping(value="api")
@RestController
public class RoleController {

	@Autowired
	RoleService roleService;
	
	
	@Autowired
	RolesMapperService rolesMapperService;
	
	@PostMapping(value="/roles")
	public ResponseEntity<Object>  createRole(@RequestBody RoleDto roleObject) {
		 Role exits = roleService.findByDescription(roleObject.getDescription());
		 ResponseObject responseObject = new ResponseObject();
		 ResponseEntity<Object> response=null;
	   if(exits instanceof Role) {
		 
		   responseObject.setMessage("Role Already Exited");
	   }
	   else {
		   Role obj = rolesMapperService.getRoleObject(roleObject);
			 
		    //roleService.findByDescription(roleObject.getDescription());
		 Boolean result= roleService.createRole(obj);
		 responseObject.setMessage("Role Created Successfully");
	   }
		 responseObject.setCode(201);
		 responseObject.setApplicationErrorCode(1);	
		 response=new ResponseEntity<Object>(responseObject,HttpStatus.OK);
		 return response;
	}
	
	@GetMapping(value="/roles")
	public ResponseEntity<List<Role>> getRoles() {
		ResponseEntity<List<Role>> response=null;
		
		List<Role> roles=  roleService.getAllRoles();
		
		//List<Role> roles=  roleService.getAllRolesBypermissions();
		response=new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
		 return response;
	}

	@PutMapping(value = "/roles/{id}")
	public ResponseEntity<Object>  updateRole(@PathVariable Long id , @RequestBody RoleDto roleObject) {
		ResponseEntity<Object> response=null;	
		 ResponseObject responseObject = new ResponseObject();
		if(roleService.updateRoleByid(id, roleObject)) {
		 
		   responseObject.setMessage("Role updates Successfully");
	   }
	   else {
		  
		 responseObject.setMessage("Role update failed");
	   }
		 responseObject.setCode(201);
		 responseObject.setApplicationErrorCode(1);	
		 response=new ResponseEntity<Object>(responseObject,HttpStatus.OK);
		 return response;
		
	}
	
	@DeleteMapping(value="/roles/{id}")
	public ResponseEntity<Object>  deleteRole(@PathVariable int id) {
		ResponseEntity<Object> response=null;
		Boolean result=roleService.deleteRole(id);
		response=new ResponseEntity<Object>("Role deleted sucessfully", HttpStatus.OK);
		return response;
	}
	@GetMapping(value = "/roles/{id}")
	public ResponseEntity<Object> getRole(@PathVariable int id) {
		Role role = roleService.findById(new Long(id));
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(role, HttpStatus.OK);
		return response;
	}
}

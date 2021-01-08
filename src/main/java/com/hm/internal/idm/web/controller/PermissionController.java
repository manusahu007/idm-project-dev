package com.hm.internal.idm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hm.internal.idm.business.service.PermissionService;

@RestController
@RequestMapping(value="api")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;

	@GetMapping(value="/permissions")
	public ResponseEntity<Object>  getAllPermissions() {
		ResponseEntity<Object> response=null;
		 Object object= permissionService.getAllPermission();
		 response=new ResponseEntity<Object>(object, HttpStatus.OK);
		 return response;
	}
	
	@GetMapping(value="/permissions/search")
	public ResponseEntity<Object>  getAllPermissionsByFeature(@RequestParam String feature) {
		
		 ResponseEntity<Object> response=null;
		 Object object= permissionService.getAllPermissionByFeature(feature);
		 response=new ResponseEntity<Object>(object, HttpStatus.OK);
		 return response;
	}
	
}

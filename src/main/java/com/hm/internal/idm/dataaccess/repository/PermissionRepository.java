package com.hm.internal.idm.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.internal.idm.dataaccess.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

	List<Permission> findByFeature(String feature);

}

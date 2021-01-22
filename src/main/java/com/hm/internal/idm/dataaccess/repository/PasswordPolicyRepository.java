package com.hm.internal.idm.dataaccess.repository;

import com.hm.internal.idm.dataaccess.entity.PasswordPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordPolicyRepository extends JpaRepository<PasswordPolicy, Long> {
}

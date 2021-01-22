package com.hm.internal.idm.business.serviceImpl;

import com.hm.internal.idm.business.service.PasswordPolicyService;
import com.hm.internal.idm.business.service.UserService;
import com.hm.internal.idm.dataaccess.entity.PasswordPolicy;
import com.hm.internal.idm.dataaccess.entity.User;
import com.hm.internal.idm.dataaccess.repository.PasswordPolicyRepository;
import com.hm.internal.idm.dataaccess.repository.UserRepository;
import com.hm.internal.idm.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PasswordPolicyServiceImpl implements PasswordPolicyService {

        @Autowired
        private PasswordPolicyMapperService passwordPolicyMapperService;

        @Autowired
        private PasswordPolicyRepository passwordPolicyDAO;
        @Override
        public boolean createPasswordPolicy(PasswordPolicyDto passwordPolicyDto) {
                PasswordPolicy passwordPolicy = passwordPolicyMapperService.getPasswordPolicy(passwordPolicyDto);
                passwordPolicy = passwordPolicyDAO.save(passwordPolicy);
                if (null != passwwordPolicy) {
                        return true;
                } else {
                        return false;
                }
        }



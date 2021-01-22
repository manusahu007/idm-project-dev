package com.hm.internal.idm.business.serviceImpl;

import com.fasterxml.uuid.Generators;
import com.hm.internal.idm.dataaccess.entity.Role;
import com.hm.internal.idm.dataaccess.entity.User;
import com.hm.internal.idm.dataaccess.repository.RoleRepository;
import com.hm.internal.idm.dataaccess.repository.UserRepository;
import com.hm.internal.idm.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UserMapperService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private Set<Role> rolesSet = new LinkedHashSet<>();

    public User getUser(UserDto userDto) {


        User user = new User();
        Long id= new Long(userRepository.count()+1);
        user.setName(userDto.getName());
        user.setEmailId(userDto.getEmailId());
        user.setUserType(1);
        user.setEnterpriseCode (Generators.timeBasedGenerator().generate().toString());
        user.setUserName(userDto.getUserName());
        System.out.println(userDto.getRoles());
        if (userDto.getRoles ()!=null)
        for(String role:userDto.getRoles()) {
             Role opt = roleRepository.findByDescription(role);
            if(null != opt) {
                rolesSet.add(opt);
            }
        }

        user.setRolesSet
                (rolesSet);
        return user;
    }



}

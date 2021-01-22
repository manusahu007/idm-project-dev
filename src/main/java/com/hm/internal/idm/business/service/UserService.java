package com.hm.internal.idm.business.service;

import java.util.List;

import com.hm.internal.idm.dataaccess.entity.User;
import com.hm.internal.idm.web.model.UserDto;

public interface UserService {

	public boolean createUser(UserDto userDto);

	public List<User> getUsers();

	public boolean deleteByUserId(Long id);
}

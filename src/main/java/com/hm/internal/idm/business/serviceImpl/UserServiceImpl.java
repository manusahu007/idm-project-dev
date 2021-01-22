package com.hm.internal.idm.business.serviceImpl;

import java.util.List;

import com.hm.internal.idm.dataaccess.repository.UserRepository;
import com.hm.internal.idm.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import com.hm.internal.idm.dataaccess.entity.User;
import com.hm.internal.idm.business.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapperService userMapperService;

	@Autowired
	private UserRepository userDAO;

	@Override
	public List<User> getUsers() {

		List<User> users = null;

		try {
			users = userDAO.findAll();
		} catch(Exception ex) {
			System.out.println("Exception while fetching all users "+ ex);
		}
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public boolean createUser(UserDto userDto) {
		User user = userMapperService.getUser(userDto);
		user = userDAO.save(user);
		if (null != user) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByUserId(Long id) {
		try {
			userDAO.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}

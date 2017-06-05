package com.xyd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyd.dao.UserDao;
import com.xyd.entity.User;
import com.xyd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDao userDao;
	
	
	@Override
	public String userQuery() throws Exception {
		List<User> users = userDao.testQuery();
        String res = "";
        if (users != null && users.size() > 0) {
            for (User user : users) {
                res += user.toString() + "|";
            }
        } else {
            res = "Not found.";
        }
        return res;
	}

}

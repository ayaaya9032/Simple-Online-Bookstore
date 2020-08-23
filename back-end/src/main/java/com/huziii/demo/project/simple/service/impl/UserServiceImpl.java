package com.huziii.demo.project.simple.service.impl;

import com.huziii.demo.project.simple.bean.User;
import com.huziii.demo.project.simple.repository.UserRepository;
import com.huziii.demo.project.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User login(String name, String password) {
        return repository.findByNameAndPassword(name, password);
    }

}

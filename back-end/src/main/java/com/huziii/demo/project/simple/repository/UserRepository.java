package com.huziii.demo.project.simple.repository;

import com.huziii.demo.project.simple.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByNameAndPassword(String name, String password);

}

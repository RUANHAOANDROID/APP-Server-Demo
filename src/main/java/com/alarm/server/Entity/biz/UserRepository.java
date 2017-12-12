package com.alarm.server.Entity.biz;

import org.springframework.data.repository.CrudRepository;

import com.alarm.server.Entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}


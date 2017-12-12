package com.alarm.server.Entity.biz;

import org.springframework.data.repository.CrudRepository;

import com.alarm.server.Entity.Emergency;

public interface EmergencyRepository extends CrudRepository<Emergency, Long> {

}

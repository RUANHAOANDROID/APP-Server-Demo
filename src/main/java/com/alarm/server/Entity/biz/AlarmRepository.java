package com.alarm.server.Entity.biz;

import org.springframework.data.repository.CrudRepository;

import com.alarm.server.Entity.Alarm;


public interface AlarmRepository extends CrudRepository<Alarm, Long>{

}

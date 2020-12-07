package com.td1.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.td1.model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

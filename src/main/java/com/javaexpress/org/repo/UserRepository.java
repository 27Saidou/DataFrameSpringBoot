package com.javaexpress.org.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaexpress.org.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}

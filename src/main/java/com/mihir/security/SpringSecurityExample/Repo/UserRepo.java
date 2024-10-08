package com.mihir.security.SpringSecurityExample.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihir.security.SpringSecurityExample.Model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{

	UserModel findByUsername(String username);

}

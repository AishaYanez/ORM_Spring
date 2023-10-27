package com.aisha.appGallery.entity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aisha.appGallery.entity.models.User;

public interface IUserDao extends CrudRepository<User,Long>{
	public User findUserByEmail(@Param("email") String email);
}

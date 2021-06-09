package com.security.appsecurity1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.appsecurity1.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    
	
	public abstract Optional<AppUser> findAppUserByUsername(String username);
}

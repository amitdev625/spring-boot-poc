/*
 * package com.security.appsecurity1.service;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * 
 * import com.security.appsecurity1.entity.AppUser; import
 * com.security.appsecurity1.model.AppUserDTO; import
 * com.security.appsecurity1.repository.AppUserRepository;
 * 
 * 
 * public class JpaUserDetailsService implements UserDetailsService {
 * 
 * @Autowired private AppUserRepository appUserRepository;
 * 
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Optional<AppUser> appUserOptional =
 * appUserRepository.findAppUserByUsername(username.trim()); AppUser appUser =
 * appUserOptional.orElseThrow(()-> new UsernameNotFoundException(username));
 * AppUserDTO userDTO = new AppUserDTO(appUser.getUsername(),
 * appUser.getPassword()); return userDTO; }
 * 
 * }
 * 
 * 
 */
package com.app.instrumentos.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.instrumentos.model.User;
import com.app.instrumentos.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<com.app.instrumentos.model.User> user = userRepository.findByUsername(username);
    if (!user.isPresent()) {
    	throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }

    return UserDetailsImpl.build(user.get());
  }

}
package org.epcorps.usuarioservice.services.impl;

import org.epcorps.usuarioservice.persistence.entities.UserEntity;
import org.epcorps.usuarioservice.persistence.models.dtos.LoginDto;
import org.epcorps.usuarioservice.persistence.repositories.UserRepository;
import org.epcorps.usuarioservice.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public UserEntity userRegister(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity loginUser(LoginDto userEntity) {
        return null;
    }
}

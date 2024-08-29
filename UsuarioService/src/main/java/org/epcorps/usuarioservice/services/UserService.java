package org.epcorps.usuarioservice.services;

import org.epcorps.usuarioservice.persistence.entities.UserEntity;
import org.epcorps.usuarioservice.persistence.models.dtos.LoginDto;

public interface UserService {
    public UserEntity getUserById(Long id);
    public UserEntity userRegister(UserEntity userEntity);
    public UserEntity loginUser(LoginDto userEntity);
}

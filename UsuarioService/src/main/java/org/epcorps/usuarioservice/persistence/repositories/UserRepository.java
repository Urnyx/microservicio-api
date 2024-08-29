package org.epcorps.usuarioservice.persistence.repositories;

import org.epcorps.usuarioservice.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

package com.aluracursos.challenges.forohub.domain.user.profile;

import com.aluracursos.challenges.forohub.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

    Optional<ProfileEntity> findByUsername(String name);

}

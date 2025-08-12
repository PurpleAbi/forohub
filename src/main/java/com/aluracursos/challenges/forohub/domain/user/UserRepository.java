package com.aluracursos.challenges.forohub.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("""
        SELECT u
          FROM User u
          JOIN u.profile p
         WHERE p.username = :username
    """)
    UserEntity findByProfileUsername(String username);
}

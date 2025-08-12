package com.aluracursos.challenges.forohub.service;

import com.aluracursos.challenges.forohub.domain.user.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForoHub")
                    .withSubject(user.getProfile().getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(Date.from(Instant.now().plus(Duration.ofHours(2)))) // Token valid for 2 hours
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {

        if (tokenJWT == null) {
            throw new RuntimeException();
        }
        DecodedJWT verifier;
        try {
            var algorithm = Algorithm.HMAC256(secret);
            verifier = JWT.require(algorithm)
                    .withIssuer("API ForoHub")
                    .build()
                    .verify(tokenJWT);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido o expirado!");
        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verifier invalido");
        }
        return verifier.getSubject();
    }
}


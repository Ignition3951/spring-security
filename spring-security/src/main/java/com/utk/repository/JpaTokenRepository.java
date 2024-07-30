package com.utk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utk.model.Token;

public interface JpaTokenRepository extends JpaRepository<Token, Integer> {

	Optional<Token> findTokenByIdentifier(String identifier);

}

package br.com.scheiner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.scheiner.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUsername(String username);
}

package org.delivery.db.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findFIrstByIdAndStatusOrderByIdDesc(Long id, String status);

	Optional<UserEntity> findFIrstByEmailAndPasswordAndStatusOrderByIdDesc(
		String email,
		String password,
		String status
	);
}

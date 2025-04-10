package org.delivery.db.user;

import java.util.Optional;

import org.delivery.db.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);

	Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(
		String email,
		String password,
		UserStatus status
	);
}

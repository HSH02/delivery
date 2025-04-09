package org.delivery.api.domain.user.service;

import java.time.LocalDate;
import java.util.Optional;

import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.user.UserEntity;
import org.delivery.db.user.UserRepository;
import org.delivery.db.user.enums.UserStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	public UserEntity register(UserEntity entity){
		return Optional.ofNullable(entity)
			.map(it -> {
				entity.setStatus(UserStatus.REGISTERED);
				entity.setRegisteredAt(LocalDate.now());
				return userRepository.save(entity);
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "User Entity Null"));
	}
}

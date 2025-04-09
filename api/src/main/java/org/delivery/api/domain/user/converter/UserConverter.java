package org.delivery.api.domain.user.converter;

import java.util.Optional;

import org.delivery.api.common.annotation.Converter;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.db.user.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter
public class UserConverter {

	public UserEntity toEntity(UserRegisterRequest request) {
		return Optional.ofNullable(request)
			.map(it -> {
				return UserEntity.builder()
					.name(it.getName())
					.email(it.getEmail())
					.password(it.getPassword())
					.address(it.getAddress())
					.build();
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
	}

	public UserResponse toResponse(UserEntity entity) {
		return Optional.ofNullable(entity)
			.map(it -> {
				return UserResponse.builder()
					.id(it.getId())
					.name(it.getName())
					.email(it.getEmail())
					.address(it.getAddress())
					.status(it.getStatus())
					.registeredAt(it.getRegisteredAt())
					.unregisteredAt(it.getUnregisteredAt())
					.lastLoginAt(it.getLastLoginAt())
					.build();
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
	}
}

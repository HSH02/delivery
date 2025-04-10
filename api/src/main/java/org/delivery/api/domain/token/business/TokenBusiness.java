package org.delivery.api.domain.token.business;

import java.util.Optional;

import org.delivery.api.common.annotation.Business;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.token.converter.TokenConverter;
import org.delivery.api.domain.token.service.TokenService;
import org.delivery.api.domain.user.service.UserService;
import org.delivery.db.BaseEntity;
import org.delivery.db.user.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

	private final TokenService tokenService;
	private final TokenConverter tokenConverter;

	/**
	 * 1. user entity userId 추출
	 * 2. access refreshTOekn 발행
	 * 3. converter -> token response로 발행
	 */
	public TokenResponse issueToken(UserEntity userEntity) {

		return Optional.ofNullable(userEntity)
			.map(BaseEntity::getId)
			.map(userId -> {
				var accessToken = tokenService.issueAccessToken(userId);
				var refreshToken = tokenService.issueRefreshToken(userId);
				return tokenConverter.toResponse(accessToken, refreshToken);
			})
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
	}
}

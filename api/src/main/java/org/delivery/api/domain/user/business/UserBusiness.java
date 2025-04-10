package org.delivery.api.domain.user.business;

import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.token.business.TokenBusiness;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.converter.UserConverter;
import org.delivery.api.domain.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class UserBusiness {

	private final UserService userService;
	private final UserConverter userConverter;
	private final TokenBusiness tokenBusiness;

	public UserResponse register(UserRegisterRequest request) {
		var entity = userConverter.toEntity(request);
		var newEntity = userService.register(entity);
		var response = userConverter.toResponse(newEntity);
		return response;

/*		return Optional.ofNullable(request)
			.map(userConverter::toEntity)
			.map(userService::register)
			.map(userConverter::toResponse)
			.orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "request_null"));*/
	}

	/**
	 * 1. email, pw를 가지고 체크
	 * 2. 로그인 확인
	 * 3. token 생성
	 * 4. token response
	 */
	public TokenResponse login(@Valid UserLoginRequest body) {
		var userEntity = userService.login(body.getEmail(), body.getPassword());
		// TODO 토큰 생성 로직으로 변경하기
		var tokenResponse = tokenBusiness.issueToken(userEntity);
		return tokenResponse;
	}
}

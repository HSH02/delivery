package org.delivery.api.common.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * User의 경우 1000번대 에러코드 사용
 */
@AllArgsConstructor
@Getter
public enum TokenErrorCode implements ErrorCodeIfs {

	INVALID_FOUND(HttpStatus.NOT_FOUND.value(), 2000, "유효하지 않은 토큰"),
	EXPIRED_TOKEN(HttpStatus.NOT_FOUND.value(), 2001, "만료된 토큰"),
	TOKEN_EXCEPTION(HttpStatus.NOT_FOUND.value(), 2002, "토큰 알 수 없는 에러"),
	;

	private final Integer httpStatusCode;
	private final Integer errorCode;
	private final String description;
}

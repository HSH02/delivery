package org.delivery.api.exceptionhandler;

import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Api<Object>> exception(
		Exception exception
	) {
		log.error("", exception);

		return ResponseEntity
			.status(500)
			.body(
				Api.ERROR(ErrorCode.SEVER_ERROR)
			);
	}

}

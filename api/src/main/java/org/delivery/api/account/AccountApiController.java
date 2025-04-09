package org.delivery.api.account;

import java.time.LocalDate;

import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.account.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

	private final AccountRepository accountRepository;

	@GetMapping("/me")
	public Api<AccountMeResponse> save() {
		var response = AccountMeResponse.builder()
			.name("홍길동")
			.email("A@gmail.com")
			.registeredAt(LocalDate.now())
			.build();

		var str = "hELLOP";

		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			throw new ApiException(ErrorCode.SEVER_ERROR, e , "me error");
		}

		return Api.OK(response);
	}
}

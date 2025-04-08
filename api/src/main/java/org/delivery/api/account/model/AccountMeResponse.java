package org.delivery.api.account.model;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountMeResponse {

	private String email;

	private String name;

	private LocalDate registeredAt;
}

package org.delivery.api.domain.user.controller.model;

import java.time.LocalDate;

import org.delivery.db.user.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

	private Long id;

	private String name;

	private String email;

	private UserStatus status;

	private String address;

	private LocalDate registeredAt;

	private LocalDate unregisteredAt;

	private LocalDate lastLoginAt;
}

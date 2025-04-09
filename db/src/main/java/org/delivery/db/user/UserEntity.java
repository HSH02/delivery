package org.delivery.db.user;

import java.time.LocalDate;

import org.delivery.db.BaseEntity;
import org.delivery.db.user.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity {

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 100, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	@Column(length = 150, nullable = false)
	private String address;

	private LocalDate registeredAt;

	private LocalDate unregisteredAt;

	private LocalDate lastLoginAt;

}

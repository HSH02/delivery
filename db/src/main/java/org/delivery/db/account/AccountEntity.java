package org.delivery.db.account;

import org.delivery.db.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "account")
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AccountEntity extends BaseEntity {

}

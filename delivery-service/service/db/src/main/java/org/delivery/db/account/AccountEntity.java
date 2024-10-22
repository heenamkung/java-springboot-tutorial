package org.delivery.db.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

@Entity
@Table(name = "account")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class AccountEntity extends BaseEntity {
}

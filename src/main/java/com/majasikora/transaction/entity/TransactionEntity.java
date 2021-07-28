package com.majasikora.transaction.entity;

import static javax.persistence.EnumType.ORDINAL;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "accountId")
	private AccountEntity account;

	@Enumerated(ORDINAL)
	@Column(name = "operation_type")
	private OperationTypesEnumeration operationType;

	@Column
	private BigDecimal amount;

	@Column(name = "eventDate", columnDefinition = "TIMESTAMP")
	private LocalDateTime eventDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public OperationTypesEnumeration getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationTypesEnumeration operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

}

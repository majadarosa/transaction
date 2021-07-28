package com.majasikora.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDTO {

	@JsonProperty("transaction_id")
	Long id;

	@JsonProperty("account_id")
	Long accountId;

	@JsonProperty("operation_type_id")
	Integer operationType;

	BigDecimal amount;

	@JsonProperty("event_date")
	LocalDateTime eventDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccount() {
		return accountId;
	}

	public void setAccount(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
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

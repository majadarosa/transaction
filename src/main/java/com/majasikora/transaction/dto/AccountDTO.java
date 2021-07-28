package com.majasikora.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {

	@JsonProperty("account_id")
	Long id;

	@JsonProperty("document_number")
	String documentNumber;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

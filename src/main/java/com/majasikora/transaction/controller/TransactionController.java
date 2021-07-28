package com.majasikora.transaction.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.majasikora.transaction.dto.TransactionDTO;
import com.majasikora.transaction.service.TransactionService;

@RestController
@RequestMapping(path = "/transaction", produces = APPLICATION_JSON_VALUE)
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public TransactionDTO create(@RequestBody(required = true) final TransactionDTO transactionDTO) throws Exception {
		return transactionService.create(transactionDTO);
	}
	
}

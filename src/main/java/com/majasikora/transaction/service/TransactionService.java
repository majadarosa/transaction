package com.majasikora.transaction.service;

import static java.time.LocalDateTime.now;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majasikora.transaction.dto.TransactionDTO;
import com.majasikora.transaction.entity.OperationTypesEnumeration;
import com.majasikora.transaction.entity.TransactionEntity;
import com.majasikora.transaction.repository.TransactionRepository;
import com.sun.istack.NotNull;

@Service
public class TransactionService {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionRepository transactionRepository;

	public TransactionDTO create(@NotNull final TransactionDTO transactionDTO) throws Exception {
		return entityToDto(transactionRepository.save(dtoToEntity(transactionDTO)));
	}

	private TransactionEntity dtoToEntity(final TransactionDTO transactionDTO) throws Exception {
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionEntity.setAccount(accountService
	            .findOptional(transactionDTO.getAccount()));
		transactionEntity.setEventDate(now());
		OperationTypesEnumeration operationType = OperationTypesEnumeration.valueOf(transactionDTO.getOperationType());
		transactionEntity.setAmount(getAmountOperationType(operationType, transactionDTO.getAmount()));
		transactionEntity.setOperationType(operationType);
		return transactionEntity;
	}

	private TransactionDTO entityToDto(final TransactionEntity transactionEntity) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAccount(transactionEntity.getAccount().getId());
		transactionDTO.setAmount(transactionEntity.getAmount());
		transactionDTO.setEventDate(transactionEntity.getEventDate());
		transactionDTO.setOperationType(transactionEntity.getOperationType().ordinal());
		return null;
	}
	
	private BigDecimal getAmountOperationType(
		      final OperationTypesEnumeration operationTypesEnumeration, final BigDecimal amount) {
		    var absoluteAmount = amount.abs();
		    return operationTypesEnumeration.isNegative() ? absoluteAmount.negate() : absoluteAmount;
		  }

}

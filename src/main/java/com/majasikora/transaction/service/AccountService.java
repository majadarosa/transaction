package com.majasikora.transaction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majasikora.transaction.dto.AccountDTO;
import com.majasikora.transaction.entity.AccountEntity;
import com.majasikora.transaction.repository.AccountRepository;
import com.sun.istack.NotNull;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public AccountDTO create(@NotNull final AccountDTO accountDTO) {
		var account = dtoToEntity(accountDTO);

		return entityToDto(accountRepository.save(account));
	}

	public AccountDTO find(@NotNull final Long id) {
		return entityToDto(findOptional(id));
	}

	public AccountEntity findOptional(@NotNull final Long id) {
		return accountRepository.findById(id).orElse(null);
	}

	private AccountEntity dtoToEntity(final AccountDTO accountDTO) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setDocumentNumber(accountDTO.getDocumentNumber());
		return accountEntity;
	}

	private AccountDTO entityToDto(final AccountEntity account) {
		AccountDTO accountDto = new AccountDTO();
		accountDto.setId(account.getId());
		accountDto.setDocumentNumber(account.getDocumentNumber());
		return accountDto;
	}

}

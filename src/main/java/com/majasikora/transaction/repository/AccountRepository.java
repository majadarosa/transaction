package com.majasikora.transaction.repository;

import org.springframework.data.repository.CrudRepository;

import com.majasikora.transaction.entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {}

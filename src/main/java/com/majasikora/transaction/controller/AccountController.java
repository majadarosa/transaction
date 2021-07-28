package com.majasikora.transaction.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.majasikora.transaction.dto.AccountDTO;
import com.majasikora.transaction.service.AccountService;

@RestController
@RequestMapping(path = "/account", produces = APPLICATION_JSON_VALUE)
public class AccountController {

	@Autowired
  private AccountService accountService;

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public AccountDTO create(@RequestBody(required = true) final AccountDTO accountDTO) {
    return accountService.create(accountDTO);
  }

  @GetMapping(path = "/{accountId}")
  public AccountDTO find(@PathVariable Long accountId) {
    return accountService.find(accountId);
  }
}

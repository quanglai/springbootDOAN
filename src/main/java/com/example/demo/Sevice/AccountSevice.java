package com.example.demo.Sevice;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Entity.AccountEntity;

public interface AccountSevice {
    AccountDto findOne(Long id);
    Iterable<AccountDto> findAll();
    void delete(Long id);
    AccountDto save(AccountDto accountDto);
    AccountDto findbyEmail(String email);
    void update(AccountDto accountDto);
}

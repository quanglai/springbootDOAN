package com.example.demo.RestControllerIpm;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Entity.RoleEntity;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.RestController.AccountRest;
import com.example.demo.Sevice.AccountSevice;
import com.example.demo.Sevice.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountRestIpm implements AccountRest {
    @Autowired
    AccountSevice accountSevice;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleSevice roleSevice;

    @Override
    public List<AccountDto> findAll() {
        return (List<AccountDto>) accountSevice.findAll();
    }

    @Override
    public ResponseEntity<AccountDto> findOne(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(accountSevice.findOne(id));
    }

    @Override
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto) {
        accountDto.getListRole().add("USER");
        System.out.println("da vao save");
        AccountDto account = accountSevice.save(accountDto);
        if (account == null) {
            return ResponseEntity.noContent().build();

        }else{
            return ResponseEntity.ok(account);
        }
    }

    @Override
    public ResponseEntity<AccountDto> delete(@PathVariable(name = "id") Long id) {
        accountSevice.delete(id);
        return null;
    }

    @Override
    public ResponseEntity<AccountDto> update(@RequestBody AccountDto accountDto) {
        accountSevice.update(accountDto);
        return ResponseEntity.ok(accountDto);
    }
}

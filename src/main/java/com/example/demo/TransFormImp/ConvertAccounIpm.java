package com.example.demo.TransFormImp;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Sevice.RoleSevice;
import com.example.demo.TransFrom.ConvertAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertAccounIpm implements ConvertAccount {
    @Autowired
    RoleSevice  roleSevice;
    @Override
    public AccountEntity convertToEntity(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(accountDto.getId());
        accountEntity.setEmail(accountDto.getEmail());
        accountEntity.setPwd(accountDto.getPwd());
        return accountEntity;
    }
    @Override
    public AccountDto convertToDto(AccountEntity accountEntity) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountEntity.getId());
        accountDto.setEmail(accountEntity.getEmail());
        accountDto.setPwd(accountEntity.getPwd());

        return accountDto;
    }


    @Override
    public List<AccountEntity> convertListToEntity(List<AccountDto> accountDtos) {
        List<AccountEntity> accountEntities = new ArrayList<>(0);
        for (AccountDto accountDto : accountDtos){
            accountEntities.add(this.convertToEntity(accountDto));
        }
        return accountEntities;
    }

    @Override
    public List<AccountDto> convertListToDto(List<AccountEntity> accountEntities) {
        List<AccountDto> accountDtos = new ArrayList<>(0);
        for (AccountEntity accountEntity :accountEntities){
            accountDtos.add(this.convertToDto(accountEntity));

        }
        return accountDtos;
    }
}

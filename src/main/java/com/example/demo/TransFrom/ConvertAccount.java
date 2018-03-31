package com.example.demo.TransFrom;
import com.example.demo.Dto.AccountDto;
import com.example.demo.Entity.AccountEntity;
import javax.transaction.Transactional;
@Transactional
public interface ConvertAccount extends Convert<AccountEntity,AccountDto> {


}

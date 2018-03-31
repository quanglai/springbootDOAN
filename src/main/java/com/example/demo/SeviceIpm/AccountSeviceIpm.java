package com.example.demo.SeviceIpm;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Entity.RoleEntity;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Sevice.AccountSevice;
import com.example.demo.Sevice.RoleSevice;
import com.example.demo.TransFrom.ConvertAccount;
import com.example.demo.TransFrom.ConvertRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSeviceIpm implements AccountSevice {
    @Autowired
    ConvertAccount convertAccount;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ConvertRole convertRole;
    @Autowired
    RoleSevice roleSevice;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public AccountDto findOne(Long id) {
        if (id==null) {
            return null;
        }
        else {
            AccountEntity accountEntity = accountRepository.findOne(id);

            if (accountEntity != null) {
                AccountDto accountDto = convertAccount.convertToDto(accountEntity);
                List<RoleDto> listRole = convertRole.convertListToDto(accountEntity.getRoleList());
                for (RoleDto roleDto : listRole) {
                    accountDto.getListRole().add(roleDto.getRole());
                }
                return accountDto;
            } else {
                return null;
            }
        }
    }

    @Override
    public Iterable<AccountDto> findAll() {
        List<AccountEntity> accountEntities = (List<AccountEntity>) accountRepository.findAll();

        List<AccountDto> accountDtos = convertAccount.convertListToDto(accountEntities);

        for (int i = 0; i < accountEntities.size(); i++) {
            AccountEntity accountEntity = accountEntities.get(i);
            for (RoleEntity role : accountEntity.getRoleList()) {
                accountDtos.get(i).getListRole().add(role.getRole());
            }
        }

        return accountDtos;
    }

    @Override
    public void delete(Long id) {
        if (id==null) {
        }
        else{
            accountRepository.delete(id);
        }

    }

    @Override
    public AccountDto save(AccountDto accountDto) {

        // kiem tra co trung email hay khong
        AccountEntity accountEntityCheck = accountRepository.findByemail(accountDto.getEmail());
        // check neu khong trung thi lam
        if (accountEntityCheck == null) {
            //save account
            AccountEntity accountEntity = convertAccount.convertToEntity(accountDto);
            //set role cho account
            List<String> listRole = accountDto.getListRole();
            if(listRole.size() == 0){

                RoleEntity roleEntity = roleRepository.findByrole("User");
                accountEntity.getRoleList().add(roleEntity);
                accountRepository.save(accountEntity);
            }
            else {
                for (String role : listRole) {

                    RoleEntity roleEntity = roleRepository.findByrole(role);
                    accountEntity.getRoleList().add(roleEntity);

                }
                accountRepository.save(accountEntity);
            }

            // lay account len de tra ve
            AccountDto account = convertAccount.convertToDto(accountRepository.findByemail(accountDto.getEmail()));
            return account;
        }
        // email da bi trung
        else{
            return null;
        }

    }

    @Override
    public AccountDto findbyEmail(String email) {
        System.out.println("emailllllllllll=="+email);

        if (email.equalsIgnoreCase("") || email == null) {
            return null;
        } else {
            AccountEntity accountEntity = accountRepository.findByemail(email);
            if (accountEntity == null ) {
                return null;
            } else {
                AccountDto accountDto = convertAccount.convertToDto(accountEntity);
                List<RoleDto> listRole = convertRole.convertListToDto(accountEntity.getRoleList());
                for (RoleDto roleDto : listRole) {
                    accountDto.getListRole().add(roleDto.getRole());
                }
                return accountDto;

            }
        }
    }

    @Override
    public void update(AccountDto accountDto) {

        AccountEntity accountEntity = convertAccount.convertToEntity(accountDto);
        for (String role : accountDto.getListRole()) {
            RoleEntity roleEntity = roleRepository.findByrole(role);
            accountEntity.getRoleList().add(roleEntity);

        }
        accountRepository.save(accountEntity);
    }


}

package com.example.demo.SeviceIpm;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Entity.RoleEntity;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Sevice.RoleSevice;
import com.example.demo.TransFrom.ConvertRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleSeviceIpm implements RoleSevice {


    @Autowired
    ConvertRole convertRole;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public RoleDto findOne(Long id) {

        RoleEntity roleEntity = roleRepository.findOne(id);
        RoleDto roleDto = convertRole.convertToDto(roleEntity);
        for (AccountEntity accountEntity : roleEntity.getAccountEntities()) {
            roleDto.getListAccount().add(accountEntity.getEmail());
        }

        return roleDto;
    }

    @Override
    public Iterable<RoleDto> findAll() {

        List<RoleEntity> roleEntities = (List<RoleEntity>) roleRepository.findAll();

        List<RoleDto> roleDtos = convertRole.convertListToDto(roleEntities);

        for (int i = 0; i < roleEntities.size(); i++) {
            RoleEntity roleEntity = roleEntities.get(i);
            for (AccountEntity accountEntity : roleEntity.getAccountEntities()) {
                roleDtos.get(i).getListAccount().add(accountEntity.getEmail());
            }

        }

        return roleDtos;
    }

    @Override
    public void delete(Long id) {
        roleRepository.delete(id);
    }

    @Override
    public Boolean save(RoleDto roleDto) {

        RoleEntity roleEntityCheck = roleRepository.findByrole(roleDto.getRole());
        if (roleEntityCheck == null) {

            RoleEntity roleEntity = convertRole.convertToEntity(roleDto);
            for (String account : roleDto.getListAccount()) {
                AccountEntity accountEntity = accountRepository.findByemail(account);
                roleEntity.getAccountEntities().add(accountEntity);
            }
            roleRepository.save(roleEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public RoleDto findbyRole(String role) {

        RoleEntity roleEntity = roleRepository.findByrole(role);
        RoleDto roleDto = convertRole.convertToDto(roleEntity);
        for (AccountEntity accountEntity : roleEntity.getAccountEntities()) {
            roleDto.getListAccount().add(accountEntity.getEmail());
        }
        return roleDto;
    }

    @Override
    public void update(RoleDto roleDto) {
        RoleEntity roleEntity = convertRole.convertToEntity(roleDto);

        for (String account : roleDto.getListAccount()) {
            AccountEntity accountEntity = accountRepository.findByemail(account);
            roleEntity.getAccountEntities().add(accountEntity);
        }
        roleRepository.save(roleEntity);
    }
}

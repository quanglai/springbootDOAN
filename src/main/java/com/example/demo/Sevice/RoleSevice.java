package com.example.demo.Sevice;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.RoleEntity;

public interface RoleSevice {
    RoleDto findOne(Long id);
    Iterable<RoleDto> findAll();
    void delete(Long id);
    Boolean save(RoleDto roleDto);
    RoleDto findbyRole(String role);
    void update(RoleDto roleDto);
}

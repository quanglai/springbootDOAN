package com.example.demo.TransFormImp;

import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.RoleEntity;
import com.example.demo.Sevice.AccountSevice;
import com.example.demo.TransFrom.ConvertRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CovertRoleIpm implements ConvertRole {

    @Autowired
    AccountSevice accountSevice;

    @Override
    public RoleEntity convertToEntity(RoleDto roleDto) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(roleDto.getId());
        roleEntity.setRole(roleDto.getRole());
        return roleEntity;
    }

    @Override
    public RoleDto convertToDto(RoleEntity roleEntity) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(roleEntity.getId());
        roleDto.setRole(roleEntity.getRole());
        return roleDto;
    }

    @Override
    public List<RoleEntity> convertListToEntity(List<RoleDto> roleDtos) {
        List<RoleEntity> roleEntities = new ArrayList<>(0);
        for (RoleDto roleDto : roleDtos){
            roleEntities.add(this.convertToEntity(roleDto));
        }
        return roleEntities;
    }

    @Override
    public List<RoleDto> convertListToDto(List<RoleEntity> roleEntities) {
        List<RoleDto> roleDtos = new ArrayList<>();
        for (RoleEntity roleEntity :roleEntities){
            roleDtos.add(this.convertToDto(roleEntity));
        }
        return roleDtos;
    }
}

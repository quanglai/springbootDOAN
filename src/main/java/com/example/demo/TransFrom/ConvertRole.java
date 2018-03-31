package com.example.demo.TransFrom;

import com.example.demo.Dto.RoleDto;
import com.example.demo.Entity.RoleEntity;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface ConvertRole extends Convert<RoleEntity,RoleDto>{

}

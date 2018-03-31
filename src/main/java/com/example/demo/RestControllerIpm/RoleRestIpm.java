package com.example.demo.RestControllerIpm;

import com.example.demo.Dto.RoleDto;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.RestController.RolesRest;
import com.example.demo.Sevice.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleRestIpm implements RolesRest{
    @Autowired
    RoleSevice roleSevice;
    @Autowired
    RoleRepository roleRepository ;

    @Override
    public List<RoleDto> findAll() {
        return (List<RoleDto>) roleSevice.findAll();
    }

    @Override
    public ResponseEntity<RoleDto> findOne(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(roleSevice.findOne(id));
    }

    @Override
    public ResponseEntity<RoleDto> save(@RequestBody RoleDto roleDto){
        Boolean aBoolean = roleSevice.save(roleDto);
        if (aBoolean == true) {
            return ResponseEntity.ok(roleDto);
        } else {
            return  ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<RoleDto> delete(Long id) {
        roleSevice.delete(id);
        return null;
    }

    @Override
    public ResponseEntity<RoleDto> update(RoleDto roleDto) {
        roleSevice.save(roleDto);
        return null;
    }
}

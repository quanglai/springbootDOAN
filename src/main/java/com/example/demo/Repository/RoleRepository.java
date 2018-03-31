package com.example.demo.Repository;

import com.example.demo.Entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity,Long>{
    RoleEntity findByrole(String role);
}

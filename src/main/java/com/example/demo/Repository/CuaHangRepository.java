package com.example.demo.Repository;

import com.example.demo.Entity.CuaHangEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuaHangRepository extends CrudRepository<CuaHangEntity,Long> {
    List<CuaHangEntity> findBytenCuaHang(String tenCuaHang);
}

package com.example.demo.Repository;

import com.example.demo.Entity.LoaiSanPhamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepository extends CrudRepository<LoaiSanPhamEntity,Long> {
    LoaiSanPhamEntity findBytenLoaiSP(String tenSP);
}

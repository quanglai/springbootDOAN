package com.example.demo.Repository;

import com.example.demo.Entity.SanPhamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends CrudRepository<SanPhamEntity,Long> {
     SanPhamEntity findBytenSP(String tenSP);
}

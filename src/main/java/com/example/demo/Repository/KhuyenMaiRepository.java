package com.example.demo.Repository;

import com.example.demo.Entity.KhuyenMaiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends CrudRepository<KhuyenMaiEntity,Long> {
}

package com.example.demo.Repository;

import com.example.demo.Entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageEntity,Long> {
    ImageEntity findBypath(String path);
}

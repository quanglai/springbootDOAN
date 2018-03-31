package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class LoaiSanPhamEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private String tenLoaiSP;
    @OneToMany(mappedBy = "loaiSanPhamEntity")
    private List<SanPhamEntity> sanPhamEntities =  new ArrayList<>();
}

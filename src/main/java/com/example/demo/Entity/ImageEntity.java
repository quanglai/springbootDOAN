package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ImageEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "cuahang_id")
    private CuaHangEntity cuaHangEntity;
    @ManyToOne
    @JoinColumn(name = "iamge_id")
    private SanPhamEntity sanPhamEntity;
}

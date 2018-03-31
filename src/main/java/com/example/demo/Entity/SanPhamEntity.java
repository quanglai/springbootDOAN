package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SanPhamEntity {
    @GeneratedValue
    @Id
    private Long id;
    private String tenSP;
    private String icon;
    private double giaGoc;
    private boolean trangThai;
    private String gioiThieu;
    private String chuThich;
    private boolean trangThaiKhuyenMai;

    @ManyToOne
    @JoinColumn(name = "loaiSp_id")
    private LoaiSanPhamEntity loaiSanPhamEntity;

    @ManyToOne
    @JoinColumn(name = "cuahang_id")
    private CuaHangEntity cuaHangEntity;

    @OneToOne
    @JoinColumn(name = "khuyenmai_id")
    private KhuyenMaiEntity khuyenMaiEntity;

    @OneToMany(mappedBy = "sanPhamEntity")
    private List<ImageEntity> imageEntities =  new ArrayList<>();

}

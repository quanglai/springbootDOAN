package com.example.demo.Dto;

import com.example.demo.Entity.SanPhamEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SanPhamDto {
    private Long id;
    private String tenSP;
    private String icon;
    private double giaGoc;
    private boolean trangThai;
    private String gioiThieu;
    private boolean trangThaiKhuyenMai;
    private String chuThich;
    private Long ID_khuyenMaiDto;
    private Long ID_LoaiSanPham;
    private Long ID_CuaHang;
    private List<String> listImage =  new ArrayList<>();
}

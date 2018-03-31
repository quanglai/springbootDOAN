package com.example.demo.Sevice;

import com.example.demo.Dto.SanPhamDto;
import com.example.demo.Entity.SanPhamEntity;

public interface SanPhamSevice {
    SanPhamDto findOne(Long id);
    Iterable<SanPhamDto> findAll();
    void delete(Long id);
    Boolean save(SanPhamDto sanPhamDto);
    SanPhamDto findbySanPham(String sanpham);
    void update(SanPhamDto sanPhamDto);
}

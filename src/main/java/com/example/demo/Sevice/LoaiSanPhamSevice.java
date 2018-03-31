package com.example.demo.Sevice;

import com.example.demo.Dto.LoaiSanPhamDto;

public interface LoaiSanPhamSevice {
    LoaiSanPhamDto findOne(Long id);
    Iterable<LoaiSanPhamDto> findAll();
    void delete(Long id);
    Boolean save(LoaiSanPhamDto loaiSanPhamDto);
    LoaiSanPhamDto findbyLoaiSP(String loaiSP);
    void update(LoaiSanPhamDto loaiSanPhamDto);
}

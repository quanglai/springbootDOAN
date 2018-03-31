package com.example.demo.TransFrom;

import com.example.demo.Dto.LoaiSanPhamDto;
import com.example.demo.Entity.LoaiSanPhamEntity;

import javax.transaction.Transactional;

@Transactional
public interface ConvertLoaiSanPham extends Convert<LoaiSanPhamEntity,LoaiSanPhamDto> {
}

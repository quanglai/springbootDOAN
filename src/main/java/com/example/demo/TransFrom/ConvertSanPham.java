package com.example.demo.TransFrom;

import com.example.demo.Dto.SanPhamDto;
import com.example.demo.Entity.SanPhamEntity;

import javax.transaction.Transactional;

@Transactional
public interface ConvertSanPham extends Convert<SanPhamEntity,SanPhamDto> {
}

package com.example.demo.Sevice;

import com.example.demo.Dto.CuaHangDto;

import java.util.List;

public interface CuaHangSevice {
    CuaHangDto findOne(Long id);
    Iterable<CuaHangDto> findAll();
    void delete(Long id);
    Boolean save(CuaHangDto cuaHangDto);
    List<CuaHangDto> findbyCuaHang(String cuahang);
    void update(CuaHangDto cuaHangDto);
}

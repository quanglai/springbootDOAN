package com.example.demo.TransFrom;

import com.example.demo.Dto.CuaHangDto;
import com.example.demo.Entity.CuaHangEntity;

import javax.transaction.Transactional;

@Transactional
public interface ConvertCuaHang extends Convert<CuaHangEntity,CuaHangDto> {
}

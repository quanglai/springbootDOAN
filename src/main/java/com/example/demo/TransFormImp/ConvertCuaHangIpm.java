package com.example.demo.TransFormImp;

import com.example.demo.Dto.CuaHangDto;
import com.example.demo.Entity.CuaHangEntity;
import com.example.demo.TransFrom.ConvertCuaHang;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertCuaHangIpm implements ConvertCuaHang {
    @Override
    public CuaHangEntity convertToEntity(CuaHangDto cuaHangDto) {
        CuaHangEntity cuaHangEntity =  new CuaHangEntity();
        cuaHangEntity.setDiachi(cuaHangDto.getDiachi());
        cuaHangEntity.setEmail(cuaHangDto.getEmail());
        cuaHangEntity.setGioithieu(cuaHangDto.getGioithieu());
        cuaHangEntity.setIcon(cuaHangDto.getIcon());
        cuaHangEntity.setId(cuaHangDto.getId());
        cuaHangEntity.setNgayDangKy(cuaHangDto.getNgayDangKy());
        cuaHangEntity.setPhone(cuaHangDto.getPhone());
        cuaHangEntity.setTenCuaHang(cuaHangDto.getTenCuaHang());
        cuaHangEntity.setToadoX(cuaHangDto.getToadoX());
        cuaHangEntity.setToadoY(cuaHangDto.getToadoY());
        cuaHangEntity.setTrangthai(cuaHangDto.isTrangthai());
        return cuaHangEntity;
    }

    @Override
    public CuaHangDto convertToDto(CuaHangEntity cuaHangEntity) {
        CuaHangDto cuaHangDto =  new CuaHangDto();
        cuaHangDto.setDiachi(cuaHangEntity.getDiachi());
        cuaHangDto.setEmail(cuaHangEntity.getEmail());
        cuaHangDto.setGioithieu(cuaHangEntity.getGioithieu());
        cuaHangDto.setIcon(cuaHangEntity.getIcon());
        cuaHangDto.setId(cuaHangEntity.getId());
        cuaHangDto.setNgayDangKy(cuaHangDto.getNgayDangKy());
        cuaHangDto.setPhone(cuaHangEntity.getPhone());
        cuaHangDto.setTenCuaHang(cuaHangEntity.getTenCuaHang());
        cuaHangDto.setToadoX(cuaHangEntity.getToadoX());
        cuaHangDto.setToadoY(cuaHangEntity.getToadoY());
        cuaHangDto.setTrangthai(cuaHangEntity.isTrangthai());
        cuaHangDto.setID_account(cuaHangEntity.getAccountEntity().getId());
        System.out.println("ID="+cuaHangEntity.getAccountEntity().getId());
        return cuaHangDto;
    }

    @Override
    public List<CuaHangEntity> convertListToEntity(List<CuaHangDto> cuaHangDtos) {
        List<CuaHangEntity> cuaHangEntities = new ArrayList<>();

        for (CuaHangDto cuaHangDto :cuaHangDtos){
            CuaHangEntity cuaHangEntity =  this.convertToEntity(cuaHangDto);
            cuaHangEntities.add(cuaHangEntity);
        }
        return cuaHangEntities;
    }

    @Override
    public List<CuaHangDto> convertListToDto(List<CuaHangEntity> cuaHangEntities) {
        List<CuaHangDto> cuaHangDtos = new ArrayList<>();
        for (CuaHangEntity cuaHangEntity:cuaHangEntities){
            CuaHangDto cuaHangDto = this.convertToDto(cuaHangEntity);
            cuaHangDtos.add(cuaHangDto);
        }
        return cuaHangDtos;
    }
}

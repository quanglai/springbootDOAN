package com.example.demo.TransFormImp;

import com.example.demo.Dto.LoaiSanPhamDto;
import com.example.demo.Entity.LoaiSanPhamEntity;
import com.example.demo.TransFrom.ConvertLoaiSanPham;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertLoaiSanPhamIm implements ConvertLoaiSanPham {
    @Override
    public LoaiSanPhamEntity convertToEntity(LoaiSanPhamDto loaiSanPhamDto) {
        LoaiSanPhamEntity loaiSanPhamEntity = new LoaiSanPhamEntity();
        loaiSanPhamEntity.setId(loaiSanPhamDto.getId());
        loaiSanPhamEntity.setTenLoaiSP(loaiSanPhamDto.getTenLoaiSP());
        return loaiSanPhamEntity;
    }

    @Override
    public LoaiSanPhamDto convertToDto(LoaiSanPhamEntity loaiSanPhamEntity) {
        LoaiSanPhamDto loaiSanPhamDto = new LoaiSanPhamDto();
        loaiSanPhamDto.setId(loaiSanPhamEntity.getId());
        loaiSanPhamDto.setTenLoaiSP(loaiSanPhamEntity.getTenLoaiSP());
        return loaiSanPhamDto;
    }

    @Override
    public List<LoaiSanPhamEntity> convertListToEntity(List<LoaiSanPhamDto> loaiSanPhamDtos) {
        List<LoaiSanPhamEntity> loaiSanPhamEntities = new ArrayList<>();
        for (LoaiSanPhamDto loaiSanPhamDto :loaiSanPhamDtos){
            LoaiSanPhamEntity loaiSanPhamEntity = this.convertToEntity(loaiSanPhamDto);
            loaiSanPhamEntities.add(loaiSanPhamEntity);
        }
        return loaiSanPhamEntities;
    }

    @Override
    public List<LoaiSanPhamDto> convertListToDto(List<LoaiSanPhamEntity> loaiSanPhamEntities) {
        List<LoaiSanPhamDto> loaiSanPhamDtos = new ArrayList<>();
        for (LoaiSanPhamEntity loaiSanPhamEntity :loaiSanPhamEntities){
            LoaiSanPhamDto loaiSanPhamDto = this.convertToDto(loaiSanPhamEntity);
            loaiSanPhamDtos.add(loaiSanPhamDto);
        }
        return loaiSanPhamDtos;
    }
}

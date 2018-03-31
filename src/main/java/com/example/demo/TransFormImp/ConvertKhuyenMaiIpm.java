package com.example.demo.TransFormImp;

import com.example.demo.Dto.KhuyenMaiDto;
import com.example.demo.Entity.KhuyenMaiEntity;
import com.example.demo.Sevice.SanPhamSevice;
import com.example.demo.TransFrom.ConvertKhuyenMai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertKhuyenMaiIpm implements ConvertKhuyenMai {


    @Override
    public KhuyenMaiEntity convertToEntity(KhuyenMaiDto khuyenMaiDto) {

        KhuyenMaiEntity khuyenMaiEntity =  new KhuyenMaiEntity();
        khuyenMaiEntity.setPhanTramKM(khuyenMaiDto.getPhanTramKM());
        khuyenMaiEntity.setId(khuyenMaiDto.getId());
        khuyenMaiEntity.setGiaKM(khuyenMaiDto.getGiaKM());
        khuyenMaiEntity.setChuThich(khuyenMaiDto.getChuThich());return khuyenMaiEntity;
    }

    @Override
    public KhuyenMaiDto convertToDto(KhuyenMaiEntity khuyenMaiEntity) {

        KhuyenMaiDto khuyenMaiDto =  new KhuyenMaiDto();
        khuyenMaiDto.setPhanTramKM(khuyenMaiEntity.getPhanTramKM());
        khuyenMaiDto.setId(khuyenMaiEntity.getId());
        khuyenMaiDto.setGiaKM(khuyenMaiEntity.getGiaKM());
        khuyenMaiDto.setChuThich(khuyenMaiEntity.getChuThich());
        khuyenMaiDto.setID_sanPhamDto(khuyenMaiEntity.getId());
        return khuyenMaiDto;
    }

    @Override
    public List<KhuyenMaiEntity> convertListToEntity(List<KhuyenMaiDto> khuyenMaiDtos) {
        List<KhuyenMaiEntity> khuyenMaiEntities =  new ArrayList<>();
        for (KhuyenMaiDto khuyenMaiDto :khuyenMaiDtos){
            khuyenMaiEntities.add(this.convertToEntity(khuyenMaiDto));
        }
        return khuyenMaiEntities;
    }

    @Override
    public List<KhuyenMaiDto> convertListToDto(List<KhuyenMaiEntity> khuyenMaiEntities) {
        List<KhuyenMaiDto> khuyenMaiDtos = new ArrayList<>();
        for (KhuyenMaiEntity khuyenMaiEntity:khuyenMaiEntities){
            khuyenMaiDtos.add(this.convertToDto(khuyenMaiEntity));
        }
        return khuyenMaiDtos;
    }
}

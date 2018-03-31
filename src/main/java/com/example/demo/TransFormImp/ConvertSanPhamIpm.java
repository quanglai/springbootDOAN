package com.example.demo.TransFormImp;

import com.example.demo.Dto.SanPhamDto;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Sevice.KhuyenMaiSevice;
import com.example.demo.TransFrom.ConvertSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertSanPhamIpm implements ConvertSanPham {

    @Autowired
    KhuyenMaiSevice khuyenMaiSevice;

    @Override
    public SanPhamEntity convertToEntity(SanPhamDto sanPhamDto) {
        SanPhamEntity sanPhamEntity = new SanPhamEntity();
        sanPhamEntity.setChuThich(sanPhamDto.getChuThich());
        sanPhamEntity.setGiaGoc(sanPhamDto.getGiaGoc());
        sanPhamEntity.setGioiThieu(sanPhamDto.getGioiThieu());
        sanPhamEntity.setIcon(sanPhamDto.getIcon());
        sanPhamEntity.setId(sanPhamDto.getId());
        sanPhamEntity.setTenSP(sanPhamDto.getTenSP());
        sanPhamEntity.setTrangThai(sanPhamDto.isTrangThai());
        sanPhamEntity.setTrangThaiKhuyenMai(sanPhamDto.isTrangThaiKhuyenMai());
        return sanPhamEntity;
    }

    @Override
    public SanPhamDto convertToDto(SanPhamEntity sanPhamEntity) {
        SanPhamDto sanPhamDto = new SanPhamDto();
        sanPhamDto.setChuThich(sanPhamEntity.getChuThich());
        sanPhamDto.setGiaGoc(sanPhamEntity.getGiaGoc());
        sanPhamDto.setGioiThieu(sanPhamEntity.getGioiThieu());
        sanPhamDto.setIcon(sanPhamEntity.getIcon());
        sanPhamDto.setId(sanPhamEntity.getId());
        sanPhamDto.setTenSP(sanPhamEntity.getTenSP());
        sanPhamDto.setTrangThai(sanPhamEntity.isTrangThai());
        sanPhamDto.setTrangThaiKhuyenMai(sanPhamEntity.isTrangThaiKhuyenMai());
        sanPhamDto.setID_LoaiSanPham(sanPhamEntity.getLoaiSanPhamEntity().getId());
        sanPhamDto.setID_khuyenMaiDto(sanPhamEntity.getKhuyenMaiEntity().getId());
        sanPhamDto.setID_CuaHang(sanPhamEntity.getCuaHangEntity().getId());
        return sanPhamDto;
    }

    @Override
    public List<SanPhamEntity> convertListToEntity(List<SanPhamDto> sanPhamDtos) {
        List<SanPhamEntity> sanPhamEntities =  new ArrayList<>();
        for(SanPhamDto sanPhamDto :sanPhamDtos){
            SanPhamEntity sanPhamEntity = this.convertToEntity(sanPhamDto);
            sanPhamEntities.add(sanPhamEntity);
        }
        return sanPhamEntities;
    }

    @Override
    public List<SanPhamDto> convertListToDto(List<SanPhamEntity> sanPhamEntities) {
        List<SanPhamDto> sanPhamDtos = new ArrayList<>();
        for (SanPhamEntity sanPhamEntity :sanPhamEntities){
            SanPhamDto sanPhamDto = this.convertToDto(sanPhamEntity);
            sanPhamDtos.add(sanPhamDto);
        }
        return sanPhamDtos;
    }
}

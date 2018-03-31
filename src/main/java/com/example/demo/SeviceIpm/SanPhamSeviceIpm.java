package com.example.demo.SeviceIpm;

import com.example.demo.Dto.SanPhamDto;
import com.example.demo.Entity.ImageEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Repository.*;
import com.example.demo.Sevice.SanPhamSevice;
import com.example.demo.TransFrom.ConvertKhuyenMai;
import com.example.demo.TransFrom.ConvertSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamSeviceIpm implements SanPhamSevice {

    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    ConvertSanPham convertSanPham;
    @Autowired
    ConvertKhuyenMai convertKhuyenMai;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    LoaiSanPhamRepository loaiSanPhamRepository;
    @Autowired
    CuaHangRepository cuaHangRepository;
    @Autowired
    ImageRepository imageRepository;

    @Override
    public SanPhamDto findOne(Long id) {
        SanPhamEntity sanPhamEntity =  sanPhamRepository.findOne(id);
        SanPhamDto sanPhamDto =  convertSanPham.convertToDto(sanPhamEntity);
        sanPhamEntity.getImageEntities().forEach(imageEntity -> {
            sanPhamDto.getListImage().add(imageEntity.getPath());
        });
        return sanPhamDto;
    }

    @Override
    public Iterable<SanPhamDto> findAll() {
        List<SanPhamEntity> sanPhamEntities = (List<SanPhamEntity>) sanPhamRepository.findAll();
        List<SanPhamDto> sanPhamDtos = convertSanPham.convertListToDto(sanPhamEntities);
        for (int i = 0; i < sanPhamEntities.size(); i++) {
            SanPhamEntity sanPhamEntity = sanPhamEntities.get(i);
            SanPhamDto sanPhamDto = sanPhamDtos.get(i);
            sanPhamEntity.getImageEntities().forEach(imageEntity -> {
                sanPhamDto.getListImage().add(imageEntity.getPath());
            });
        }

        return sanPhamDtos;

    }

    @Override
    public void delete(Long id) {
        sanPhamRepository.delete(id);
    }

    @Override
    public Boolean save(SanPhamDto sanPhamDto) {

        SanPhamEntity sanPhamEntity =  convertSanPham.convertToEntity(sanPhamDto);
        sanPhamEntity.setKhuyenMaiEntity(khuyenMaiRepository.findOne(sanPhamDto.getID_khuyenMaiDto()));
        sanPhamEntity.setLoaiSanPhamEntity(loaiSanPhamRepository.findOne(sanPhamDto.getID_LoaiSanPham()));
        sanPhamEntity.setCuaHangEntity(cuaHangRepository.findOne(sanPhamDto.getID_CuaHang()));
        sanPhamDto.getListImage().forEach(s -> {
            ImageEntity imageEntity = imageRepository.findBypath(s);
            sanPhamEntity.getImageEntities().add(imageEntity);
        });
        sanPhamRepository.save(sanPhamEntity);

        return true;
    }

    @Override
    public SanPhamDto findbySanPham(String sanpham) {
        SanPhamEntity sanPhamEntity = sanPhamRepository.findBytenSP(sanpham);
        SanPhamDto sanPhamDto = convertSanPham.convertToDto(sanPhamEntity);
        return sanPhamDto;
    }

    @Override
    public void update(SanPhamDto sanPhamDto) {
        SanPhamEntity sanPhamEntity =  convertSanPham.convertToEntity(sanPhamDto);
        sanPhamEntity.setKhuyenMaiEntity(khuyenMaiRepository.findOne(sanPhamDto.getID_khuyenMaiDto()));
        sanPhamEntity.setLoaiSanPhamEntity(loaiSanPhamRepository.findBytenLoaiSP(sanPhamDto.getTenSP()));
        sanPhamEntity.setCuaHangEntity(cuaHangRepository.findOne(sanPhamDto.getID_CuaHang()));
        sanPhamDto.getListImage().forEach(s -> {
            ImageEntity imageEntity = imageRepository.findBypath(s);
            sanPhamEntity.getImageEntities().add(imageEntity);
        });
        sanPhamRepository.save(sanPhamEntity);
    }
}

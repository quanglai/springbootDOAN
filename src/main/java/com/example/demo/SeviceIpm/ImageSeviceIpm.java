package com.example.demo.SeviceIpm;

import com.example.demo.Dto.ImageDto;
import com.example.demo.Entity.CuaHangEntity;
import com.example.demo.Entity.ImageEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Repository.CuaHangRepository;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Sevice.ImageSevice;
import com.example.demo.TransFrom.ConvertImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageSeviceIpm implements ImageSevice {

    @Autowired
    ImageRepository imageRepository ;
    @Autowired
    ConvertImage convertImage;
    @Autowired
    CuaHangRepository cuaHangRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public ImageDto findOne(Long id) {
        ImageEntity imageEntity = imageRepository.findOne(id);
        ImageDto imageDto = convertImage.convertToDto(imageEntity);
        return imageDto;
    }

    @Override
    public Iterable<ImageDto> findAll() {

        List<ImageEntity> imageEntities = (List<ImageEntity>) imageRepository.findAll();
        List<ImageDto> imageDtos =  convertImage.convertListToDto(imageEntities);
        return imageDtos;
    }

    @Override
    public void delete(Long id) {
        imageRepository.delete(id);
    }

    @Override
    public Boolean save(ImageDto imageDto) {
        ImageEntity imageEntity = convertImage.convertToEntity(imageDto);
        CuaHangEntity cuaHangEntity = cuaHangRepository.findOne(imageDto.getID_cuaHang());
        SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(imageDto.getID_SanPham());
        imageEntity.setSanPhamEntity(sanPhamEntity);
        imageEntity.setCuaHangEntity(cuaHangEntity);

        imageRepository.save(imageEntity);
        return true;
    }

    @Override
    public ImageDto findbyimage(String iamge) {
        ImageEntity imageEntity = imageRepository.findBypath(iamge);
        ImageDto imageDto = convertImage.convertToDto(imageEntity);
        return imageDto;
    }

    @Override
    public void update(ImageDto imageDto) {
        ImageEntity imageEntity = convertImage.convertToEntity(imageDto);
        CuaHangEntity cuaHangEntity = cuaHangRepository.findOne(imageDto.getID_cuaHang());
        imageEntity.setCuaHangEntity(cuaHangEntity);
        SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(imageDto.getID_SanPham());
        imageEntity.setSanPhamEntity(sanPhamEntity);
        imageRepository.save(imageEntity);
    }
}

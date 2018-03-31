package com.example.demo.TransFormImp;

import com.example.demo.Dto.ImageDto;
import com.example.demo.Entity.ImageEntity;
import com.example.demo.TransFrom.ConvertImage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertImageIpm implements ConvertImage {
    @Override
    public ImageEntity convertToEntity(ImageDto imageDto) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setId(imageDto.getId());
        imageEntity.setPath(imageDto.getPath());
        return imageEntity;
    }

    @Override
    public ImageDto convertToDto(ImageEntity imageEntity) {
        ImageDto imageDto = new ImageDto();
        imageDto.setId(imageEntity.getId());
        imageDto.setPath(imageEntity.getPath());
        imageDto.setID_cuaHang(imageEntity.getCuaHangEntity().getId());
        imageDto.setID_SanPham(imageEntity.getSanPhamEntity().getId());
        return imageDto;
    }

    @Override
    public List<ImageEntity> convertListToEntity(List<ImageDto> imageDtos) {
        List<ImageEntity> imageEntities = new ArrayList<>();
        for (ImageDto imageDto:imageDtos){
            ImageEntity imageEntity = this.convertToEntity(imageDto);
            imageEntities.add(imageEntity);
        }
        return imageEntities;
    }

    @Override
    public List<ImageDto> convertListToDto(List<ImageEntity> imageEntities) {
        List<ImageDto> imageDtos = new ArrayList<>();
        for(ImageEntity imageEntity : imageEntities){
            ImageDto imageDto = this.convertToDto(imageEntity);
            imageDtos.add(imageDto);
        }
        return imageDtos;
    }
}

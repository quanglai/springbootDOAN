package com.example.demo.Sevice;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Dto.ImageDto;

public interface ImageSevice {
    ImageDto findOne(Long id);
    Iterable<ImageDto> findAll();
    void delete(Long id);
    Boolean save(ImageDto imageDto);
    ImageDto findbyimage(String iamge);
    void update(ImageDto imageDto);
}

package com.example.demo.TransFrom;

import com.example.demo.Dto.ImageDto;
import com.example.demo.Entity.ImageEntity;

import javax.transaction.Transactional;

@Transactional
public interface ConvertImage extends Convert<ImageEntity,ImageDto> {
}

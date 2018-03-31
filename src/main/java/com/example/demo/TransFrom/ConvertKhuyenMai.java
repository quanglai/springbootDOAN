package com.example.demo.TransFrom;

import com.example.demo.Dto.KhuyenMaiDto;
import com.example.demo.Entity.KhuyenMaiEntity;

import javax.transaction.Transactional;

@Transactional
public interface ConvertKhuyenMai extends Convert<KhuyenMaiEntity,KhuyenMaiDto> {
}

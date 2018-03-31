package com.example.demo.Sevice;

import com.example.demo.Dto.KhuyenMaiDto;

public interface KhuyenMaiSevice {
    KhuyenMaiDto findOne(Long id);
    Iterable<KhuyenMaiDto> findAll();
    void delete(Long id);
    Boolean save(KhuyenMaiDto khuyenMaiDto);
    void update(KhuyenMaiDto khuyenMaiDto);
}

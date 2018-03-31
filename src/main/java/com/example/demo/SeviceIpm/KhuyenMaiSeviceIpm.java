package com.example.demo.SeviceIpm;

import com.example.demo.Dto.KhuyenMaiDto;
import com.example.demo.Entity.KhuyenMaiEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Repository.KhuyenMaiRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Sevice.KhuyenMaiSevice;
import com.example.demo.TransFrom.ConvertKhuyenMai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KhuyenMaiSeviceIpm implements KhuyenMaiSevice {
    @Autowired
    ConvertKhuyenMai convertKhuyenMai;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Override
    public KhuyenMaiDto findOne(Long id) {
        KhuyenMaiDto khuyenMaiDto = convertKhuyenMai.convertToDto(khuyenMaiRepository.findOne(id));
        return khuyenMaiDto;
    }

    @Override
    public Iterable<KhuyenMaiDto> findAll() {
        List<KhuyenMaiDto> khuyenMaiDtos =  convertKhuyenMai.convertListToDto((List<KhuyenMaiEntity>) khuyenMaiRepository.findAll());

        return khuyenMaiDtos;
    }

    @Override
    public void delete(Long id) {
        khuyenMaiRepository.delete(id);
    }

    @Override
    public Boolean save(KhuyenMaiDto khuyenMaiDto) {
        KhuyenMaiEntity khuyenMaiEntity = convertKhuyenMai.convertToEntity(khuyenMaiDto);
        SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(khuyenMaiDto.getID_sanPhamDto());
        khuyenMaiEntity.setSanPhamEntity(sanPhamEntity);
        khuyenMaiRepository.save(khuyenMaiEntity);
        return true;
    }

    @Override
    public void update(KhuyenMaiDto khuyenMaiDto) {
        KhuyenMaiEntity khuyenMaiEntity = convertKhuyenMai.convertToEntity(khuyenMaiDto);
        SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(khuyenMaiDto.getID_sanPhamDto());
        khuyenMaiEntity.setSanPhamEntity(sanPhamEntity);
        khuyenMaiRepository.save(khuyenMaiEntity);

    }
}

package com.example.demo.SeviceIpm;

import com.example.demo.Dto.LoaiSanPhamDto;
import com.example.demo.Entity.LoaiSanPhamEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Repository.LoaiSanPhamRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Sevice.LoaiSanPhamSevice;
import com.example.demo.TransFrom.ConvertLoaiSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class LoaiSanPhamSeviceIpm implements LoaiSanPhamSevice {

    @Autowired
    LoaiSanPhamRepository loaiSanPhamRepository;
    @Autowired
    ConvertLoaiSanPham convertLoaiSanPham;
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public LoaiSanPhamDto findOne(Long id) {
        LoaiSanPhamEntity loaiSanPhamEntity  = loaiSanPhamRepository.findOne(id);
        LoaiSanPhamDto loaiSanPhamDto = convertLoaiSanPham.convertToDto(loaiSanPhamEntity);

        loaiSanPhamEntity.getSanPhamEntities().forEach(sanPhamEntity -> {
            loaiSanPhamDto.getListSanPham().add(sanPhamEntity.getId());
        });
        return loaiSanPhamDto;
    }

    @Override
    public Iterable<LoaiSanPhamDto> findAll() {
        List<LoaiSanPhamEntity> loaiSanPhamEntities = (List<LoaiSanPhamEntity>) loaiSanPhamRepository.findAll();
        List<LoaiSanPhamDto> loaiSanPhamDtos = convertLoaiSanPham.convertListToDto(loaiSanPhamEntities);
        for (int i = 0; i <loaiSanPhamEntities.size() ; i++) {
            LoaiSanPhamEntity  loaiSanPhamEntity = loaiSanPhamEntities.get(i);
            LoaiSanPhamDto loaiSanPhamDto = loaiSanPhamDtos.get(i);
            loaiSanPhamEntity.getSanPhamEntities().forEach(sanPhamEntity -> {
                loaiSanPhamDto.getListSanPham().add(sanPhamEntity.getId());
            });
        }
        return loaiSanPhamDtos;
    }

    @Override
    public void delete(Long id) {
        loaiSanPhamRepository.delete(id);
    }

    @Override
    public Boolean save(LoaiSanPhamDto loaiSanPhamDto) {

        LoaiSanPhamEntity loaiSanPhamEntity = convertLoaiSanPham.convertToEntity(loaiSanPhamDto);

        loaiSanPhamDto.getListSanPham().forEach(ID_sanpham->{
            SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(ID_sanpham);
            if (sanPhamEntity!=null) {
                loaiSanPhamEntity.getSanPhamEntities().add(sanPhamEntity);

            } else{
               // returm false
            }
        });
        return true;
    }

    @Override
    public LoaiSanPhamDto findbyLoaiSP(String loaiSP) {
        LoaiSanPhamEntity loaiSanPhamEntity =  loaiSanPhamRepository.findBytenLoaiSP(loaiSP);
        LoaiSanPhamDto loaiSanPhamDto = convertLoaiSanPham.convertToDto(loaiSanPhamEntity);
        return loaiSanPhamDto;
    }

    @Override
    public void update(LoaiSanPhamDto loaiSanPhamDto) {

        LoaiSanPhamEntity loaiSanPhamEntity = convertLoaiSanPham.convertToEntity(loaiSanPhamDto);

        loaiSanPhamDto.getListSanPham().forEach(ID_sanpham->{
            SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(ID_sanpham);
            if (sanPhamEntity!=null) {
                loaiSanPhamEntity.getSanPhamEntities().add(sanPhamEntity);

            } else{
                // returm false
            }
        });
    }
}

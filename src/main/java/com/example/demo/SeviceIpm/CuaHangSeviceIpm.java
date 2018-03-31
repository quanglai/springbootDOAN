package com.example.demo.SeviceIpm;

import com.example.demo.Dto.CuaHangDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Entity.CuaHangEntity;
import com.example.demo.Entity.ImageEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.CuaHangRepository;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.Repository.SanPhamRepository;
import com.example.demo.Sevice.CuaHangSevice;
import com.example.demo.TransFrom.ConvertCuaHang;
import com.example.demo.TransFrom.ConvertImage;
import com.example.demo.TransFrom.ConvertSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangSeviceIpm implements CuaHangSevice {

    @Autowired
    CuaHangRepository cuaHangRepository ;
    @Autowired
    ConvertCuaHang convertCuaHang ;
    @Autowired
    ConvertSanPham convertSanPham;
    @Autowired
    ConvertImage convertImage;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public CuaHangDto findOne(Long id) {

        CuaHangEntity cuaHangEntity =  cuaHangRepository.findOne(id);
        CuaHangDto cuaHangDto= convertCuaHang.convertToDto(cuaHangEntity);
        cuaHangEntity.getSanPhamEntities().forEach(sanPhamEntity -> {
            cuaHangDto.getListSanPham().add(sanPhamEntity.getId());
        });
        cuaHangEntity.getImageEntities().forEach(imageEntity -> {
            cuaHangDto.getListImage().add(imageEntity.getPath());
        });
        return cuaHangDto;
    }

    @Override
    public Iterable<CuaHangDto> findAll() {

        List<CuaHangEntity> cuaHangEntities = (List<CuaHangEntity>) cuaHangRepository.findAll();
        List<CuaHangDto> cuaHangDtos = convertCuaHang.convertListToDto(cuaHangEntities);
        for (int i = 0; i < cuaHangEntities.size(); i++) {
            CuaHangEntity cuaHangEntity = cuaHangEntities.get(i);
            CuaHangDto cuaHangDto = cuaHangDtos.get(i);
            cuaHangEntity.getImageEntities().forEach(imageEntity -> {
                cuaHangDto.getListImage().add(imageEntity.getPath());
            });
            cuaHangEntity.getSanPhamEntities().forEach(sanPhamEntity -> {
                cuaHangDto.getListSanPham().add(sanPhamEntity.getId());
            });
        }

        return cuaHangDtos;
    }

    @Override
    public void delete(Long id) {
        System.out.println("id can tim=="+id);
        cuaHangRepository.delete(id);

    }

    @Override
    public Boolean save(CuaHangDto cuaHangDto) {

       CuaHangEntity cuaHangEntity = convertCuaHang.convertToEntity(cuaHangDto);
       cuaHangDto.getListSanPham().forEach(idSanPham -> {
           SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(idSanPham);
           cuaHangEntity.getSanPhamEntities().add(sanPhamEntity);
       });
       cuaHangDto.getListImage().forEach(s -> {
           ImageEntity imageEntity = imageRepository.findBypath(s);
           cuaHangEntity.getImageEntities().add(imageEntity);
       });

        AccountEntity accountEntity = accountRepository.findOne(cuaHangDto.getID_account());
        cuaHangEntity.setAccountEntity(accountEntity);
        cuaHangRepository.save(cuaHangEntity);

        return true;


    }

    @Override
    public List<CuaHangDto> findbyCuaHang(String cuahang) {
        List<CuaHangEntity> cuaHangEntities = cuaHangRepository.findBytenCuaHang(cuahang);
        List<CuaHangDto> cuaHangDtos = convertCuaHang.convertListToDto(cuaHangEntities);
        for (int i = 0; i < cuaHangEntities.size(); i++) {
            CuaHangEntity cuaHangEntity = cuaHangEntities.get(i);
            CuaHangDto cuaHangDto = cuaHangDtos.get(i);
            cuaHangEntity.getImageEntities().forEach(imageEntity -> {
                cuaHangDto.getListImage().add(imageEntity.getPath());
            });
            cuaHangEntity.getSanPhamEntities().forEach(sanPhamEntity -> {
                cuaHangDto.getListSanPham().add(sanPhamEntity.getId());
            });
        }
        return cuaHangDtos;
    }

    @Override
    public void update(CuaHangDto cuaHangDto) {

        CuaHangEntity cuaHangEntity = convertCuaHang.convertToEntity(cuaHangDto);
        cuaHangDto.getListSanPham().forEach(idSanPham -> {
            SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(idSanPham);
            cuaHangEntity.getSanPhamEntities().add(sanPhamEntity);
        });
        cuaHangDto.getListImage().forEach(s -> {
            ImageEntity imageEntity = imageRepository.findBypath(s);
            cuaHangEntity.getImageEntities().add(imageEntity);
        });
        cuaHangRepository.save(cuaHangEntity);

    }
}

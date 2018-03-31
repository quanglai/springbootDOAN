package com.example.demo.RestControllerIpm;

import com.example.demo.Dto.LoaiSanPhamDto;
import com.example.demo.Entity.LoaiSanPhamEntity;
import com.example.demo.Entity.SanPhamEntity;
import com.example.demo.Repository.LoaiSanPhamRepository;
import com.example.demo.RestController.LoaiSanPhamRest;
import com.example.demo.TransFrom.ConvertLoaiSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/loaisanpham")
public class LoaiSanPhamRestIpm implements LoaiSanPhamRest {
    @Autowired
    LoaiSanPhamRepository loaiSanPhamRepository;
    @Autowired
    ConvertLoaiSanPham convertLoaiSanPham;
    @Override
    public List<LoaiSanPhamDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<LoaiSanPhamDto> findOne( @PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity<LoaiSanPhamDto> save(@RequestBody LoaiSanPhamDto loaiSanPhamDto) {
        return null;
    }

    @Override
    public ResponseEntity<LoaiSanPhamDto> delete( @PathVariable (name = "id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity<LoaiSanPhamDto> update(@RequestBody LoaiSanPhamDto loaiSanPhamDto) {
        return null;
    }
}

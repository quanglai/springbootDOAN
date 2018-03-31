package com.example.demo.RestControllerIpm;

import com.example.demo.Dto.SanPhamDto;
import com.example.demo.RestController.SanPhamRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/sanpham")
public class SanPhamRestIpm implements SanPhamRest {
    @Override
    public List<SanPhamDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<SanPhamDto> findOne(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity<SanPhamDto> save(@RequestBody SanPhamDto sanPhamDto) {
        return null;
    }

    @Override
    public ResponseEntity<SanPhamDto> delete(@PathVariable (name = "id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity<SanPhamDto> update(@RequestBody SanPhamDto sanPhamDto) {
        return null;
    }
}

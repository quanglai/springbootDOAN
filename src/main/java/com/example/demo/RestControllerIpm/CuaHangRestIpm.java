package com.example.demo.RestControllerIpm;

import com.example.demo.Dto.CuaHangDto;
import com.example.demo.Entity.CuaHangEntity;
import com.example.demo.RestController.CuaHangRest;
import com.example.demo.Sevice.CuaHangSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/cuahang")
public class CuaHangRestIpm implements CuaHangRest{
    @Autowired
    CuaHangSevice cuaHangSevice;
    @Override
    public List<CuaHangDto> findAll() {
        return (List<CuaHangDto>) cuaHangSevice.findAll();
    }

    @Override
    public ResponseEntity<CuaHangDto> findOne(@PathVariable (name = "id") Long id) {
        CuaHangDto cuaHangDto = cuaHangSevice.findOne(id);
        return ResponseEntity.ok(cuaHangDto);
    }

    @Override
    public ResponseEntity<CuaHangDto> save(@RequestBody CuaHangDto cuaHangDto) {

        System.out.println(" save store");
        cuaHangDto.setID_account(1L);
        cuaHangDto.setTrangthai(true);
        cuaHangDto.setNgayDangKy(new Date());
        cuaHangSevice.save(cuaHangDto);

        return null;
    }

    @Override
    public ResponseEntity<CuaHangDto> delete(@PathVariable (name = "id") Long id) {
        cuaHangSevice.delete(id);
        return ResponseEntity.ok(cuaHangSevice.findOne(id));
    }

    @Override
    public ResponseEntity<CuaHangDto> update(@RequestBody CuaHangDto cuaHangDto) {
        cuaHangSevice.update(cuaHangDto);
        return ResponseEntity.ok(cuaHangDto);
    }

}

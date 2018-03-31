package com.example.demo.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoaiSanPhamDto {
    private Long id;
    private String tenLoaiSP;
    private List<Long> listSanPham = new ArrayList<>();
}

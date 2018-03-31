package com.example.demo.Dto;

import lombok.Data;

@Data
public class KhuyenMaiDto {
    private Long id;
    private String chuThich;
    private int phanTramKM;
    private double giaKM;
    private Long ID_sanPhamDto;
}

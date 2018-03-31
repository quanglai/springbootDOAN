package com.example.demo.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CuaHangDto {

    private Long id;
    private String icon;
    private String diachi;
    private String gioithieu;
    private boolean trangthai;
    private String phone;
    private String email;
    private String tenCuaHang;
    private Date ngayDangKy;
    private String toadoX;
    private String toadoY;
    private List<Long> listSanPham =  new ArrayList<>();
    private List<String> listImage = new ArrayList<>();
    private Long ID_account;

}

package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class CuaHangEntity {
    @Id
    @GeneratedValue()
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
    @OneToMany(mappedBy = "cuaHangEntity")
    List<SanPhamEntity> sanPhamEntities =  new ArrayList<>();

    @OneToMany(mappedBy = "cuaHangEntity")
    List<ImageEntity> imageEntities =  new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;
}

package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class KhuyenMaiEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String chuThich;
    private int phanTramKM;
    private double giaKM;
    @OneToOne(mappedBy = "khuyenMaiEntity")
    private SanPhamEntity sanPhamEntity;

}

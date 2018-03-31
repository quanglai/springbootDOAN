package com.example.demo.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Data
public class AccountDto {
    private Long id;
    private String email;
    private String pwd;
    private List<String> listRole = new ArrayList<>(0);
    private List<Long> listCuaHang =  new ArrayList<>();
}

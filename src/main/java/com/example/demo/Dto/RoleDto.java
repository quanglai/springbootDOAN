package com.example.demo.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class RoleDto {
    private Long id;
    private String role;
    private List<String> listAccount = new ArrayList<>(0);
}

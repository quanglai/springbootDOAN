package com.example.demo.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@ToString
public class AccountEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String email;
    private String pwd;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
            @JoinTable(name = "role_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleList = new ArrayList<>();

    @OneToMany(mappedBy = "accountEntity")
    private List<CuaHangEntity> cuaHangEntities =  new ArrayList<>(0);

}

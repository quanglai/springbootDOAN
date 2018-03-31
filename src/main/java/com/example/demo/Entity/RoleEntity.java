package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class RoleEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String role;
    @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AccountEntity> accountEntities = new ArrayList<>();
}

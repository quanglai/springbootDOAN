package com.example.demo.TransFrom;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Entity.AccountEntity;

import java.util.List;

public interface Convert<E,D> {
    E convertToEntity(D d);
    D convertToDto(E e);
    List<E> convertListToEntity(List<D> ds);
    List<D> convertListToDto(List<E> es);

}

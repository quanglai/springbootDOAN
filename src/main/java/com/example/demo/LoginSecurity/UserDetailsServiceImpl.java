package com.example.demo.LoginSecurity;

import com.example.demo.Dto.AccountDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Sevice.AccountSevice;
import com.example.demo.Sevice.RoleSevice;
import com.example.demo.TransFrom.ConvertAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    AccountSevice accountSevice;
    @Autowired
    RoleSevice roleSevice;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ConvertAccount convertAccount;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AccountDto accountDto = accountSevice.findbyEmail(email);

        if (accountDto == null) {
            throw  new UsernameNotFoundException("User " + email + " was not found in the database");
        }
        List<String> roles = accountDto.getListRole();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roles != null) {
            for (String role:roles){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(accountDto.getEmail(), //
                accountDto.getPwd(), grantList);
        System.out.println("user=="+userDetails);

        return userDetails;
    }
}

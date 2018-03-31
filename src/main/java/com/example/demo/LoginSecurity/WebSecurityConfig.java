
package com.example.demo.LoginSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsServiceImpl detailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
//        auth.inMemoryAuthentication()
//                .withUser("USER").password("123").roles("USER");
//        auth.inMemoryAuthentication()
//                .withUser("ADMIN").password("123").roles("ADMIN");

        auth.userDetailsService(detailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().disable();
        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers( "/","/login", "/logout","/home","/webjars/**","/h2-console/**","/account/**","/role/**").permitAll();


        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
       // http.authorizeRequests().antMatchers("/web").access("hasAnyRole('USER','ADMIN')");

        //http.authorizeRequests().antMatchers("/home").access("hasRole('USER')");

        // Trang chỉ dành cho ADMIN
          http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").and().httpBasic();
          http.authorizeRequests().antMatchers("/shop").hasRole("USER").and().httpBasic();

        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .usernameParameter("email")//
                .passwordParameter("password")
                .defaultSuccessUrl("/home ")//
                .failureUrl("/login?error=true")//

                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies();
    }

}


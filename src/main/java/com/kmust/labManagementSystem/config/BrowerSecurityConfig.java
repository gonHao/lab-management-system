package com.kmust.labManagementSystem.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//
//    /**
//     * 防止静态资源被拦截器拦截
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers();
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutUrl("/logout")
                .logoutSuccessUrl("/user/login")
                .invalidateHttpSession(true)
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/index")
                .and()
                .authorizeRequests()
                .antMatchers("/user/login","/assets/**","/dist/**","/docs/**",
                        "/dashboard.css","/jquery-3.3.1.js","/menu.css","/user/getUserInfo","/updatePwd","/pwd","/tTable/findTimeTables","/tTable/findClassInfo").permitAll()
                .antMatchers("/tTable/**","/class/**","/index").hasRole("teachingAdmin")
                .antMatchers("/user/**","/index").hasRole("admin")

                .anyRequest().authenticated()
                .and().csrf().disable();
        //                .and()
//                .authorizeRequests()
//                .antMatchers("/userTest").hasRole("students")

//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

    }


}

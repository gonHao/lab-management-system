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
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/index")
                .and()
                .authorizeRequests()
                .antMatchers("/login","/assets/**","/dist/**","/docs/**",
                        "/dashboard.css","/jquery-3.3.1.js","/menu.css").permitAll()
                .antMatchers("/index","/findTimeTables").hasRole("admin")
                .antMatchers("/userTest").hasRole("students")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/userTest").hasRole("students")
                .anyRequest().authenticated()
                .and().csrf().disable();

//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

    }


}

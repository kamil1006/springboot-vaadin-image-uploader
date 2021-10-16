package com.example.springbootvaadinimageuploader.config;

import com.example.springbootvaadinimageuploader.model.AppUser;
import com.example.springbootvaadinimageuploader.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


   private UserDetailsServiceImpl userDetailsSeviceIml;

    private AppUserRepo appUserRepo;



   @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsSeviceIml, AppUserRepo appUserRepo) {
        this.userDetailsSeviceIml = userDetailsSeviceIml;
       this.appUserRepo = appUserRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
       // auth.inMemoryAuthentication()
        // .withUser(new User("kamil", passwordEncoder().encode("kamil123"),  Collections.singleton(new SimpleGrantedAuthority("user"))));

        auth.userDetailsService(userDetailsSeviceIml);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/test1").hasRole("USER")
                .antMatchers("/test2").hasRole("ADMIN")
                .antMatchers("/test4").authenticated()
                .antMatchers("/upload-old").hasRole("ADMIN")
                .antMatchers("/upload").hasRole("ADMIN")
                .antMatchers("/gallery").hasAnyRole("ADMIN","USER")
                .antMatchers("/gallery-by-type").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable()
               // .cors().disable()
                //.headers().frameOptions().disable()
                //.and()
                //.headers().disable()
                .exceptionHandling().accessDeniedPage("/access-denied");
        ;



    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        AppUser appUserUser = new AppUser("kamil", passwordEncoder().encode( "kamil123"),"ROLE_USER");
        AppUser appUserAdmin = new AppUser("kamiladmin", passwordEncoder().encode( "kamil123"),"ROLE_ADMIN");

        AppUser byUsername = appUserRepo.findByUsername(appUserUser.getUsername());
        if(byUsername == null){
            appUserRepo.save(appUserUser);
        }
        byUsername = appUserRepo.findByUsername(appUserAdmin.getUsername());
        if(byUsername == null){
            appUserRepo.save(appUserAdmin);
        }


        //return "";
    }


}

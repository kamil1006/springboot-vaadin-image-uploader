package com.example.springbootvaadinimageuploader.repository;

import com.example.springbootvaadinimageuploader.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

}

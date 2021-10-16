package com.example.springbootvaadinimageuploader.repository;

import com.example.springbootvaadinimageuploader.model.MyImage;
import com.example.springbootvaadinimageuploader.model.MyImageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<MyImage, Long> {

    List<MyImage> findAllByMyImageType(MyImageType myImageType);

}

package com.example.springbootvaadinimageuploader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class MyImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageAddress;
    private LocalDateTime localDateTime;
    private  MyImageType myImageType;


    public MyImage() {

    }

    public MyImage(String imageAddress, LocalDateTime localDateTime) {
        this.imageAddress = imageAddress;
        this.localDateTime = localDateTime;
    }

    public MyImage(String imageAddress, LocalDateTime localDateTime, MyImageType myImageType) {
        this.imageAddress = imageAddress;
        this.localDateTime = localDateTime;
        this.myImageType = myImageType;
    }

    public MyImage(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public MyImageType getMyImageType() {
        return myImageType;
    }

    public void setMyImageType(MyImageType myImageType) {
        this.myImageType = myImageType;
    }
}

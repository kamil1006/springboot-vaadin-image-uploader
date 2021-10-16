package com.example.springbootvaadinimageuploader.poligon;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.springbootvaadinimageuploader.model.MyImage;
import com.example.springbootvaadinimageuploader.model.MyImageType;
import com.example.springbootvaadinimageuploader.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ImageUploader {

    Cloudinary cloudinary;

    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {

        this.imageRepo=imageRepo;
        //----------------------------------------------------------------------
        /*
        here you must put your own credentials to work w ith cloudinary
         */
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "your cloud name",
                "api_key", "your api key",
                "api_secret", "your api secret"));
        /*
        here you must put your own credentials to work w ith cloudinary
         */
        //----------------------------------------------------------------------

    }

    public String uploadFile(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }

    public void saveToDB(String imageUrl, MyImageType myImageType){
        LocalDateTime localDateTime = LocalDateTime.now();

        imageRepo.save(new MyImage(imageUrl,localDateTime,myImageType));
        //return "";
    }

    public String uploadFile2( File file) {
       // File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }


/*
http://res.cloudinary.com/kamil1006/image/upload/v1634244781/fltqqngzdixjk29e8b6a.jpg

http://res.cloudinary.com/kamil1006/image/upload/v1634244781/fltqqngzdixjk29e8b6a.jpg
 */



}

package com.example.springbootvaadinimageuploader.poligon;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImageTest {

    public static void main(String[] args) throws IOException {

       // Cloudinary cloudinary = new Cloudinary();
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "kamil1006",
                "api_key", "513863755634346",
                "api_secret", "y_RTyDO9JTMgmSc2zZaMJYYo0h0"));

        File file = new File("/home/kamil/Pobrane/vaadin/springboot-image-uploader/src/main/resources/static/my_image1.jpg");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
/*
http://res.cloudinary.com/kamil1006/image/upload/v1634244781/fltqqngzdixjk29e8b6a.jpg
 */

    }

}

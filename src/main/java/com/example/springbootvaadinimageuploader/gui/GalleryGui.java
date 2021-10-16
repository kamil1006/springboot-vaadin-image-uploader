package com.example.springbootvaadinimageuploader.gui;

import com.example.springbootvaadinimageuploader.model.MyImage;
import com.example.springbootvaadinimageuploader.repository.ImageRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;
import java.util.List;

@Route("gallery")
@StyleSheet("/css/style.css")
public class GalleryGui extends VerticalLayout {

    private ImageRepo imageRepo;

    public GalleryGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        Button buttonBack = new Button("back", event -> {

            UI.getCurrent().getPage().setLocation("/");
           // UI.getCurrent().getSession().close();
            //  UI.getCurrent().getPage().executeJs("window.location.href='/'");
        });
        add(buttonBack);


        List<MyImage> allImages = imageRepo.findAll();

        allImages.stream().forEach( element ->{
            Image image = new Image(element.getImageAddress(),"no image");
            image.setMaxWidth(500, Unit.PIXELS);
            add(image);
            LocalDateTime localDateTime = element.getLocalDateTime();
            String s = "Uploaded at : "+localDateTime;
            add(s);


        });

    }



}

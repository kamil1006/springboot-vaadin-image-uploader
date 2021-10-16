package com.example.springbootvaadinimageuploader.gui;

import com.example.springbootvaadinimageuploader.model.MyImage;
import com.example.springbootvaadinimageuploader.model.MyImageType;
import com.example.springbootvaadinimageuploader.repository.ImageRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;
import java.util.List;

@Route("gallery-by-type")
@StyleSheet("/css/style.css")
public class GalleryByTypeGui extends VerticalLayout {

    private ImageRepo imageRepo;

    public GalleryByTypeGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        Button buttonBack = new Button("back", event -> {

            UI.getCurrent().getPage().setLocation("/");
           // UI.getCurrent().getSession().close();
            //  UI.getCurrent().getPage().executeJs("window.location.href='/'");
        });

        ComboBox<MyImageType> myImageTypeComboBox = new ComboBox<>("Image type:",MyImageType.values());

        add(buttonBack);
        add(myImageTypeComboBox);

        myImageTypeComboBox.addValueChangeListener(click ->{


            removeAll();
            add(buttonBack);
            add(myImageTypeComboBox);

            List<MyImage> allImages = imageRepo.findAllByMyImageType(myImageTypeComboBox.getValue());

            allImages.stream().forEach( element ->{
                Image image = new Image(element.getImageAddress(),"no image");
                image.setMaxWidth(500, Unit.PIXELS);
                add(image);
                LocalDateTime localDateTime = element.getLocalDateTime();
                String s = "Uploaded at : "+localDateTime;
                add(s);


            });



        });







    }



}

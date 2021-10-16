package com.example.springbootvaadinimageuploader.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

//@PWA(name = "vaadin-1", shortName = "vaadin-1", enableInstallPrompt = false)
//@Theme(themeFolder = "vaadin-1")
//@PageTitle("Main")
@Route("")
@StyleSheet("/css/style.css")
public class MainGui extends VerticalLayout {


    public MainGui() {

        Label label = new Label();
        label.setText("Welcome");
        add(label);


        Button buttonUploadOld = new Button("upload", event -> {
              UI.getCurrent().getPage().executeJs("window.location.href='/upload-old'");
        });
        add(buttonUploadOld);

        Button buttonUpload = new Button("upload-new", event -> {
            UI.getCurrent().getPage().executeJs("window.location.href='/upload'");
        });
       // add(buttonUpload);

        Button buttonGallery = new Button("Gallery", event -> {
            UI.getCurrent().getPage().executeJs("window.location.href='/gallery'");
        });
        add(buttonGallery);

        Button buttonGalleryByType = new Button("Gallery by Type", event -> {
            UI.getCurrent().getPage().executeJs("window.location.href='/gallery-by-type'");
        });
        add(buttonGalleryByType);

        Button btlLogout = new Button("logout", event -> {
            UI.getCurrent().getPage().executeJs("window.location.href='/logout'");
        });
        add(btlLogout);




    }
}

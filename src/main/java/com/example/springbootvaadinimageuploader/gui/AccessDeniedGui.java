package com.example.springbootvaadinimageuploader.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

//@PWA(name = "vaadin-1", shortName = "vaadin-1", enableInstallPrompt = false)
//@Theme(themeFolder = "vaadin-1")
//@PageTitle("Main")
@Route("access-denied")
public class AccessDeniedGui extends VerticalLayout {


    public AccessDeniedGui() {

        Label label = new Label();
        label.setText("You do not have enough credentials");
        add(label);




        Button buttonGallery = new Button("main page", event -> {
            UI.getCurrent().getPage().executeJs("window.location.href='/'");
        });
        add(buttonGallery);

        Button btlLogout = new Button("logout", event -> {
            UI.getCurrent().getPage().executeJs("window.location.href='/logout'");
        });
        add(btlLogout);




    }
}

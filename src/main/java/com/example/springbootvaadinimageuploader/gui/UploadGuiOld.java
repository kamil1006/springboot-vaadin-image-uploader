package com.example.springbootvaadinimageuploader.gui;

import com.example.springbootvaadinimageuploader.model.MyImageType;
import com.example.springbootvaadinimageuploader.poligon.ImageUploader;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("upload-old")
@StyleSheet("/css/style.css")
public class UploadGuiOld extends VerticalLayout {

    private TextField textField;
    private Button button;
    private Label label;
    Image image;

    private ImageUploader imageUploader;

    @Autowired
    public UploadGuiOld(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;

        label = new Label();

        ComboBox<MyImageType> myImageTypeComboBox = new ComboBox<>("Image type:",MyImageType.values());


        textField = new TextField();
        textField.setMinWidth(600, Unit.PIXELS);

        button = new Button("upload image");
        button.addClickListener(buttonClickEvent -> {
            MyImageType value = myImageTypeComboBox.getValue();
          if(value == null){

              Notification notification = new Notification(
                      "You have to choose type of image", 3000);
              notification.open();


          }
            else {
              String imageUrl =   imageUploader.uploadFile(textField.getValue());
              imageUploader.saveToDB(imageUrl,value);
              image = new Image(imageUrl,"no image");
              label.setText("upload complete!");
              add(label,image);
          }


        });

        Button buttonBack = new Button("back", event -> {

            UI.getCurrent().getPage().setLocation("/");
           // UI.getCurrent().getSession().close();
            //  UI.getCurrent().getPage().executeJs("window.location.href='/'");
        });
        add(buttonBack);
        add(myImageTypeComboBox);
        add(textField);
        add(button);

        /*
        Button button2 = new Button("Link text");
        RouterLink routerLink = new RouterLink("", GalleryGui.class);
        routerLink.getElement().appendChild(button2.getElement());
        add(routerLink); // don't add the Button to the layout
        */
/*
        Button buttonLogout = new Button("Logout", event -> {
          //  UI.getCurrent().navigate("upload-old");
            System.out.println("tttu");
            UI.getCurrent().getPage().setLocation("/logout");
            UI.getCurrent().getSession().close();
          //  UI.getCurrent().getPage().executeJs("window.location.href='/'");
        });
        add(buttonLogout);
*/

        /*
        add(new Button("logout", ev->{
            UI.getCurrent().getPage().setLocation("/logout");
            UI.getCurrent().getSession().close();
        }));
    */
/*
        add(new Button("index", ev->{
           // UI.getCurrent().getPage().setLocation("/indexx.html");
           // UI.getCurrent().getSession().close();

             UI.getCurrent().getPage().setLocation("/indexx.html");
             UI.getCurrent().getSession().close();


           // getUI().ifPresent(ui -> {
           //     ui.getPage().executeJs("window.location.href = 'indexx.html'");

          //  });



        }));
         */



    }
}

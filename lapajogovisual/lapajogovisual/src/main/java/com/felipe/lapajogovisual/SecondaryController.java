package com.felipe.lapajogovisual;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SecondaryController implements Initializable{
    
    @FXML
    private ImageView willmar;
    
    @FXML
    private ImageView suspeito;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("escolhaPersonagem");
    }
    
    @FXML
    private void istru() throws IOException {
        App.setRoot("info");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image(getClass().getResourceAsStream("MenuTOP.png"));
        willmar.setImage(img);
        willmar.setPreserveRatio(false);
        
        Image img1 = new Image(getClass().getResourceAsStream("suspeito.jpg"));
        suspeito.setImage(img1);
        suspeito.setPreserveRatio(false);
  
    }
    
}
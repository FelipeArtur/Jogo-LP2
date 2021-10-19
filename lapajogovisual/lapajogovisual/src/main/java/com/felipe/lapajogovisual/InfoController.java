package com.felipe.lapajogovisual;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InfoController implements Initializable{
    
    @FXML
    private ImageView fundo;
    
    @FXML
    private void menu() throws IOException {

        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image(getClass().getResourceAsStream("fundolindo.jpg"));
        fundo.setImage(img);
        fundo.setPreserveRatio(false);
    }
}

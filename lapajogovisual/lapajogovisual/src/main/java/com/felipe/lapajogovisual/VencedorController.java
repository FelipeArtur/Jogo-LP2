package com.felipe.lapajogovisual;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class VencedorController implements Initializable{ 
    
  @FXML
  private ImageView racoba;
  
  @FXML
  private ImageView fundo;
  
  @FXML
  private Text vencedor;
    
  @FXML
   private void menu() throws IOException {
        App.setRoot("secondary");
   }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image(getClass().getResourceAsStream("racoba.jpg"));
        racoba.setImage(img);
        
        Image img2 = new Image(getClass().getResourceAsStream("fundolindo.jpg"));
        fundo.setImage(img2);
        fundo.setPreserveRatio(false);
        
        vencedor.setText("Parabéns: "+App.jogadorVencedor.getNome()+" você venceu a partida, sua recompensa foi salva!");
    }
    
}

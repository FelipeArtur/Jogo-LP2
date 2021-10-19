package com.felipe.lapajogovisual;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EscolhaMapaController implements Initializable{
    
    @FXML
    private ImageView mapa2;

    @FXML
    private ImageView mapa1;
    
    @FXML
    private ImageView mapa3;
     
    @FXML
    private ImageView fundo;
    
    public void iniciaMapa() throws IOException{

        App.map = new Mapa();
        
        App.tabuleiro = new char[0][0];
        App.tabuleiro = App.map.escolha(App.tabuleiro, 1);
        App.map.mostrarmapa(App.tabuleiro); 
        
        App.setRoot("posiciona");
    }
    
    public void iniciaMapa2() throws IOException{

        App.map = new Mapa();
        
        App.tabuleiro = new char[0][0];
        App.tabuleiro = App.map.escolha(App.tabuleiro, 2);
        App.map.mostrarmapa(App.tabuleiro); 
        
        App.setRoot("posiciona");
    }    
    
    public void iniciaMapa3() throws IOException{

        App.map = new Mapa();
        
        App.tabuleiro = new char[0][0];
        App.tabuleiro = App.map.escolha(App.tabuleiro, 3);
        App.map.mostrarmapa(App.tabuleiro); 
        
        App.setRoot("posiciona");
    }    
    
   public void usarItem() throws IOException{
        //jogador1
        if(App.J[App.comeca1].verificaJog(App.J[App.comeca1]) == 0){
            
            System.out.println("Personagem: 1 "+App.J[App.comeca1].P[0].getNome());
            System.out.println("Personagem: 2 "+App.J[App.comeca1].P[1].getNome());
            System.out.println("Personagem: 3 "+App.J[App.comeca1].P[2].getNome());        
            for(;;){
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"ITEM:");
                dialog.setHeaderText("Personagem: 1 -"+App.J[App.comeca1].P[0].getNome()+
                "\nPersonagem: 2 -"+App.J[App.comeca1].P[1].getNome()+
                "\nPersonagem: 3 -"+App.J[App.comeca1].P[2].getNome()        
                );
                dialog.setContentText(App.J[App.comeca1].getNome() +" DIGITE O PERSONAGEM QUE GOSTARIA DE APLICAR O ITEM");
            
                Optional<String> result = dialog.showAndWait();
                int op = Integer.parseInt(result.get()); 

                if(op == 1){
                    App.J[App.comeca1].usaritem(App.J[App.comeca1], App.J[App.comeca1].P[0]);
                    break;
                }else if(op == 2){
                    App.J[App.comeca1].usaritem(App.J[App.comeca1], App.J[App.comeca1].P[1]);
                    break;                
                }else if(op == 3){
                    App.J[App.comeca1].usaritem(App.J[App.comeca1], App.J[App.comeca1].P[2]);
                    break;                
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado incorreto"); a1.setHeaderText(null); a1.showAndWait();                    
                }                
  
            }
        }else{
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O jogador "+App.J[App.comeca1].getNome() +" não possui item"); a1.setHeaderText(null); a1.showAndWait();
        }
        //Jogador2
        if(App.J[App.comeca1].verificaJog(App.J[App.comeca2]) == 0){
            
            System.out.println("Personagem: 1 "+App.J[App.comeca2].P[0].getNome());
            System.out.println("Personagem: 2 "+App.J[App.comeca2].P[1].getNome());
            System.out.println("Personagem: 3 "+App.J[App.comeca2].P[2].getNome()); 
            for(;;){
                
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"ITEM:");
                dialog.setHeaderText("Personagem: 1 -"+App.J[App.comeca2].P[0].getNome()+
                "\nPersonagem: 2 -"+App.J[App.comeca1].P[1].getNome()+
                "\nPersonagem: 3 -"+App.J[App.comeca2].P[2].getNome()        
                );
                dialog.setContentText(App.J[App.comeca2].getNome() +" DIGITE O PERSONAGEM QUE GOSTARIA DE APLICAR O ITEM");
            
                Optional<String> result = dialog.showAndWait();
                int op = Integer.parseInt(result.get());
                
                
                if(op == 1){
                    App.J[App.comeca2].usaritem(App.J[App.comeca2], App.J[App.comeca2].P[0]);
                    break;
                }else if(op == 2){
                    App.J[App.comeca2].usaritem(App.J[App.comeca2], App.J[App.comeca2].P[1]);
                    break;              
                }else if(op == 3){
                    App.J[App.comeca2].usaritem(App.J[App.comeca2], App.J[App.comeca2].P[2]);
                    break;              
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado incorreto"); a1.setHeaderText(null); a1.showAndWait();                    
                }
          
            }
        }else{
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O jogador "+App.J[App.comeca2].getNome() +" não possui item"); a1.setHeaderText(null); a1.showAndWait(); 
        }        
        
    
   }

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image(getClass().getResourceAsStream("Mapa1.png"));
        mapa1.setImage(img);
        mapa1.setPreserveRatio(false);
        
        Image img1 = new Image(getClass().getResourceAsStream("Mapa2.png"));
        mapa2.setImage(img1);
        mapa2.setPreserveRatio(false);
        
        Image img2 = new Image(getClass().getResourceAsStream("Mapa3.png"));
        mapa3.setImage(img2);
        //mapa3.setPreserveRatio(false);
        
        Image img3 = new Image(getClass().getResourceAsStream("fundolindo.jpg"));
        fundo.setImage(img3);
        fundo.setPreserveRatio(false);
    }



}

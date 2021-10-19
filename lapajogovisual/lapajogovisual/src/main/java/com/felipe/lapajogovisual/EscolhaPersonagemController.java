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

public class EscolhaPersonagemController implements Initializable{
    
    @FXML
    private ImageView lindo;

    @FXML
    private ImageView Zagreus;

    @FXML
    private ImageView Oryx;

    @FXML
    private ImageView Batman;

    @FXML
    private ImageView Zatanna;

    @FXML
    private ImageView Zoro;

    @FXML
    private ImageView Artemis;
        
    public void escolherPersonagens() throws IOException {
        //==========colocar no menu
        App.J = new Jogador[2];
        
        TextInputDialog dialogx = new TextInputDialog("OLA");
        dialogx.setTitle(null);
        dialogx.setHeaderText(null);
        dialogx.setContentText("Jogador 1 - Digite o seu nome");    
        Optional<String> resultx = dialogx.showAndWait();
                
        TextInputDialog dialogy = new TextInputDialog("OLA");
        dialogy.setTitle(null);
        dialogy.setHeaderText(null);
        dialogy.setContentText("Jogador 2 - Digite o seu nome");
        Optional<String> resulty = dialogy.showAndWait();
        
        String x = new String();
        String y = new String();
        x = resultx.get();
        y = resulty.get();
        App.J[0] = new Jogador(x);
        App.J[1] = new Jogador(y);        
    
        App.J[0].setLado(App.J[0].sorteio());  
        
        if(App.J[0].getLado() == 1){
            App.comeca1 = 0;
            App.comeca2 = 1;
            App.J[1].setLado(2);
        }else{
            App.comeca1 = 1;
            App.comeca2 = 0;
            App.J[1].setLado(1); 
        }
        //====================
        
        App.J[0].setP(new Personagem[3]);
        App.J[1].setP(new Personagem[3]);        
        
        boolean JaescolheuZoro = false;
        boolean JaescolheuZagreu = false;
        boolean JaescolheuArtemis = false;
        boolean JaescolheuBatman = false;
        boolean JaescolheuZatanna = false;
        boolean JaescolheuOryx = false;   
        
        for(int i = 0; i < 3; i++){// 6 personagens (3 de cada jogador); // nao pode repetir personagens
             
            for(;;){
                
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"Personagem:");
                dialog.setHeaderText("Escolha de Personagem");
                dialog.setContentText(App.J[App.comeca1].getNome()+" - Selecione o personagem desejado ");
            
                Optional<String> result = dialog.showAndWait();
                int op = Integer.parseInt(result.get());
                
                if(op == 1 && JaescolheuZoro == false){
                  App.J[App.comeca1].P[i] = new Zoro();
                  JaescolheuZoro = true;
                  break;
                }else if(op == 2 && JaescolheuZagreu == false){
                  App.J[App.comeca1].P[i] = new Zagreu();
                  JaescolheuZagreu = true;
                  break;
                }else if(op == 3 && JaescolheuArtemis == false){
                  App.J[App.comeca1].P[i] = new Artemis(); 
                  JaescolheuArtemis = true;
                  break;
                }else if(op == 4 && JaescolheuBatman == false){
                  App.J[App.comeca1].P[i] = new Batman(); 
                  JaescolheuBatman = true;
                  break;
                }else if(op == 5 && JaescolheuZatanna == false){
                  App.J[App.comeca1].P[i] = new Zatanna(); 
                  JaescolheuZatanna = true;
                  break;
                }else if(op == 6 && JaescolheuOryx == false){
                  App.J[App.comeca1].P[i] = new Oryx(); 
                  JaescolheuOryx = true;
                  break;
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Numero do personagem incorreto ou Personagem ja foi escolhido por outro jogador "); a1.setHeaderText(null); a1.showAndWait();
                }                
                
            }
            
            for(;;){
                
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"Personagem:");
                dialog.setHeaderText("Escolha de Personagem");
                dialog.setContentText(App.J[App.comeca2].getNome()+" - Selecione o personagem desejado ");
            
                Optional<String> result = dialog.showAndWait();
                int op = Integer.parseInt(result.get());
                
                if(op == 1 && JaescolheuZoro == false){
                  App.J[App.comeca2].P[i] = new Zoro();
                  JaescolheuZoro = true;
                  break;
                }else if(op == 2 && JaescolheuZagreu == false){
                  App.J[App.comeca2].P[i] = new Zagreu();
                  JaescolheuZagreu = true;
                  break;
                }else if(op == 3 && JaescolheuArtemis == false){
                  App.J[App.comeca2].P[i] = new Artemis(); 
                  JaescolheuArtemis = true;
                  break;
                }else if(op == 4 && JaescolheuBatman == false){
                  App.J[App.comeca2].P[i] = new Batman(); 
                  JaescolheuBatman = true;
                  break;
                }else if(op == 5 && JaescolheuZatanna == false){
                  App.J[App.comeca2].P[i] = new Zatanna(); 
                  JaescolheuZatanna = true;
                  break;
                }else if(op == 6 && JaescolheuOryx == false){
                  App.J[App.comeca2].P[i] = new Oryx(); 
                  JaescolheuOryx = true;
                  break;
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Numero do personagem incorreto ou Personagem ja foi escolhido por outro jogador "); a1.setHeaderText(null); a1.showAndWait();
                }                
                
            }
        }        
        App.setRoot("escolhaMapa");
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image(getClass().getResourceAsStream("ZoroEscolha.jpg"));
        Zoro.setImage(img);
        Zoro.setPreserveRatio(false);
        
        Image img1 = new Image(getClass().getResourceAsStream("ZagreusEscolha.jpg"));
        Zagreus.setImage(img1);
        Zagreus.setPreserveRatio(false);
        
        Image img2 = new Image(getClass().getResourceAsStream("ArtemisEscolha.jpg"));
        Artemis.setImage(img2);
        Artemis.setPreserveRatio(false);
        
        Image img3 = new Image(getClass().getResourceAsStream("BatmanEscolha.jpg"));
        Batman.setImage(img3);
        Batman.setPreserveRatio(false);
        
        Image img4 = new Image(getClass().getResourceAsStream("ZatannaEscolha.jpg"));
        Zatanna.setImage(img4);
        Zatanna.setPreserveRatio(false);
        
        Image img5 = new Image(getClass().getResourceAsStream("OryxEscolha.jpg"));
        Oryx.setImage(img5);
        Oryx.setPreserveRatio(false);
        
        Image img6 = new Image(getClass().getResourceAsStream("teste.jpg"));
        lindo.setImage(img6);
        lindo.setPreserveRatio(false);
    }







}

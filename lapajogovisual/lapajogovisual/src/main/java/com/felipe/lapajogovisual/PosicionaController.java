/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.lapajogovisual;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;


public class PosicionaController implements Initializable{
    public int cont;
    
    @FXML
    private ImageView fundoimagem;
    
    @FXML
    private ImageView fundostatus;
    
    @FXML
    private ImageView fundobutton;
    
    @FXML
    private AnchorPane nav;
    
    @FXML
    private ImageView perso0;
    
    @FXML
    private ImageView perso1;
    
    @FXML
    private ImageView perso2;    
    
    @FXML
    private ImageView perso3;
    
    @FXML
    private ImageView perso4;
    
    @FXML
    private ImageView perso5;  
    
    //Jogador 1
    @FXML
    private Label j1;
    
    //Jogador 2
    @FXML
    private Label j2;
    
    //Jogador 1 personagens
    @FXML
    private Label p0j1;
    
    @FXML
    private Label p1j1;
    
    @FXML
    private Label p2j1;
    
    //Jogador 2 personagens
    @FXML
    private Label p0j2;
    
    @FXML
    private Label p1j2;
    
    @FXML
    private Label p2j2;
    
     public void status(){
       //Nome dos jogadores 
       j1.setText("Jogador(a): "+App.J[App.comeca1].getNome());
       j2.setText("Jogador(a): "+App.J[App.comeca2].getNome());
       
       //Personagens jogador 1
       p0j1.setText("0 -> "+App.J[App.comeca1].P[0].getNome()+" - vida: "+App.J[App.comeca1].P[0].getVida()+" - PH: "+App.J[App.comeca1].P[0].getPh());
       p1j1.setText("1 -> "+App.J[App.comeca1].P[1].getNome()+" - vida: "+App.J[App.comeca1].P[1].getVida()+" - PH: "+App.J[App.comeca1].P[1].getPh());
       p2j1.setText("2 -> "+App.J[App.comeca1].P[2].getNome()+" - vida: "+App.J[App.comeca1].P[2].getVida()+" - PH: "+App.J[App.comeca1].P[2].getPh());
       
       //Personagem jogador 2
       p0j2.setText("0 -> "+App.J[App.comeca2].P[0].getNome()+" - vida: "+App.J[App.comeca2].P[0].getVida()+" - PH: "+App.J[App.comeca2].P[0].getPh());
       p1j2.setText("1 -> "+App.J[App.comeca2].P[1].getNome()+" - vida: "+App.J[App.comeca2].P[1].getVida()+" - PH: "+App.J[App.comeca2].P[1].getPh());
       p2j2.setText("2 -> "+App.J[App.comeca2].P[2].getNome()+" - vida: "+App.J[App.comeca2].P[2].getVida()+" - PH: "+App.J[App.comeca2].P[2].getPh());
       
    }
    
    public void Posiciona() throws IOException{
       
            copiarTabuleiro();  
            System.out.println("Posicione o "+App.J[App.comeca1].P[cont].getNome());
            App.map.Posiciona(App.tabuleiro, App.J[App.comeca1].P[cont], App.J[App.comeca1]);
            copiarTabuleiro(); 
            System.out.println("Posicione o "+App.J[App.comeca2].P[cont].getNome());
            App.map.Posiciona(App.tabuleiro, App.J[App.comeca2].P[cont] , App.J[App.comeca2]);
            //copiarTabuleiro();          
            cont++;
        if(cont == 3){
            App.setRoot("primary");
        }
    }
    
       public void criarMapa(){
        App.mapa = new Rectangle[App.tabuleiro.length][App.tabuleiro.length];
        for(int l = 0; l < App.tabuleiro.length; l++){
            for(int c = 0; c < App.tabuleiro.length; c++){
                App.mapa[l][c] = new Rectangle(c*500/App.tabuleiro.length, l*500/App.tabuleiro.length, 500/App.tabuleiro.length, 500/App.tabuleiro.length);
                
                if(App.tabuleiro[l][c] == 'x' || App.tabuleiro[l][c] == 'y' || App.tabuleiro[l][c] == 'p' || App.tabuleiro[l][c] == 'e' || App.tabuleiro[l][c] == 'f'){
                    App.mapa[l][c].setStyle("-fx-fill : #ffffff");   
                }else if((l%2==0 && c%2==0) || (l%2==1 && c%2==1)){
                    App.mapa[l][c].setStyle("-fx-fill : #858282");
                }else{
                    App.mapa[l][c].setStyle("-fx-fill : #999797");
                }
                
                nav.getChildren().add(App.mapa[l][c]);
            }
        }
    }
           
    public void criarPerso(){
        App.mapaPersonagens = new ImageView[App.tabuleiro.length][App.tabuleiro.length];
        for(int l = 0; l < App.tabuleiro.length; l++){
            for(int c = 0; c < App.tabuleiro.length; c++){
                App.mapaPersonagens[l][c] = new ImageView();
                App.mapaPersonagens[l][c].setFitHeight(500/App.tabuleiro.length);
                App.mapaPersonagens[l][c].setFitWidth(500/App.tabuleiro.length);
                App.mapaPersonagens[l][c].setX(c*500/App.tabuleiro.length);
                App.mapaPersonagens[l][c].setY(l*500/App.tabuleiro.length);
                App.mapaPersonagens[l][c].setLayoutX(0);
                App.mapaPersonagens[l][c].setLayoutY(0);
                
                nav.getChildren().add(App.mapaPersonagens[l][c]);
                
                //nav.getChildren().add(mapa[l][c]);
            }
        }    
    }
    
    public void copiarTabuleiro(){
        
     for(int l = 0; l < App.tabuleiro.length; l++){
        for(int c = 0; c < App.tabuleiro.length; c++){
          //if(App.tabuleiro[l][c] != null)  
            if(App.tabuleiro[l][c] == '$'){
               Image img = new Image(getClass().getResourceAsStream("zoro.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);
                
            }else if(App.tabuleiro[l][c] == '#'){
               Image img = new Image(getClass().getResourceAsStream("zagreu2.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                
                
            }else if(App.tabuleiro[l][c] == '@'){
               Image img = new Image(getClass().getResourceAsStream("Artemis.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                
            }else if(App.tabuleiro[l][c] == 'G'){
               Image img = new Image(getClass().getResourceAsStream("batman.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                  
            }else if(App.tabuleiro[l][c] == 'Z'){
               Image img = new Image(getClass().getResourceAsStream("zatanna.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                 
            }else if(App.tabuleiro[l][c] == 'O'){
               Image img = new Image(getClass().getResourceAsStream("oryx.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                            
            }else if(App.tabuleiro[l][c] == '*'){
               Image img = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                 
            }else if(App.tabuleiro[l][c] == '~'){
              if(App.tabuleiro.length == 9){
               Image img = new Image(getClass().getResourceAsStream("barril.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                  
              }else if(App.tabuleiro.length == 12){
               Image img = new Image(getClass().getResourceAsStream("arvore.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                  
              }else if(App.tabuleiro.length == 13){
               Image img = new Image(getClass().getResourceAsStream("pedra5.png"));
                App.mapaPersonagens[l][c].setImage(img);
                App.mapaPersonagens[l][c].setPreserveRatio(false);                  
              }                
            }
        
       }
     }    
        status();
    }
        
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        criarMapa();
        //criarMadeira();
        criarPerso();   
        status();
        
       //jogador 1 
       Image img = new Image(getClass().getResourceAsStream("zoro.png"));
       perso0.setImage(img);
       Image img2 = new Image(getClass().getResourceAsStream("zagreu2.png"));
       perso1.setImage(img2);
       Image img3 = new Image(getClass().getResourceAsStream("Artemis.png"));
       perso2.setImage(img3);
       
       //jogador 2
       Image img4 = new Image(getClass().getResourceAsStream("batman.png"));
       perso3.setImage(img4);
       Image img5 = new Image(getClass().getResourceAsStream("oryx.png"));
       perso4.setImage(img5);
       Image img6 = new Image(getClass().getResourceAsStream("zatanna.png"));
       perso5.setImage(img6);   
       
       Image img7 = new Image(getClass().getResourceAsStream("areia.jpg"));
       fundoimagem.setImage(img7);
       fundoimagem.setPreserveRatio(false);
       Image img8 = new Image(getClass().getResourceAsStream("paia.gif"));
       fundostatus.setImage(img8);
       fundostatus.setPreserveRatio(false);
       Image img9 = new Image(getClass().getResourceAsStream("grama2.jpg"));
       fundobutton.setImage(img9);
       fundobutton.setPreserveRatio(false);
       
    }
    
    
}

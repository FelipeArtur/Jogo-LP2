package com.felipe.lapajogovisual;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;


public class PrimaryController implements Initializable{
    
    @FXML
    private ImageView fundoimagem;
    
    @FXML
    private ImageView fundostatus;
    
    @FXML
    private ImageView fundobutton;
    
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
       
    @FXML
    public AnchorPane nav;
    
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
    
    public void criarMapa(){
        App.mapa = new Rectangle[App.tabuleiro.length][App.tabuleiro.length];
        for(int l = 0; l < App.tabuleiro.length; l++){
            for(int c = 0; c < App.tabuleiro.length; c++){
                App.mapa[l][c] = new Rectangle(c*500/App.tabuleiro.length, l*500/App.tabuleiro.length, 500/App.tabuleiro.length, 500/App.tabuleiro.length);
                
                if((l%2==0 && c%2==0) || (l%2==1 && c%2==1)){
                    App.mapa[l][c].setStyle("-fx-fill : #0000ff");
                }else{
                    App.mapa[l][c].setStyle("-fx-fill : #4169e1");
                }
                
                nav.getChildren().add(App.mapa[l][c]);
            }
        }
    }
    
    public void criarMadeira(){
        App.mapaMadeira = new ImageView[App.tabuleiro.length][App.tabuleiro.length];
        for(int l = 0; l < App.tabuleiro.length; l++){
            for(int c = 0; c < App.tabuleiro.length; c++){
                App.mapaMadeira[l][c] = new ImageView();
                App.mapaMadeira[l][c].setFitHeight(500/App.tabuleiro.length);
                App.mapaMadeira[l][c].setFitWidth(500/App.tabuleiro.length);
                App.mapaMadeira[l][c].setX(c*500/App.tabuleiro.length);
                App.mapaMadeira[l][c].setY(l*500/App.tabuleiro.length);
                App.mapaMadeira[l][c].setLayoutX(0);
                App.mapaMadeira[l][c].setLayoutY(0);
                if(App.tabuleiro.length == 9){
                    if(App.tabuleiro[l][c] == 'x'){
                        Image img = new Image(getClass().getResourceAsStream("water.gif"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);                    
                    }else if(App.tabuleiro[l][c] == 'y'){
                        Image img = new Image(getClass().getResourceAsStream("wall.png"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }else if(App.tabuleiro[l][c] == 'e'){
                        Image img = new Image(getClass().getResourceAsStream("wallEscada.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);                    
                    }else if(App.tabuleiro[l][c] == 'f'){
                        Image img = new Image(getClass().getResourceAsStream("wallFlag.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }else if(App.tabuleiro[l][c] == 'p'){
                        Image img = new Image(getClass().getResourceAsStream("wallPorta2.png"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);                        
                    }else if((l%2==0 && c%2==0) || (l%2==1 && c%2==1)){
                        Image img = new Image(getClass().getResourceAsStream("madeira4.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }else{
                        Image img = new Image(getClass().getResourceAsStream("madeira5.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }
                }else if(App.tabuleiro.length == 12){
                    if(App.tabuleiro[l][c] == 'x'){
                        Image img = new Image(getClass().getResourceAsStream("grama5.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);                    
                    }else if((l%2==0 && c%2==0) || (l%2==1 && c%2==1)){
                        Image img = new Image(getClass().getResourceAsStream("grama.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }else{
                        Image img = new Image(getClass().getResourceAsStream("grama2.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }                    
                }else if(App.tabuleiro.length == 13){
                    if(App.tabuleiro[l][c] == 'x'){
                        Image img = new Image(getClass().getResourceAsStream("areia3.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);                    
                    }else if(App.tabuleiro[l][c] == 'y'){
                        Image img = new Image(getClass().getResourceAsStream("praia.png"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false); 
                    }else if((l%2==0 && c%2==0) || (l%2==1 && c%2==1)){
                        Image img = new Image(getClass().getResourceAsStream("areia.jpg"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }else{
                        Image img = new Image(getClass().getResourceAsStream("areia2.png"));
                        App.mapaMadeira[l][c].setImage(img);
                        App.mapaMadeira[l][c].setPreserveRatio(false);
                    }                    
                }
                nav.getChildren().add(App.mapaMadeira[l][c]);
            }
        }        
    }
    
    public void criarAnimacao(){
       App.mapaAnimacao = new ImageView[App.tabuleiro.length][App.tabuleiro.length];
        for(int l = 0; l < App.tabuleiro.length; l++){
            for(int c = 0; c < App.tabuleiro.length; c++){
                App.mapaAnimacao[l][c] = new ImageView();
                App.mapaAnimacao[l][c].setFitHeight(500/App.tabuleiro.length);
                App.mapaAnimacao[l][c].setFitWidth(500/App.tabuleiro.length);
                App.mapaAnimacao[l][c].setX(c*500/App.tabuleiro.length);
                App.mapaAnimacao[l][c].setY(l*500/App.tabuleiro.length);
                App.mapaAnimacao[l][c].setLayoutX(0);
                App.mapaAnimacao[l][c].setLayoutY(0);
                
                nav.getChildren().add(App.mapaAnimacao[l][c]);

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

            }
        }    
    }
    
    public void copiarTabuleiro(){
        
    for(int l = 0; l < App.tabuleiro.length; l++){
        for(int c = 0; c < App.tabuleiro.length; c++){
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
               Image img = new Image(getClass().getResourceAsStream("Pedra5.png"));
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
        criarMadeira();
        criarAnimacao();
        criarPerso();        
       //tela
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
       
       //App.mapaMadeira[l][c].setPreserveRatio(false);       
       
        System.out.println("==========================================");
        System.out.println(App.J[0].getNome() +" esta no lado " +App.J[0].getLado());
        System.out.println(App.J[1].getNome() +" esta no lado " +App.J[1].getLado());
        System.out.println("==========================================");       
       imprimir();  
       
       
        //====TURNO
        App.turno = 1;
        copiarTabuleiro();
        //========
        
        
            System.out.println("deu bom");
            imprimir();     
  
    }
            
    public void escolhaItem() throws IOException{
        //jogador1
        if(App.J[App.comeca1].verificaJog(App.J[App.comeca1]) == 0){
            
            System.out.println("Personagem: 1 "+App.J[App.comeca1].P[0].getNome());
            System.out.println("Personagem: 2 "+App.J[App.comeca1].P[1].getNome());
            System.out.println("Personagem: 3 "+App.J[App.comeca1].P[2].getNome());        
            for(;;){
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"ITEM:");
                dialog.setHeaderText("CASO QUEIRA USA-LO");
                dialog.setContentText("DIGITE O PERSONAGEM QUE GOSTARIA DE APLICAR O ITEM");
            
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
        }
        //Jogador2
        if(App.J[App.comeca1].verificaJog(App.J[App.comeca2]) == 0){
            
            System.out.println("Personagem: 1 "+App.J[App.comeca2].P[0].getNome());
            System.out.println("Personagem: 2 "+App.J[App.comeca2].P[1].getNome());
            System.out.println("Personagem: 3 "+App.J[App.comeca2].P[2].getNome()); 
            for(;;){
                
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"ITEM:");
                dialog.setHeaderText("CASO QUEIRA USA-LO");
                dialog.setContentText("DIGITE O PERSONAGEM QUE GOSTARIA DE APLICAR O ITEM");
            
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
        }        
        
    }
        
    public int verificarVencedor(char[][] Mapa) throws IOException{
       int contPersonagens1 = 0;
       int contPersonagens2 = 0; 
       int turnofinal = 11; //Cada um joga 5 vezes
       for (int l = 0; l < Mapa.length - 1; l++){
        for (int c = 0; c < Mapa.length - 1; c++){
          if(Mapa[l][c] == App.J[App.comeca1].P[0].getIcone() || Mapa[l][c] == App.J[App.comeca1].P[1].getIcone() || Mapa[l][c] == App.J[App.comeca1].P[2].getIcone()){
              contPersonagens1++;
          }
          if(Mapa[l][c] == App.J[App.comeca2].P[0].getIcone() || Mapa[l][c] == App.J[App.comeca2].P[1].getIcone() || Mapa[l][c] == App.J[App.comeca2].P[2].getIcone()){
              contPersonagens2++;
          } 
        }
      }
       //CASO UM TIME TODO MORRA
      if(contPersonagens1 == 0){
       App.jogadorVencedor = App.J[App.comeca2];
       System.out.println("O VENCEDOR DA PARTIDA É "+App.jogadorVencedor.getNome());
       App.J[App.comeca1].dadosjogador(App.jogadorVencedor);
       App.setRoot("vencedor");
       return 0;
      }else if(contPersonagens2 == 0){
        App.jogadorVencedor = App.J[App.comeca1];
        System.out.println("O VENCEDOR DA PARTIDA É "+App.jogadorVencedor.getNome());
        App.J[App.comeca1].dadosjogador(App.jogadorVencedor);
        App.setRoot("vencedor");
        return 0;
      } 
     //QUANTIDADE DE JOGADOR EM CADA LADO
      if(App.turno == turnofinal){
          if(contPersonagens1 > contPersonagens2){
              App.jogadorVencedor = App.J[App.comeca1];
              System.out.println("O VENCEDOR DA PARTIDA É "+App.jogadorVencedor.getNome());
              App.J[App.comeca1].dadosjogador(App.jogadorVencedor);
              App.setRoot("vencedor");
              return 0;
          }else if(contPersonagens2 > contPersonagens1){
              App.jogadorVencedor = App.J[App.comeca2];
              System.out.println("O VENCEDOR DA PARTIDA É "+App.jogadorVencedor.getNome());
              App.J[App.comeca1].dadosjogador(App.jogadorVencedor);
              App.setRoot("vencedor");
              return 0;
          }
      }
      //SOMA DAS VIDAS DOS PERSONAGNS DO JOGADORES
      if(App.turno == turnofinal && contPersonagens1 == contPersonagens2){
          if((App.J[App.comeca1].P[0].getVida() + App.J[App.comeca1].P[1].getVida() + App.J[App.comeca1].P[2].getVida()) > (App.J[App.comeca2].P[0].getVida() + App.J[App.comeca2].P[1].getVida() + App.J[App.comeca2].P[2].getVida())){
              App.jogadorVencedor = App.J[App.comeca1];
              System.out.println("O VENCEDOR DA PARTIDA É "+App.jogadorVencedor.getNome());
              App.J[App.comeca1].dadosjogador(App.jogadorVencedor);
              App.setRoot("vencedor");
              return 0;
          }else if((App.J[App.comeca1].P[0].getVida() + App.J[App.comeca1].P[1].getVida() + App.J[App.comeca1].P[2].getVida()) < (App.J[App.comeca2].P[0].getVida() + App.J[App.comeca2].P[1].getVida() + App.J[App.comeca2].P[2].getVida())){
              App.jogadorVencedor = App.J[App.comeca2];
              System.out.println("O VENCEDOR DA PARTIDA É "+App.jogadorVencedor.getNome());
              App.J[App.comeca1].dadosjogador(App.jogadorVencedor);
              App.setRoot("vencedor");
              return 0;
          }else{
              Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("empatou em tudo"); a1.setHeaderText(null); a1.showAndWait();
              App.setRoot("secondary");
          }
      }
      

      
      return 1;
    }    
    
    public void imprimir(){ 
       System.out.println("O personagem 0 do jogador " +App.J[App.comeca1].getNome() + " é "+App.J[App.comeca1].P[0].getNome()+" e possui " +App.J[App.comeca1].P[0].getVida()+" de vida");
       System.out.println("O personagem 1 do jogador " +App.J[App.comeca1].getNome() + " é "+App.J[App.comeca1].P[1].getNome()+" e possui " +App.J[App.comeca1].P[1].getVida()+" de vida");
       System.out.println("O personagem 2 do jogador " +App.J[App.comeca1].getNome() + " é "+App.J[App.comeca1].P[2].getNome()+" e possui " +App.J[App.comeca1].P[2].getVida()+" de vida");
       System.out.println("O personagem 0 do jogador " +App.J[App.comeca2].getNome() + " é "+App.J[App.comeca2].P[0].getNome()+" e possui " +App.J[App.comeca2].P[0].getVida()+" de vida");
       System.out.println("O personagem 1 do jogador " +App.J[App.comeca2].getNome() + " é "+App.J[App.comeca2].P[1].getNome()+" e possui " +App.J[App.comeca2].P[1].getVida()+" de vida");
       System.out.println("O personagem 2 do jogador " +App.J[App.comeca2].getNome() + " é "+App.J[App.comeca2].P[2].getNome()+" e possui " +App.J[App.comeca2].P[2].getVida()+" de vida");
       
    }
    
    public void atacar() throws IOException{
      int perso;
      if(App.turno%2 != 0){
        
            System.out.println("0 - "+App.J[App.comeca1].P[0].getNome()+" VIDA "+App.J[App.comeca1].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca1].P[1].getNome()+" VIDA "+App.J[App.comeca1].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca1].P[2].getNome()+" VIDA "+App.J[App.comeca1].P[2].getVida()); 
        for(;;){
            TextInputDialog dialog = new TextInputDialog("OLA");
            dialog.setTitle(App.J[App.comeca1].getNome()+"Personagem:");
            dialog.setHeaderText("Escolha de Personagem");
            dialog.setContentText(App.J[App.comeca1].getNome()+" - Selecione o um dos seu personagens para atacar ");
            
            Optional<String> result = dialog.showAndWait();
            perso = Integer.parseInt(result.get());
            
            if(perso == 0 || perso == 1 || perso == 2){
                break;
            }else{
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado incorreto"); a1.setHeaderText(null); a1.showAndWait();
            }
        }
            System.out.println("0 - "+App.J[App.comeca2].P[0].getNome()+" VIDA "+App.J[App.comeca2].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca2].P[1].getNome()+" VIDA "+App.J[App.comeca2].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca2].P[2].getNome()+" VIDA "+App.J[App.comeca2].P[2].getVida());         
        for(;;){
            TextInputDialog dialog2 = new TextInputDialog("OLA");
             dialog2.setTitle(App.J[App.comeca1].getNome()+"Atacar:");
             dialog2.setHeaderText("Escolha de Personagem");
             dialog2.setContentText("Digite o numero que representa o Personagem inimigo que deseja atacar");
            
            Optional<String> result2 = dialog2.showAndWait();
            int op2 = Integer.parseInt(result2.get());
                            
            if(op2 == 0){
                App.J[App.comeca1].P[perso].atacar(App.tabuleiro, App.J[App.comeca2].P[0]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(op2 == 1){
                App.J[App.comeca1].P[perso].atacar(App.tabuleiro, App.J[App.comeca2].P[1]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(op2 == 2){
                 App.J[App.comeca1].P[perso].atacar(App.tabuleiro, App.J[App.comeca2].P[2]);
                 App.map.mostrarmapa(App.tabuleiro);
                 copiarTabuleiro();
                 break;
            }else{
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor para o numero do personagem atacado incorreto "); a1.setHeaderText(null); a1.showAndWait();
            } 
        }            
       App.turno++; 
       verificarVencedor(App.tabuleiro);
      }else if(App.turno%2 == 0){
            System.out.println("0 - "+App.J[App.comeca2].P[0].getNome()+" VIDA "+App.J[App.comeca2].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca2].P[1].getNome()+" VIDA "+App.J[App.comeca2].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca2].P[2].getNome()+" VIDA "+App.J[App.comeca2].P[2].getVida()); 
        for(;;){
            TextInputDialog dialog = new TextInputDialog("OLA");
            dialog.setTitle(App.J[App.comeca2].getNome()+"Personagem:");
            dialog.setHeaderText("Escolha de Personagem");
            dialog.setContentText(App.J[App.comeca2].getNome()+" - Selecione o um dos seu personagens para atacar ");
            
            Optional<String> result = dialog.showAndWait();
            perso = Integer.parseInt(result.get());
            
            if(perso == 0 || perso == 1 || perso == 2){
                break;
            }else{
               Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado incorreto"); a1.setHeaderText(null); a1.showAndWait(); 
            }
        } 
            System.out.println("0 - "+App.J[App.comeca1].P[0].getNome()+" VIDA "+App.J[App.comeca1].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca1].P[1].getNome()+" VIDA "+App.J[App.comeca1].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca1].P[2].getNome()+" VIDA "+App.J[App.comeca1].P[2].getVida());         
        for(;;){
            TextInputDialog dialog2 = new TextInputDialog("OLA");
             dialog2.setTitle(App.J[App.comeca2].getNome()+"Atacar:");
             dialog2.setHeaderText("Escolha de Personagem");
             dialog2.setContentText("Digite o numero que representa o Personagem inimigo que deseja atacar");
            
            Optional<String> result2 = dialog2.showAndWait();
            int op2 = Integer.parseInt(result2.get());
                            
            if(op2 == 0){
                App.J[App.comeca2].P[perso].atacar(App.tabuleiro, App.J[App.comeca1].P[0]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(op2 == 1){
                App.J[App.comeca2].P[perso].atacar(App.tabuleiro, App.J[App.comeca1].P[1]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(op2 == 2){
                 App.J[App.comeca2].P[perso].atacar(App.tabuleiro, App.J[App.comeca1].P[2]);
                 App.map.mostrarmapa(App.tabuleiro);
                 copiarTabuleiro();
                 break;
            }else{
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor para o numero do personagem atacado incorreto "); a1.setHeaderText(null); a1.showAndWait();
            } 
        }
        App.turno++;
        verificarVencedor(App.tabuleiro);
      }  
        
    }
    
    public void movimentar() throws IOException{
        
       if(App.turno%2 != 0){
            System.out.println("0 - "+App.J[App.comeca1].P[0].getNome()+" VIDA "+App.J[App.comeca1].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca1].P[1].getNome()+" VIDA "+App.J[App.comeca1].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca1].P[2].getNome()+" VIDA "+App.J[App.comeca1].P[2].getVida()); 
        for(;;){
            TextInputDialog dialog = new TextInputDialog("OLA");
            dialog.setTitle(App.J[App.comeca1].getNome()+"Personagem:");
            dialog.setHeaderText("Escolha de Personagem");
            dialog.setContentText(App.J[App.comeca1].getNome()+" - Selecione o um dos seu personagens para movimentar ");
            
            Optional<String> result = dialog.showAndWait();
            int perso = Integer.parseInt(result.get());
            
            if(perso == 0){
                App.map.movimentar(App.tabuleiro, App.J[App.comeca1].P[0], App.J[App.comeca1]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(perso == 1){
                App.map.movimentar(App.tabuleiro, App.J[App.comeca1].P[1], App.J[App.comeca1]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(perso == 2){
                App.map.movimentar(App.tabuleiro, App.J[App.comeca1].P[2], App.J[App.comeca1]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else{
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor invalido"); a1.setHeaderText(null); a1.showAndWait();
            }
            
        }
      App.turno++; 
      verificarVencedor(App.tabuleiro);  
      }else if(App.turno%2 == 0){
            System.out.println("0 - "+App.J[App.comeca2].P[0].getNome()+" VIDA "+App.J[App.comeca2].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca2].P[1].getNome()+" VIDA "+App.J[App.comeca2].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca2].P[2].getNome()+" VIDA "+App.J[App.comeca2].P[2].getVida()); 
        for(;;){
            TextInputDialog dialog = new TextInputDialog("OLA");
            dialog.setTitle(App.J[App.comeca2].getNome()+"Personagem:");
            dialog.setHeaderText("Escolha de Personagem");
            dialog.setContentText(App.J[App.comeca2].getNome()+" - Selecione o um dos seu personagens para movimentar ");
            
            Optional<String> result = dialog.showAndWait();
            int perso = Integer.parseInt(result.get());
            
            if(perso == 0){
                App.map.movimentar(App.tabuleiro, App.J[App.comeca2].P[0], App.J[App.comeca2]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(perso == 1){
                App.map.movimentar(App.tabuleiro, App.J[App.comeca2].P[1], App.J[App.comeca2]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else if(perso == 2){
                App.map.movimentar(App.tabuleiro, App.J[App.comeca2].P[2], App.J[App.comeca2]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
                break;
            }else{
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor invalido"); a1.setHeaderText(null); a1.showAndWait();
            }
            
        }       
       App.turno++; 
       verificarVencedor(App.tabuleiro);     
      }
     
    }
        
    public void especial() throws IOException{
        int perso;
        if(App.turno%2 != 0){
            System.out.println("0 - "+App.J[App.comeca1].P[0].getNome()+" VIDA "+App.J[App.comeca1].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca1].P[1].getNome()+" VIDA "+App.J[App.comeca1].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca1].P[2].getNome()+" VIDA "+App.J[App.comeca1].P[2].getVida());    
            for(;;){
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca1].getNome()+"Personagem:");
                dialog.setHeaderText("Escolha de Personagem");
                dialog.setContentText(App.J[App.comeca1].getNome()+" - Selecione o um dos seu personagens para usar especial ");   
                
                Optional<String> result = dialog.showAndWait();
                perso = Integer.parseInt(result.get());
                
                if(perso == 0 || perso == 1 || perso == 2){
                    break;
                }else{
                   Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado incorreto"); a1.setHeaderText(null); a1.showAndWait();  
                }                
                
            }
            
            if(App.J[App.comeca1].P[perso].getIcone()  == '$' || App.J[App.comeca1].P[perso].getIcone() == 'O'){
                App.J[App.comeca1].P[perso].ult(App.tabuleiro, App.J[App.comeca2].P[0],  App.J[App.comeca2].P[1], App.J[App.comeca2].P[2]);
                App.map.mostrarmapa(App.tabuleiro);
                copiarTabuleiro();
            }else{
                App.J[App.comeca1].P[perso].ult();
                copiarTabuleiro();
            }            
        App.turno++; 
        verificarVencedor(App.tabuleiro);          
           
        }else if(App.turno%2 == 0){
            System.out.println("0 - "+App.J[App.comeca2].P[0].getNome()+" VIDA "+App.J[App.comeca2].P[0].getVida());
            System.out.println("1 - "+App.J[App.comeca2].P[1].getNome()+" VIDA "+App.J[App.comeca2].P[1].getVida());           
            System.out.println("2 - "+App.J[App.comeca2].P[2].getNome()+" VIDA "+App.J[App.comeca2].P[2].getVida());    
            for(;;){
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle(App.J[App.comeca2].getNome()+"Personagem:");
                dialog.setHeaderText("Escolha de Personagem");
                dialog.setContentText(App.J[App.comeca2].getNome()+" - Selecione o um dos seu personagens para usar especial ");   
                
                Optional<String> result = dialog.showAndWait();
                perso = Integer.parseInt(result.get());
                
                if(perso == 0 || perso == 1 || perso == 2){
                    break;
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado incorreto"); a1.setHeaderText(null); a1.showAndWait(); 
                }                
                
            }
            
            if(App.J[App.comeca2].P[perso].getIcone()  == '$' || App.J[App.comeca2].P[perso].getIcone() == 'O'){
                App.J[App.comeca2].P[perso].ult(App.tabuleiro, App.J[App.comeca1].P[0],  App.J[App.comeca1].P[1], App.J[App.comeca1].P[2]);
                copiarTabuleiro();
            }else{
                App.J[App.comeca2].P[perso].ult();
                copiarTabuleiro();
            }            
        App.turno++; 
        verificarVencedor(App.tabuleiro);            
            
        }

    }   
       
}
